package io.acellab.service.web.startline.Config.Security;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import io.acellab.service.web.startline.Entity.UserInfo;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		UserInfo user = userDetails.getUser();

		String loginPath = (String) request.getSession().getAttribute("loginPath");

		// Check your condition here
		if (user.getAccountType() && !loginPath.equals("/startup/login")) {
			SecurityContextHolder.clearContext();
			request.getSession().invalidate();
			response.sendRedirect("/startup/login");
			System.out.println("From startup: " + loginPath + "\n\n\n\n");
			return;
		} else if (!user.getAccountType() && !loginPath.equals("/corporate/login")) {
			SecurityContextHolder.clearContext();
			request.getSession().invalidate();
			response.sendRedirect("/corporate/login");
			System.out.println("From corporate: " + loginPath + "\n\n\n\n");
			return;
		}

		// Redirect to the default success URL
		response.sendRedirect("/home");
	}
}