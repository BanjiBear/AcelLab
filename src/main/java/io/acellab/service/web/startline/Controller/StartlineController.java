package io.acellab.service.web.startline.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.acellab.service.web.startline.Config.Security.CustomUserDetails;
import io.acellab.service.web.startline.Entity.BusinessPlanInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Entity.CompanyInfo;
import io.acellab.service.web.startline.Entity.CorporateFundingInfo;
import io.acellab.service.web.startline.Entity.CorporateInfo;
import io.acellab.service.web.startline.Entity.CorporateProductInfo;
import io.acellab.service.web.startline.Entity.CorporateTeamInfo;
import io.acellab.service.web.startline.Entity.StartupFundingInfo;
import io.acellab.service.web.startline.Entity.StartupInfo;
import io.acellab.service.web.startline.Entity.StartupProductInfo;
import io.acellab.service.web.startline.Entity.StartupTeamInfo;
import io.acellab.service.web.startline.Service.User.UserService;
import io.acellab.service.web.startline.Service.Company.CompanyService;
import io.acellab.service.web.startline.Service.Corporate.CorporateService;
import io.acellab.service.web.startline.Service.Startup.StartupService;
import io.acellab.service.web.startline.Status.ResponseFactory;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StartlineController {
	

	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private StartupService startupService;
	
	@Autowired
	private CorporateService corporateService;
	
	@Autowired
	private ArrayList<String> countriesList;
	
	@Autowired
	private ArrayList<String> industriesList;
	
	@Autowired
	private ArrayList<String> countryCodesList;
	
	@Autowired
	private ArrayList<String> fundingsRoundList;
	
	
	private Object[] CompanyObjectCache = null;
	private Long companyIDCache = null;
	
	@GetMapping("/home")
	public String homePage(
			@AuthenticationPrincipal UserDetails userDetails, 
			Model model, 
			RedirectAttributes redirectAttributes) {
		//GetStarted --> home
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		ResponseFactory<?> response = companyService.getCompaniesList();
		if(response.getStatusCode() != 200 && response.getStatusCode() != 404) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("user", user);
		model.addAttribute("response", response);
		return "home";
	}
	
	@GetMapping("/search")
	public String searchPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			Model model, 
			RedirectAttributes redirectAttributes) {
		//Search --> search
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		ResponseFactory<?> response = companyService.getCompaniesList();
		if(response.getStatusCode() != 200 && response.getStatusCode() != 404) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		
		ResponseFactory<?> bookmarks = companyService.getBookmarkedCompanyID(user);
		if(bookmarks.getStatusCode() != 200) {
			redirectAttributes.addFlashAttribute("errorCode", bookmarks.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", bookmarks.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("user", user);
		model.addAttribute("bookmarked_company", new CompanyInfo());
		model.addAttribute("response", response);
		model.addAttribute("fundingrounds", fundingsRoundList);
		model.addAttribute("bookmarks", bookmarks.getReturnDataList());
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
			Model model, 
			RedirectAttributes redirectAttributes){
		
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		ResponseFactory<?> response = companyService.searchCompanies(search, location, industry, fundinground, bookmark);
		if(response.getStatusCode() != 200 && response.getStatusCode() != 404){
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		
		ResponseFactory<?> bookmarks = companyService.getBookmarkedCompanyID(user);
		if(bookmarks.getStatusCode() != 200) {
			redirectAttributes.addFlashAttribute("errorCode", bookmarks.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", bookmarks.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("user", user);
		model.addAttribute("bookmarked_company", new CompanyInfo());
		model.addAttribute("response", response);
		model.addAttribute("fundingrounds", fundingsRoundList);
		model.addAttribute("bookmarks", bookmarks.getReturnDataList());
		return "search";
	}
	
	@GetMapping("/profile/startup")
	public String profileStartupPage(@AuthenticationPrincipal UserDetails userDetails, Model model, RedirectAttributes redirectAttributes) {
		//ProfileStartup --> profile_startup
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) return "redirect:/startup/login";
		UserInfo user = customUserDetails.getUser();
		if(!user.getAccountType()) return "redirect:/profile/corporate";
		model.addAttribute("user", user);
		
		ResponseFactory<?> response = startupService.getUserStartup(user);
		if(response.getStatusCode() != 200) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("startup", response.getReturnDataList().get(0));
		
		response = startupService.getStartupProducts(user);
		if(response.getStatusCode() != 200) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("products", response.getReturnDataList());
		
		response = startupService.getStartupFundings(user);
		if(response.getStatusCode() != 200) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("fundings", response.getReturnDataList());
		
		response = startupService.getStartupTeam(user);
		if(response.getStatusCode() != 200) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("members", response.getReturnDataList());		
		
		model.addAttribute("countries", countriesList);
		model.addAttribute("industries", industriesList);
		model.addAttribute("countrycodes", countryCodesList);
		model.addAttribute("fundingrounds", fundingsRoundList);
		return "profile_startup";
	}
	
	@GetMapping("/profile/corporate")
	public String profileCorporatePage(@AuthenticationPrincipal UserDetails userDetails, Model model, RedirectAttributes redirectAttributes) {
		//ProfileCorporate --> profile_corporate
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) return "redirect:/corporate/login";
		UserInfo user = customUserDetails.getUser();
		if(user.getAccountType()) return "redirect:/profile/startup";
		model.addAttribute("user", user);
		
		ResponseFactory<?> response = corporateService.getUserCorporate(user);
		if(response.getStatusCode() != 200) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("corporate", response.getReturnDataList().get(0));
		
		response = corporateService.getCorporateProducts(user);
		if(response.getStatusCode() != 200) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("products", response.getReturnDataList());
		
		response = corporateService.getCorporateFundings(user);
		if(response.getStatusCode() != 200) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("fundings", response.getReturnDataList());
		
		response = corporateService.getCorporateTeam(user);
		if(response.getStatusCode() != 200) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		model.addAttribute("members", response.getReturnDataList());
		
		model.addAttribute("countries", countriesList);
		model.addAttribute("industries", industriesList);
		model.addAttribute("countrycodes", countryCodesList);
		model.addAttribute("fundingrounds", fundingsRoundList);
		return "profile_corporate";
	}
	
	@GetMapping("/settings/account")
	public String settingsAccountPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//Settings_account_billing --> account
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		model.addAttribute("newUser", user);
		return "account";
	}
	
	@GetMapping("/settings/team")
	public String settingsTeamPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//Settings_team --> team
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) return "redirect:/corporate/login";
		UserInfo user = customUserDetails.getUser();
		if(!user.getAccountType() && user.getBusinessPlan() != 3) return "redirect:/settings/plan";
		model.addAttribute("user", user);
		return "team";
	}
	
	@GetMapping("/settings/bookmark")
	public String settingsBookmarkPage(@AuthenticationPrincipal UserDetails userDetails, Model model, RedirectAttributes redirectAttributes) {
		//Settings_bookmark --> bookmark
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) return "redirect:/corporate/login";
		UserInfo user = customUserDetails.getUser();
		if(user.getAccountType()) return "redirect:/settings/plan";
		
		ResponseFactory<CompanyInfo> response = companyService.getBookmarks(user);
		if(response.getStatusCode() != 200){
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		
		model.addAttribute("user", user);
		model.addAttribute("bookmarks", response.getReturnDataList());
		return "bookmark";
	}
	
	@GetMapping("/settings/plan")
	public String settingsPlanPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//Settings_plan --> plan
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		model.addAttribute("user", user);
		return "plan";
	}
	
	@GetMapping("/company/info")
	public String companyInfoPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam(name = "id", defaultValue = "", required = true) Long companyid,
			Model model, 
			RedirectAttributes redirectAttributes) {
		//CompanyContent_BasicInformation --> company_info
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(companyIDCache == null || companyid != companyIDCache) {
			ResponseFactory<?> response = companyService.getCompanyDetails(companyid);
			if(response.getStatusCode() != 200) {
				redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
				redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
				return "redirect:/error";
			}
			CompanyObjectCache = response.getReturnDataObjects();
		}
		model.addAttribute("user", user);
		model.addAttribute("company", CompanyObjectCache[0]);
		return "company_info";
	}
	
	@GetMapping("/company/products")
	public String companyProductPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam(name = "id", defaultValue = "", required = true) Long companyid,
			Model model, 
			RedirectAttributes redirectAttributes) {
		//CompanyContent_Product --> company_products
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(companyIDCache == null || companyid != companyIDCache) {
			ResponseFactory<?> response = companyService.getCompanyDetails(companyid);
			if(response.getStatusCode() != 200) {
				redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
				redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
				return "redirect:/error";
			}
			CompanyObjectCache = response.getReturnDataObjects();
		}
		model.addAttribute("user", user);
		model.addAttribute("company", CompanyObjectCache[0]);
		model.addAttribute("products", CompanyObjectCache[1]);
		return "company_products";
	}
	
	@GetMapping("/company/finance")
	public String companyFinancePage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam(name = "id", defaultValue = "", required = true) Long companyid,
			Model model, 
			RedirectAttributes redirectAttributes) {
		//CompanyContent_Finance --> company_finance
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(companyIDCache == null || companyid != companyIDCache) {
			ResponseFactory<?> response = companyService.getCompanyDetails(companyid);
			if(response.getStatusCode() != 200) {
				redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
				redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
				return "redirect:/error";
			}
			CompanyObjectCache = response.getReturnDataObjects();
		}
		model.addAttribute("user", user);
		model.addAttribute("company", CompanyObjectCache[0]);
		model.addAttribute("fundings", CompanyObjectCache[2]);
		return "company_finance";
	}
	
	@GetMapping("/company/team")
	public String companyContactPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam(name = "id", defaultValue = "", required = true) Long companyid,
			Model model, 
			RedirectAttributes redirectAttributes) {
		//CompanyContent_Contacts --> company_contact
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(companyIDCache == null || companyid != companyIDCache) {
			ResponseFactory<?> response = companyService.getCompanyDetails(companyid);
			if(response.getStatusCode() != 200) {
				redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
				redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
				return "redirect:/error";
			}
			CompanyObjectCache = response.getReturnDataObjects();
		}
		model.addAttribute("user", user);
		model.addAttribute("company", CompanyObjectCache[0]);
		return "company_contact";
	}
	
	@GetMapping("/company/location")
	public String companyLocationPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam(name = "id", defaultValue = "", required = true) Long companyid,
			Model model,
			RedirectAttributes redirectAttributes) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(companyIDCache == null || companyid != companyIDCache) {
			ResponseFactory<?> response = companyService.getCompanyDetails(companyid);
			if(response.getStatusCode() != 200) {
				redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
				redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
				return "redirect:/error";
			}
			CompanyObjectCache = response.getReturnDataObjects();
		}
		model.addAttribute("user", user);
		model.addAttribute("company", CompanyObjectCache[0]);
		return "company_location";
	}
	
	
	/****************************************************************/
	
	@PostMapping("/updateuserinfo")
	public String updateUserInfo(
			@AuthenticationPrincipal UserDetails userDetails, 
			UserInfo newUser, 
			Model model, 
			RedirectAttributes redirectAttributes) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo oldUser = customUserDetails.getUser();
		ResponseFactory<?> response = userService.updateUser(oldUser, newUser);
		if(response.getStatusCode() != 202) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		
		return "redirect:/settings/account";
	}
	
	@PostMapping("/addbookmark")
	public String addCompanyBookmark(
			HttpServletRequest request,
			@AuthenticationPrincipal UserDetails userDetails, 
			@ModelAttribute("bookmarked_company") CompanyInfo bookmarked_company, 
			Model model,
			RedirectAttributes redirectAttributes) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(user.getAccountType()) return "redirect:/error";
		//Consider if it is not necessary to pass userDetails
		ResponseFactory<?> response = companyService.addCompanyToBookmark(userDetails, user.getUserId(), bookmarked_company.getId());
		if(response.getStatusCode() != 202) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		
		return "redirect:" + request.getHeader(HttpHeaders.REFERER).replace(request.getHeader(HttpHeaders.ORIGIN), "");
	}
	
	@PostMapping("/deletebookmark")
	public String deleteCompanyBookmark(
			@AuthenticationPrincipal UserDetails userDetails,
			@RequestParam("company_id") Long companyId, 
			Model model,
			RedirectAttributes redirectAttributes) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(user.getAccountType()) return "redirect:/error";
		
		ResponseFactory<?> response = companyService.deleteBookmark(user, companyId);
		if(response.getStatusCode() != 203) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		return "redirect:/settings/bookmark";
	}
	
	@PostMapping("/updatestartupinfo")
	public String updateStartupInfo(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam("dataMap") String startupInfoString,
			Model model, 
			RedirectAttributes redirectAttributes) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(!user.getAccountType()) return "redirect:/error";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, String> startupInfoMap = mapper.readValue(startupInfoString, new TypeReference<Map<String, String>>() {});
			//for (Map.Entry<String, String> entry : startupInfoMap.entrySet()) {
			//	System.out.println(entry.getKey() + " : " + entry.getValue());
			//}
			ResponseFactory<?> response = startupService.updateUserStartup(userDetails, user, startupInfoMap);
			if(response.getStatusCode() != 202) {
				redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
				redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
				return "redirect:/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		
		return "redirect:/profile/startup";
	}
	
	
	
	@PostMapping("/updatecorporateinfo")
	public String updateCorporateInfo(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam("dataMap") String corporateInfoString,
			Model model, 
			RedirectAttributes redirectAttributes) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/corporate/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(user.getAccountType()) return "redirect:/error";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, String> corporateInfoMap = mapper.readValue(corporateInfoString, new TypeReference<Map<String, String>>() {});
			ResponseFactory<?> response = corporateService.updateUserCorporate(userDetails, user, corporateInfoMap);
			if(response.getStatusCode() != 202) {
				redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
				redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
				return "redirect:/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		
		return "redirect:/profile/corporate";
	}
	
	
	@PostMapping("/inviteuser")
	public String inviteUserEmail(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam("email") String email,
			Model model, 
			RedirectAttributes redirectAttributes) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/corporate/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(user.getAccountType()) return "redirect:/error";
		
		ResponseFactory<?> response = corporateService.addScheduledEmail(user, email, "INVITATION", true);
		if(response.getStatusCode() != 201) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		return "redirect:/profile/corporate";
	}
	
	
	@PostMapping("/verifystartup")
	public String verifyStartupEmail(
			@AuthenticationPrincipal UserDetails userDetails, 
			Model model, 
			RedirectAttributes redirectAttributes) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/startup/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(!user.getAccountType()) return "redirect:/error";
		
		ResponseFactory<?> response = startupService.addScheduledEmail(user, user.getEmail(), "VALIDATION", false);
		if(response.getStatusCode() != 201) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		return "redirect:/profile/startup";
	}
	
	
	@PostMapping("/verifycorporate")
	public String verifyCorporateEmail(
			@AuthenticationPrincipal UserDetails userDetails, 
			Model model, 
			RedirectAttributes redirectAttributes) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/corporate/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(!user.getAccountType()) return "redirect:/error";
		
		ResponseFactory<?> response = corporateService.addScheduledEmail(user, user.getEmail(), "VALIDATION", false);
		if(response.getStatusCode() != 201) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		return "redirect:/profile/corporate";
	}
	
	@PostMapping("/finetunerecommendationmodel")
	public String updateAIModelParam(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam("answer1") String answer1, 
			@RequestParam("answer2") String answer2, 
			Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails == null) {
			return "redirect:/corporate/login";
		}
		UserInfo user = customUserDetails.getUser();
		if(user.getAccountType()) return "redirect:/error";
		//System.out.println("answer1 : " + answer1);
		//System.out.println("answer2 : " + answer2);
		
		return "redirect:/profile/corporate";
	}


}
