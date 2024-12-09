package io.acellab.service.web.startline.Service.User;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.acellab.service.web.startline.Config.Security.CustomUserDetailsService;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Repository.UserRepository;
import io.acellab.service.web.startline.Status.ResponseFactory;
import io.acellab.service.web.startline.Status.Status;
import io.acellab.service.web.startline.Util.Util;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private UserRepository userRepository;

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
			
			//userRepository.createNewUserFromRegister(username, password, firstname, lastname, email, isStartup, plan);
			userRepository.createNewUserFromRegister(userInfo.getUsername(), 
													userInfo.getPassword(), 
													userInfo.getFirstname(), 
													userInfo.getLastname(), 
													userInfo.getEmail(),
													true, 1);
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
}
