package io.acellab.service.web.startline.Config.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CustomRequestFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String referer = request.getHeader("Referer");
		String requestURI = request.getRequestURI();

		if ("/chooseplan".equals(requestURI) && (referer == null || !referer.endsWith("/register"))) {
			response.sendRedirect("/register");
			return;
		}

		filterChain.doFilter(request, response);
	}
}