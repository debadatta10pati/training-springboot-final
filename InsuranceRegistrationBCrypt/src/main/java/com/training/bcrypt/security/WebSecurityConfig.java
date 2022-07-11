package com.training.bcrypt.security;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource(name = "customUserService")
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/checkapplications").authenticated().antMatchers("/register").permitAll()
				.and().formLogin();

		// Role based authentication

		/*
		 * http.authorizeRequests().antMatchers("/checkapplications").hasRole("ADMIN").
		 * antMatchers("/register").permitAll() .and().formLogin();
		 */

	}

	@Bean
	protected DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	// Delegating password encoder

	/*
	 * @Bean protected PasswordEncoder passwordEncoder(){
	 * 
	 * Map<String,PasswordEncoder> encoders = new HashMap<String,PasswordEncoder>();
	 * encoders.put("bcrypt", new BCryptPasswordEncoder());
	 * 
	 * PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt",
	 * encoders); passwordEncoder.encode("UserPassword");
	 * 
	 * 
	 * return passwordEncoder; }
	 */
}
