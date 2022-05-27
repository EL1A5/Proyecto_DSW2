package com.epy.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.epy.main.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	String recursos []= {"/css/**","/fonts/**","/images/**","/js/**","/libs/**"};  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers(recursos).permitAll()
		
		.antMatchers("/").permitAll()
		.antMatchers("/config*").access("hasRole('ADMIN')")
		.antMatchers("/rep*").access("hasRole('OPERADOR') or hasRole('ADMIN')")
		.antMatchers("/reg*").access("hasRole('NEGOCIO') or hasRole('OPERADOR') or hasRole('ADMIN')")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/menu")
			.failureUrl("/login?error=true")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
		.logout()
			.permitAll()
			.logoutSuccessUrl("/logout");
		
	}
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new  BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}
	
	@Autowired
	UserService userService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
	

}
