package io.acellab.official.service.web.app.startline.Config.Security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import io.acellab.official.service.web.app.startline.Entity.UserEntity;
import io.acellab.official.service.web.app.startline.Repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findUserByUserName(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        String userRole = userRepository.findRoleByUsername(username).get();

        return new CustomUserDetails(user.get().getUsername(),user.get().getPassword(), authorities(userRole));
    }

    public Collection<? extends GrantedAuthority> authorities(String userRole) {
        return Arrays.asList(new SimpleGrantedAuthority(dataToAuthorityRole(userRole)));
    }

    public String dataToAuthorityRole(String role) {
        return UserRole.getAuthorityName(role);
    }


}
