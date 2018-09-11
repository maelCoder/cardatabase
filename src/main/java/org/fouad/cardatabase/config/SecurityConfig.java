package org.fouad.cardatabase.config;

import org.fouad.cardatabase.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	  @Autowired
	  public void configureGlobal(@Autowired UserDetailsServiceImpl userDetailsService,@Autowired AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService)
	    .passwordEncoder(new BCryptPasswordEncoder());
	  }

}
