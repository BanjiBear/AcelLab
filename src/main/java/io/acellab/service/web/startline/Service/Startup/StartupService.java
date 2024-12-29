package io.acellab.service.web.startline.Service.Startup;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import io.acellab.service.web.startline.Entity.StartupFundingInfo;
import io.acellab.service.web.startline.Entity.StartupInfo;
import io.acellab.service.web.startline.Entity.StartupProductInfo;
import io.acellab.service.web.startline.Entity.StartupTeamInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Status.ResponseFactory;

public interface StartupService {
		
	public ResponseFactory<StartupInfo> getUserStartup(UserInfo user);
	
	public ResponseFactory<StartupProductInfo> getStartupProducts(UserInfo user);
	
	public ResponseFactory<StartupFundingInfo> getStartupFundings(UserInfo user);
	
	public ResponseFactory<StartupTeamInfo> getStartupTeam(UserInfo user);
	
	public <T> ResponseFactory<T> updateUserStartup(@AuthenticationPrincipal UserDetails userDetails, UserInfo user, Map<String, String> startupInfoMap);
	
}