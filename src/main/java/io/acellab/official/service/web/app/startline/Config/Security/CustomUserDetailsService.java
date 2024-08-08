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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> user = userRepository.findUserByUserName(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Username or Password not found");
        }
        return new CustomUserDetails(user.get().getUsername(), user.get().getPassword(), authorities(), user.get().getNickname());
    }

    public Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

}
