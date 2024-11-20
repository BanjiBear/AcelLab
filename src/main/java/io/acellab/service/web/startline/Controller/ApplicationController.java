package io.acellab.service.web.startline.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.acellab.service.web.startline.Service.User.UserService;

@Controller
public class ApplicationController {

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


}
