package io.acellab.service.web.startline.Service.User;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import io.acellab.service.web.startline.Config.Security.CustomUserDetails;
import io.acellab.service.web.startline.Config.Security.CustomUserDetailsService;
import io.acellab.service.web.startline.Entity.CollaboratorsInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Repository.CollaboratorsRepository;
import io.acellab.service.web.startline.Repository.UserRepository;
import io.acellab.service.web.startline.Status.ResponseFactory;
import io.acellab.service.web.startline.Status.Status;
import io.acellab.service.web.startline.Util.Util;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	//@Autowired
	//private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CollaboratorsRepository collaboratorsRepository;

	@Override
	@Transactional
	public <T> ResponseFactory<T> createNewUser(UserInfo userInfo) {
		Optional<UserInfo> user;
		
		String username = userInfo.getUsername();
		String password = userInfo.getPassword();
		String email = userInfo.getEmail();
		
		//Step 1: verify unique username
		user = userRepository.findUserByUsername(username);
		if(!user.isEmpty()) {
			return Util.responseFormation(Status.EXISTING_USERNAME);
		} else if(!Util.isValidUsername(username)) {
			return Util.responseFormation(Status.USER_REGISTER_INVALID_USERNAME_FORMAT);
		}
		
		//Step 2: check password format
		if(!Util.isValidPassword(password)) {
			return Util.responseFormation(Status.USER_REGISTER_INVALID_PASSWORD_FORMAT);
		}
		
		//Step 3: verify unique email
		user = userRepository.findUserByEmail(email);
		if(!user.isEmpty()) {
			return Util.responseFormation(Status.EXISTING_EMAIL);
		} else if(!Util.isValidEmailFormat(email)) {
			return Util.responseFormation(Status.USER_REGISTER_INVALID_EMAIL_FORMAT);
		}
		
		try {
			userInfo.setPassword(new BCryptPasswordEncoder().encode(password));
			
			//userRepository.createNewUserFromRegister(username, password, firstname, lastname, email, isStartup, plan, is_admin, is_active, is_system_generated, is_expired);
			userRepository.createNewUserFromRegister(userInfo.getUsername(), 
													userInfo.getPassword(), 
													userInfo.getFirstname(), 
													userInfo.getLastname(), 
													userInfo.getEmail(),
													true, 1,
													true, true, false, false);
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.NEW_DATA_CREATED);
	}

	@Override
	@Transactional
	public <T> ResponseFactory<T> updateUser(UserInfo oldUser, UserInfo newUser) {		
		String firstname = newUser.getFirstname();	  //required in frontend  //checked in frontend
		String lastname = newUser.getLastname();	  //required in frontend  //checked in frontend
		String department = newUser.getDepartment();  //required in frontend  //checked in frontend
		String role = newUser.getRole();			  //required in frontend  //checked in frontend
		String email = newUser.getEmail();			  //required in frontend
		String phone = newUser.getPhone();			  //required in frontend 
		String linkedIn = newUser.getLinkedIn();	  //required in frontend 
		String username = newUser.getUsername();	  //required in frontend
		String password = newUser.getPassword();
		
		Optional<UserInfo> user;
		//Step 1: Check for formats
		//username
		if(!oldUser.getUsername().equals(username)) {
			user = userRepository.findUserByUsername(username);
			if(!user.isEmpty()) {
				return Util.responseFormation(Status.EXISTING_USERNAME);
			} else if(!Util.isValidUsername(username)) {
				return Util.responseFormation(Status.USER_REGISTER_INVALID_USERNAME_FORMAT);
			}
		}
		//password
		if(password != "") {
			if(!Util.isValidPassword(password)) {
				return Util.responseFormation(Status.USER_REGISTER_INVALID_PASSWORD_FORMAT);
			}
		}
		//email
		if(!oldUser.getEmail().equals(email)) {
			user = userRepository.findUserByEmail(email);
			if(!user.isEmpty()) {
				return Util.responseFormation(Status.EXISTING_EMAIL);
			} else if(!Util.isValidEmailFormat(email)) {
				return Util.responseFormation(Status.USER_REGISTER_INVALID_EMAIL_FORMAT);
			}
		}
		//firstname, lastname, department, role
		if(!(Util.isValidAccountUpdateInputFormat(firstname) && 
				Util.isValidAccountUpdateInputFormat(lastname) && 
				Util.isValidAccountUpdateInputFormat(department) && 
				Util.isValidAccountUpdateInputFormat(role))) {
			return Util.responseFormation(Status.USER_ACCOUNT_UPDATE_INVALID_INPUT_FORMAT);
		}
		//Step 2: Update UserInfo
		try {
			if(password != "") {
				password = new BCryptPasswordEncoder().encode(password);
			} else {
				password = oldUser.getPassword();
			}
			
			//userRepository.updateUserByID(firstname, lastname, department, role, email, phone, linkedIn, username, password, null);
			userRepository.updateUserByID(
					firstname, 
					lastname, 
					department, 
					role, 
					email, 
					phone, 
					linkedIn, 
					username, 
					password, 
					oldUser.getUserId());
			
			// Reload user details
	        UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
	        // Update SecurityContext with new user details
	        SecurityContextHolder.getContext().setAuthentication(
	            new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities())
	        );
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.DATA_UPDATED);
	}

	@Override
	public <T> ResponseFactory<T> setNewUserPlanAfterPayment(UserInfo userInfo, String plan) {
		try {
			Optional<UserInfo> u = userRepository.findUserByEmail(userInfo.getEmail());
			if(u.isEmpty()) {
				return Util.responseFormation(Status.SECURITY_REGISTERED_USER_NOT_FOUND);
			}
			Long userid = u.get().getUserId();
			
			if(plan.equals("startup")) {
				userRepository.updateUserPlan(true, (long)1, userid);
			} else if(plan.equals("free")) {
				userRepository.updateUserPlan(false, (long)1, userid);
			} else if(plan.equals("business")) {
				userRepository.updateUserPlan(false, (long)2, userid);
			} else if(plan.equals("enterprise")) {
				userRepository.updateUserPlan(false, (long)3, userid);
				CollaboratorsInfo collab = new CollaboratorsInfo();
				collab.setCollabId1(u.get());
				CollaboratorsInfo newcollaborators = collaboratorsRepository.save(collab);
				collaboratorsRepository.addCollaboratorsMappingInCollabGroupInfo(userid, newcollaborators.getId());
			} else {
				return Util.responseFormation(Status.SECURITY_INVALID_PLANNAME);
			}
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		return Util.responseFormation(Status.DATA_UPDATED);
	}

	/*@Override
	public <T> ResponseFactory<T> userLoginUponSuccessRegistration(UserInfo userInfo, HttpServletRequest request) {
		// Reload user details
	    UserDetails userDetails = customUserDetailsService.loadUserByUsername(userInfo.getEmail());
	    Optional<UserInfo> u = userRepository.findUserByEmail(userInfo.getEmail());
	    if(u.isEmpty()) {
	    	return null;
	    }
	    System.out.println("Attempting to log in with email: " + userInfo.getEmail());
	    System.out.println("Raw password: " + userInfo.getPassword());
	    System.out.println("Encoded password in DB: " + userDetails.getPassword());
	    // Create authentication token with raw password
	    SecurityContextHolder.getContext().setAuthentication(
	    		new UsernamePasswordAuthenticationToken(
	    	    		userInfo.getEmail(), userInfo.getPassword(), userDetails.getAuthorities())
	        );
	    System.out.println("Authentication successful: " + SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
	    
	    HttpSession session = request.getSession();
	    session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
	            SecurityContextHolder.getContext());
	    return null;
	}*/
}
