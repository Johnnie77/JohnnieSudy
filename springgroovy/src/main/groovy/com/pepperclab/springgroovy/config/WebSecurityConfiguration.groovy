package com.pepperclab.springgroovy.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


/**
 * Created by johney on 15. 6. 5..
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.pepperclab.springgroovy")
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	private static PasswordEncoder encoder;

	@Autowired
	private UserDetailsService userService;

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
				.antMatchers("/signup","/signup/**","/about").permitAll() // #4
				.antMatchers("/admin/**").hasRole("ADMIN") // #6
				.anyRequest().authenticated()

		http.formLogin()  // #8
				.loginPage("/login")
				.permitAll() // #5

		http.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.permitAll()
//		                    .deleteCookies("remove")
//		                    .invalidateHttpSession(false)
//		                    .logoutUrl("/logout")
//		                    .logoutSuccessUrl("/login");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
				.passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		if(encoder == null) {
			encoder = new BCryptPasswordEncoder();
		}

		return encoder;
	}
}
