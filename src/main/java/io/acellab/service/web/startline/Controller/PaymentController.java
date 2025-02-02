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
import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	
	private static BusinessPlanInfo businessPlanInfo = new BusinessPlanInfo();

	@Autowired
	private UserService userService;
	
	@GetMapping("/chooseplan")
	public String planSelectionPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			Model model, 
			HttpServletRequest request) {
		//join1 --> chooseplan.html
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		return "chooseplan";
	}

	@PostMapping("/payment")
	public String supportPage(
			@AuthenticationPrincipal UserDetails userDetails, 
			@RequestParam("plan") String plan, 
			Model model,
			RedirectAttributes redirectAttributes, 
			HttpServletRequest request) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		System.out.println(plan + "\n\n\n\n\n\n\n\n\n");
		System.out.println(userInfo.getEmail() + "\n\n\n\n\n\n\n\n\n");
		ResponseFactory<?> response = userService.setNewUserPlanAfterPayment(userInfo, plan);
		if(response.getStatusCode() != 202) {
			redirectAttributes.addFlashAttribute("errorCode", response.getStatusCode());
			redirectAttributes.addFlashAttribute("errorMsg", response.getStatusMessage());
			return "redirect:/error";
		}
		
		return "redirect:/startup/login";
	}


}
