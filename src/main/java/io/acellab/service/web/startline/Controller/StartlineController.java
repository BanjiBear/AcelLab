package io.acellab.service.web.startline.Controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.acellab.service.web.startline.Config.Security.CustomUserDetails;
import io.acellab.service.web.startline.Entity.BusinessPlanInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Entity.CompanyInfo;
import io.acellab.service.web.startline.Service.User.UserService;
import io.acellab.service.web.startline.Service.Company.CompanyService;
import io.acellab.service.web.startline.Status.ResponseFactory;
import jakarta.servlet.http.HttpServletRequest;

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
		model.addAttribute("response", companyService.getCompaniesList());
		return "home";
	}
	
	@GetMapping("/search")
	public String searchPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//Search --> search
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		
		model.addAttribute("user", user);
		model.addAttribute("bookmarked_company", new CompanyInfo());
		model.addAttribute("response", companyService.getCompaniesList());
		return "search";
	}
	
	@GetMapping("/companies")
	public String searchWithDataPage(
			@AuthenticationPrincipal UserDetails userDetails,
			@RequestParam(name = "search", defaultValue = "", required = true) String search,
			@RequestParam(name = "location", defaultValue = "", required = true) String location,
			@RequestParam(name = "industry", defaultValue = "", required = true) String industry,
			@RequestParam(name = "fundinground", defaultValue = "", required = true) String fundinground,
			@RequestParam(name = "bookmark", defaultValue = "", required = true) String bookmark,
			Model model){
		
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		
		model.addAttribute("user", user);
		model.addAttribute("bookmarked_company", new CompanyInfo());
		model.addAttribute("response", companyService.searchCompanies(search, location, industry, fundinground, bookmark));
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
	public String companyInfoPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam(name = "id", defaultValue = "", required = true) Long companyid,
			Model model) {
		//CompanyContent_BasicInformation --> company_info
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		model.addAttribute("company", companyService.getCompanyDetails(companyid).getReturnDataList().get(0));
		System.out.println(companyService.getCompanyDetails(companyid).getReturnDataList().get(0).getIntroduction());
		return "company_info";
	}
	
	@GetMapping("/company/products")
	public String companyProductPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam(name = "id", defaultValue = "", required = true) Long companyid,
			Model model) {
		//CompanyContent_Product --> company_products
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		model.addAttribute("company", companyService.getCompanyDetails(companyid).getReturnDataList().get(0));
		return "company_products";
	}
	
	@GetMapping("/company/finance")
	public String companyFinancePage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam(name = "id", defaultValue = "", required = true) Long companyid,
			Model model) {
		//CompanyContent_Finance --> company_finance
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		model.addAttribute("company", companyService.getCompanyDetails(companyid).getReturnDataList().get(0));
		return "company_finance";
	}
	
	@GetMapping("/company/team")
	public String companyContactPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam(name = "id", defaultValue = "", required = true) Long companyid,
			Model model) {
		//CompanyContent_Contacts --> company_contact
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		model.addAttribute("company", companyService.getCompanyDetails(companyid).getReturnDataList().get(0));
		return "company_contact";
	}
	
	@GetMapping("/company/location")
	public String companyLocationPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam(name = "id", defaultValue = "", required = true) Long companyid,
			Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		model.addAttribute("company", companyService.getCompanyDetails(companyid).getReturnDataList().get(0));
		return "company_location";
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
	
	@PostMapping("/addbookmark")
	public String addCompanyBookmark(
			HttpServletRequest request,
			@AuthenticationPrincipal UserDetails userDetails, 
			@ModelAttribute("bookmarked_company") CompanyInfo bookmarked_company, 
			Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user = customUserDetails.getUser();
		//Consider if it is not necessary to pass userDetails
		ResponseFactory<?> response = companyService.addCompanyToBookmark(userDetails, user.getUserId(), bookmarked_company.getId());
		if(response.getStatusCode() != 202) {
			return "redirect:/debug?message=" + response.getStatusCode() + ": " + response.getStatusMessage();
		}
		
		return "redirect:" + request.getHeader(HttpHeaders.REFERER).replace(request.getHeader(HttpHeaders.ORIGIN), "");
	}


}
