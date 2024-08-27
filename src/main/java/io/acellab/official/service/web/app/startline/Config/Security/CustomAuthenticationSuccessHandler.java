package io.acellab.official.service.web.app.startline.Config.Security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectURL = request.getContextPath();

        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_STARTUP_USER"))) {
            redirectURL = "/startup-home";
        } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_COMPANY_USER"))) {
            redirectURL = "/company-home";
        }

        response.sendRedirect(redirectURL);
    }
}
