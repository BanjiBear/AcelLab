package io.acellab.service.web.startline.Controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.acellab.service.web.startline.Config.Security.CustomUserDetails;
import io.acellab.service.web.startline.Entity.BusinessPlanInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Service.User.UserService;
import io.acellab.service.web.startline.Status.ResponseFactory;
import io.acellab.service.web.startline.Status.Status;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SupportController {
	
	private static BusinessPlanInfo businessPlanInfo = new BusinessPlanInfo();

	@Autowired
	private UserService userService;

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/support")
	public String supportPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user;
		if(customUserDetails != null) {
			user = customUserDetails.getUser();
		} else {
			user = null;
		}
		model.addAttribute("user", user);
		return "support";
	}
	
	@GetMapping("/support/general")
	public String supportGeneralPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//support_GettingStarted --> support_general
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user;
		if(customUserDetails != null) {
			user = customUserDetails.getUser();
		} else {
			user = null;
		}
		model.addAttribute("user", user);
		return "support_general";
	}
	
	@GetMapping("/support/features")
	public String supportFeaturesPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user;
		if(customUserDetails != null) {
			user = customUserDetails.getUser();
		} else {
			user = null;
		}
		model.addAttribute("user", user);
		return "support_features";
	}
	
	@GetMapping("/support/settings")
	public String supportSettingsPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//support_setting --> support_settings
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user;
		if(customUserDetails != null) {
			user = customUserDetails.getUser();
		} else {
			user = null;
		}
		model.addAttribute("user", user);
		return "support_settings";
	}
	
	@GetMapping("/faq/fundinground")
	public String supportFAQFundingRoundPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//support_FAQ --> faq_funding_round
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user;
		if(customUserDetails != null) {
			user = customUserDetails.getUser();
		} else {
			user = null;
		}
		model.addAttribute("user", user);
		return "faq_funding_round";
	}
	
	@GetMapping("/faq/verification")
	public String supportFAQAccountVerifyPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//support_FAQ_verifyUser --> faq_verification
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user;
		if(customUserDetails != null) {
			user = customUserDetails.getUser();
		} else {
			user = null;
		}
		model.addAttribute("user", user);
		return "faq_verification";
	}


}
