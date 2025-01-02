package io.acellab.service.web.startline.Service.Corporate;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import io.acellab.service.web.startline.Entity.CorporateFundingInfo;
import io.acellab.service.web.startline.Entity.CorporateInfo;
import io.acellab.service.web.startline.Entity.CorporateProductInfo;
import io.acellab.service.web.startline.Entity.CorporateTeamInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Status.ResponseFactory;

public interface CorporateService {
		
	public ResponseFactory<CorporateInfo> getUserCorporate(UserInfo user);
	
	public ResponseFactory<CorporateProductInfo> getCorporateProducts(UserInfo user);
	
	public ResponseFactory<CorporateFundingInfo> getCorporateFundings(UserInfo user);
	
	public ResponseFactory<CorporateTeamInfo> getCorporateTeam(UserInfo user);
	
	public <T> ResponseFactory<T> updateUserCorporate(@AuthenticationPrincipal UserDetails userDetails, UserInfo user, Map<String, String> corporateInfoMap);
	
	//public <T> ResponseFactory<T> fineTuneRecommendation();
	
}