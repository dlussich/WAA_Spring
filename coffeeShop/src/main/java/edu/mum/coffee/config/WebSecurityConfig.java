package edu.mum.coffee.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select email,password, enable from person where email=?")
		.authoritiesByUsernameQuery(
			"select username, role from role where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin().loginPage("/views/login.jsp")
    	.loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/home").failureUrl("/login");
		http.logout().logoutSuccessUrl("/login");
		http.exceptionHandling().accessDeniedPage("/login?accessDenied");
		http.authorizeRequests().antMatchers("/","/register/*").permitAll()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/user/**").access("hasRole('ROLE_USER')");
		http.csrf().disable();

	}
	

}