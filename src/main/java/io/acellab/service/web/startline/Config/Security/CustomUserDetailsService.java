package io.acellab.service.web.startline.Config.Security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Repository.UserRepository;



@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserInfo> user = userRepository.findUserByEmail(email);
		
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		} else {
			userRepository.updateSystemUserStatusAfterLoginByID(user.get().getUserId());
		}

		return new CustomUserDetails(user.get());
	}

}
