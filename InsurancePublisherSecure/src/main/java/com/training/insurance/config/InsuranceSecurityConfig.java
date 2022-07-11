package com.training.insurance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InsuranceSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		// Customize the requests

		http.authorizeRequests((requests) -> {
			try {
				requests.antMatchers("/balance").authenticated().antMatchers("/account").authenticated()
						.antMatchers("/contact").permitAll().antMatchers("/cards").authenticated().and().formLogin()
						.and().httpBasic();

				// http.httpBasic();
				// http.formLogin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// Deny all requests. Useful for business applications that no one should be
		// allowed to log into.
		// Spring security won't even look at the credentials.

		// http.authorizeRequests((requests) -> requests.anyRequest().denyAll());

		// Permit all the requests.
		// Useful for public or govt applications providing info

		// http.authorizeRequests((requests) -> requests.anyRequest().permitAll());

	}

	/**
	 * With the default inMemoryAuthentication
	 **/
	
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception {
		  
		  
	  
	  auth.inMemoryAuthentication().withUser("deba").password("deba").authorities(
	  "admin").and().withUser("lily")
	  .password("lily").authorities("read").and().passwordEncoder(
	  NoOpPasswordEncoder.getInstance());
	  
	  }
	 
	/**
	 * With the default InMemoryUserDetailsManager to create and manage users
	 **/
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * // LdapUserDetailsManager userDetailsManager;
	 * 
	 * 
	 * InMemoryUserDetailsManager inMemoryUserDetailsManager = new
	 * InMemoryUserDetailsManager();
	 * 
	 * UserDetails user1 =
	 * User.withUsername("raj").password("raj").authorities("admin").build();
	 * 
	 * UserDetails user2 =
	 * User.withUsername("andy").password("andy").authorities("read").build();
	 * 
	 * UserDetails user3 =
	 * User.withUsername("bree").password("bree").authorities("read").build();
	 * 
	 * inMemoryUserDetailsManager.createUser(user1);
	 * inMemoryUserDetailsManager.createUser(user2);
	 * 
	 * inMemoryUserDetailsManager.createUser(user3);
	 * 
	 * auth.userDetailsService(inMemoryUserDetailsManager);
	 * 
	 * }
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
}