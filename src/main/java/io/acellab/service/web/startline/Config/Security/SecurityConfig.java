package io.acellab.service.web.startline.Config.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import io.acellab.service.web.startline.Util.UserPlan;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	CustomUserDetailsService customUserDetailsService;
	@Autowired
    private CustomRequestFilter requestFilter;

	@Bean
	public static PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((authz) -> authz
						.requestMatchers("/*").permitAll()
						.requestMatchers("/images/**").permitAll()
						.requestMatchers("/css/**").permitAll()
						.requestMatchers("/js/**").permitAll()
						
						.requestMatchers("/startup/login").permitAll()
						.requestMatchers("/corporate/login").permitAll()
						
						
						//.requestMatchers("/home").hasAuthority(UserPlan.STARTUP.getPlanName())
						.requestMatchers("/home").authenticated()
						.requestMatchers("/search").authenticated()
						
						.requestMatchers("/profile/startup").authenticated()
						.requestMatchers("/profile/corporate").authenticated()
						
						.requestMatchers("/settings/account").authenticated()
						.requestMatchers("/settings/team").authenticated()
						.requestMatchers("/settings/bookmark").authenticated()
						.requestMatchers("/settings/plan").authenticated()
						
						.requestMatchers("/company/info").authenticated()
						.requestMatchers("/company/products").authenticated()
						.requestMatchers("/company/finance").authenticated()
						.requestMatchers("/company/contact").authenticated()
						.anyRequest().authenticated()
						//.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/startup/login")
						.loginProcessingUrl("/startup/login")
						.defaultSuccessUrl("/home", true)
						.failureUrl("/startup/login?error=true")
						//.successHandler(customSuccessHandler())
						.permitAll()
				)
				.logout((logout) -> logout
						.invalidateHttpSession(true)
						.clearAuthentication(true)
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/login")
				).exceptionHandling(exception -> exception
						.accessDeniedPage("/debug?message=")
				);
		
		http.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}

	@Bean
	public AuthenticationSuccessHandler customSuccessHandler() {
		return new CustomAuthenticationSuccessHandler();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}


}
