package com.pepperclab.springgroovy.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.Authentication

import javax.sql.DataSource

/**
 * Created by johney on 15. 6. 5..
 */
@Configuration
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource

	@Autowired
	public def configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")

		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username, password, 1 as enabled from users where username = ?")
			.authoritiesByUsernameQuery("select u.username, r.name as authority" +
				" from users u" +
				" inner join roles_users ru on ru.user_id=u.id" +
				" inner join roles r on r.id = ru.role_id" +
				" where u.username = ?")
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
				.ignoring()
				.antMatchers("/resources/**"); // #3
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/signup","/about").permitAll() // #4
				.antMatchers("/admin/**").hasRole("ADMIN") // #6
				.anyRequest().authenticated() // 7
				.and()
			.formLogin()  // #8
				.permitAll(); // #5
	}
}
