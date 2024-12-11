package io.acellab.service.web.startline.Controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.acellab.service.web.startline.Config.Security.CustomUserDetails;
import io.acellab.service.web.startline.Entity.BusinessPlanInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Service.User.UserService;
import io.acellab.service.web.startline.Status.ResponseFactory;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ApplicationController {
	
	private static BusinessPlanInfo businessPlanInfo = new BusinessPlanInfo();

	@Autowired
	private UserService userService;

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/")
	public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user;
		if(customUserDetails != null) {
			user = customUserDetails.getUser();
		} else {
			user = null;
		}
		model.addAttribute("user", user);
		return "index";
	}
	
	@GetMapping("/price")
	public String pricePage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user;
		if(customUserDetails != null) {
			user = customUserDetails.getUser();
		} else {
			user = null;
		}
		model.addAttribute("user", user);
		model.addAttribute("businessplan", businessPlanInfo);
		return "price";
	}
	
	@GetMapping("/aboutus")
	public String aboutPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//whystartline --> about
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user;
		if(customUserDetails != null) {
			user = customUserDetails.getUser();
		} else {
			user = null;
		}
		model.addAttribute("user", user);
		return "about";
	}
	
	@GetMapping("/contact")
	public String contactPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//contactus --> contact
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo user;
		if(customUserDetails != null) {
			user = customUserDetails.getUser();
		} else {
			user = null;
		}
		model.addAttribute("user", user);
		return "contact";
	}
	
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
	
	@GetMapping("/debug")
	@ResponseBody
	public String debugPage(@RequestParam("message") String message) {
		return "Error: " + message;
	}
	
	@GetMapping("/test")
	//@ResponseBody is included in the @RestController annotation
	public String test() {
		return "The service is available at: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
	}
	
	
	/****************************
	 *                          *
	 *                          *
	 *       Action Paths       *
	 *                          *
	 *                          *
	 * **************************/
	
	
	@GetMapping("/startup/login")
	public String loginStartupPage(HttpServletRequest request, @AuthenticationPrincipal UserDetails userDetails, Model model) {
		//loginStartup --> login_startup
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails != null) {
			return "redirect:/home";
		}
		request.getSession().setAttribute("loginPath", "/startup/login");
		return "login_startup";
	}
	
	
	/****************************************************************/
	
	@GetMapping("/corporate/login")
	public String loginCorporatePage(HttpServletRequest request, @AuthenticationPrincipal UserDetails userDetails, Model model) {
		//loginCorporate --> login_corporate
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails != null) {
			return "redirect:/home";
		}
		request.getSession().setAttribute("loginPath", "/corporate/login");
		return "login_corporate";
	}
	
	
	/****************************************************************/
	
//	@GetMapping("/login")
//	public String loginPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
//		//loginCorporate --> login_corporate
//		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
//		if(customUserDetails != null) {
//			return "redirect:/home";
//		}
//		return "login";
//	}
	
	
	/****************************************************************/
	
	@GetMapping("/register")
	public String registerPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		//join --> register
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		if(customUserDetails != null) {
			return "redirect:/home";
		}
		model.addAttribute("userinfo", new UserInfo());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(UserInfo userInfo, Model model) {
		ResponseFactory<?> response = userService.createNewUser(userInfo);
		if(response.getStatusCode() != 201) {
			return "redirect:/debug?message=" + response.getStatusCode() + ": " + response.getStatusMessage();
		}
		return "redirect:/chooseplan";
	}
	
	@GetMapping("/chooseplan")
	public String planSelectionPage(Model model) {
		//join1 --> chooseplan.html
		return "chooseplan";
	}


}
