package com.Employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import com.Employee.entities.User;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	  CustomLoginSucessHandler customLoginSuccessHandler;
	
	@Bean
	public UserDetailsService getUserDetailService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		System.out.println(daoAuthenticationProvider);
		return daoAuthenticationProvider;

	}

	/// configure method...

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER")
				.antMatchers("/**").permitAll().and().formLogin()
				.loginPage("/signin")
				.loginProcessingUrl("/dologin")
				.successHandler(customLoginSuccessHandler)
				.and().csrf().disable();
		
		
			
		}
	
//	@GetMapping("/successHandler")
//	  public String defaultAfterLogin(Authentication authentication) {
//	   CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
//
//	   String url = "";
//	   if (userDetails.hasRole("ADMIN")) {
//	     url = "redirect:/admin/index";
//	     // return new ModelAndView("redirect:/admin/index");
//	 } else if (userDetails.hasRole("USER")) {
//	     url = "redirect:/user/index";
//	 }
//
//	 // return new ModelAndView("redirect:/user/home");
//
//	  return url;
//	
//	
//	}
}


