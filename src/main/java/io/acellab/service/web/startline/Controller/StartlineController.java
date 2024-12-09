package io.acellab.service.web.startline.Controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.acellab.service.web.startline.Config.Security.CustomUserDetails;
import io.acellab.service.web.startline.Entity.BusinessPlanInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Entity.CompanyInfo;
import io.acellab.service.web.startline.Service.User.UserService;
import io.acellab.service.web.startline.Service.Company.CompanyService;
import io.acellab.service.web.startline.Status.ResponseFactory;

@Controller
public class StartlineController {
	

	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;

	
	@GetMapping("/home")
	public String homePage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//GetStarted --> home
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "home";
	}
	
	@GetMapping("/search")
	public String searchPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//Search --> search
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		
		model.addAttribute("user", user);
		model.addAttribute("response", companyService.getCompaniesList());
		return "search";
	}
	
	@GetMapping("/profile/startup")
	public String profileStartupPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//ProfileStartup --> profile_startup
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "profile_startup";
	}
	
	@GetMapping("/profile/corporate")
	public String profileCorporatePage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//ProfileCorporate --> profile_corporate
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "profile_corporate";
	}
	
	@GetMapping("/settings/account")
	public String settingsAccountPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//Settings_account_billing --> account
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		model.addAttribute("newUser", user);
		return "account";
	}
	
	@GetMapping("/settings/team")
	public String settingsTeamPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//Settings_team --> team
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "team";
	}
	
	@GetMapping("/settings/bookmark")
	public String settingsBookmarkPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//Settings_bookmark --> bookmark
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "bookmark";
	}
	
	@GetMapping("/settings/plan")
	public String settingsPlanPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//Settings_plan --> plan
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "plan";
	}
	
	@GetMapping("/company/info")
	public String companyInfoPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//CompanyContent_BasicInformation --> company_info
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "company_info";
	}
	
	@GetMapping("/company/products")
	public String companyProductPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//CompanyContent_Product --> company_products
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "company_products";
	}
	
	@GetMapping("/company/finance")
	public String companyFinancePage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//CompanyContent_Finance --> company_finance
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "company_finance";
	}
	
	@GetMapping("/company/contact")
	public String companyContactPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//CompanyContent_Contacts --> company_contact
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "company_contact";
	}
	
	
	/****************************************************************/
	
	@PostMapping("/updateuserinfo")
	public String updateUserInfo(@AuthenticationPrincipal UserDetails userDetails, UserInfo newUser, Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo oldUser = customUserDetails.getUser();
		ResponseFactory<?> response = userService.updateUser(oldUser, newUser);
		if(response.getStatusCode() != 202) {
			return "redirect:/debug?message=" + response.getStatusCode() + ": " + response.getStatusMessage();
		}
		
		return "redirect:/settings/account";
	}


}
