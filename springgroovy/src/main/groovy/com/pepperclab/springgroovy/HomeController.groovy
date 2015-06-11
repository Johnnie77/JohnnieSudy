package com.pepperclab.springgroovy

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by johney on 15. 6. 5..
 */
@Controller
class HomeController {

	private static Logger logger = LoggerFactory.getLogger(this.class)

	@RequestMapping("/")
	public def hello() {
		return "home"
	}

	@RequestMapping("/login")
	public def login(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "login"
	}

	@RequestMapping("/hello")
	public def hello(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		model.addAttribute("message", "Hello ${name}")

		return "hello"
	}
}
