package com.Employee.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration

public class CustomLoginSucessHandler extends SimpleUrlAuthenticationSuccessHandler {
	 @Override
	    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
	    throws IOException {
	        String targetUrl = determineTargetUrl(authentication);
	        if(response.isCommitted()) return;
	        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    }

	    protected String determineTargetUrl(Authentication authentication){
	        String url = "/login?error=true";
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	        System.out.println(authorities.toString());
	        List<String> roles = new ArrayList<String>();
	        for(GrantedAuthority a : authorities){
	        	
	            roles.add(a.getAuthority());
	        }
	        System.out.println(roles);
	        System.out.println(roles.contains("ROLE_ADMIN"));
	        if (roles.contains("ROLE_ADMIN")) {
	   	     url = "/admin/index";
	   	     // return new ModelAndView("redirect:/admin/index");
	   	 } else if (roles.contains("ROLE_USER")) {
	   	     url = "/user/index";
	   	 }

	   	 // return new ModelAndView("redirect:/user/home");

	   	  return url;
	   	
	   	
	        
}
}
