package io.acellab.service.web.startline.Controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.acellab.service.web.startline.Entity.BusinessPlanInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Service.User.UserService;
import io.acellab.service.web.startline.Status.ResponseFactory;

@Controller
public class ApplicationController {
	
	private static BusinessPlanInfo businessPlanInfo = new BusinessPlanInfo();

	@Autowired
	private UserService userService;

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	@GetMapping("/price")
	public String pricePage(Model model) {
		model.addAttribute("businessplan", businessPlanInfo);
		return "price";
	}
	
	@GetMapping("/aboutus")
	public String aboutPage(Model model) {
		//whystartline --> about
		return "about";
	}
	
	@GetMapping("/contact")
	public String contactPage(Model model) {
		//contactus --> contact
		return "contact";
	}
	
	@GetMapping("/support")
	public String supportPage(Model model) {
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
	public String loginStartupPage(Model model) {
		//loginStartup --> login_startup
		return "login_startup";
	}
	
	@GetMapping("/corporate/login")
	public String loginCorporatePage(Model model) {
		//loginCorporate --> login_corporate
		return "login_corporate";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		//join --> register
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