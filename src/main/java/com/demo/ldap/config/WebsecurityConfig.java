package com.demo.ldap.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

@Configuration
public class WebsecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().userDnPatterns("uid=jyoti,ou=people").contextSource(contextSource());
	}

	@Bean
	public DefaultSpringSecurityContextSource contextSource() {
		// DefaultSpringSecurityContextSource localContextSource = null;
		System.out.println("DefaultSpringSecurityContextSource contextSource()");
		// localContextSource.afterPropertiesSet();
		return new DefaultSpringSecurityContextSource(Arrays.asList("ldaps://localhost:10389"), "dc=master,dc=com");

	}
}
