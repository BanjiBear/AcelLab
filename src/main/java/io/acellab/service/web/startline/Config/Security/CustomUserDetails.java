package io.acellab.service.web.startline.Config.Security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Util.UserPlan;



public class CustomUserDetails implements UserDetails {

	private UserInfo user;
	
	public CustomUserDetails(UserInfo user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.user.getAccountType()) {
			return Collections.singleton(new SimpleGrantedAuthority(UserPlan.STARTUP.getPlanName()));
		} 
		
		// Not Startup Account
		else {
			if(this.user.getBusinessPlan().getPlanId() == UserPlan.FREE_PLAN.getPlanValue()) {
				return Collections.singleton(new SimpleGrantedAuthority(UserPlan.FREE_PLAN.getPlanName()));
			}
			else if(this.user.getBusinessPlan().getPlanId() == UserPlan.BUSINESS_PLAN.getPlanValue()) {
				return Collections.singleton(new SimpleGrantedAuthority(UserPlan.BUSINESS_PLAN.getPlanName()));
			}
			else if(this.user.getBusinessPlan().getPlanId() == UserPlan.ENTERPRISE_PLAN.getPlanValue()) {
				return Collections.singleton(new SimpleGrantedAuthority(UserPlan.ENTERPRISE_PLAN.getPlanName()));
			}
		}
		return Collections.singleton(new SimpleGrantedAuthority(UserPlan.ERROR.getPlanName()));
	}

	@Override
	public String getPassword() { return this.user.getPassword(); }

	@Override
	public String getUsername() { return this.user.getUsername(); }

	@Override
	public boolean isAccountNonExpired() { return true; }

	@Override
	public boolean isAccountNonLocked() { return true; }

	@Override
	public boolean isCredentialsNonExpired() { return true; }

	@Override
	public boolean isEnabled() { return true; }
}
