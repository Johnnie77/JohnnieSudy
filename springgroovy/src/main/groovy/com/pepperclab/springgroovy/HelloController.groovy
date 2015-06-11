package com.pepperclab.springgroovy

import com.pepperclab.springgroovy.user.User
import com.pepperclab.springgroovy.user.UserRepository
import com.pepperclab.springgroovy.user.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * Created by johney on 15. 6. 5..
 */
@Controller
class HelloController {

	private static Logger logger = LoggerFactory.getLogger(this.class)

	@Autowired
	UserRepository userRepository


	@RequestMapping("/")
	public def hello() {
		return "home"
	}

	@RequestMapping("/login")
	public def login(Model model) {
		return "login"
	}

	@RequestMapping("/signup")
	public def signup(Model model) {
		return "signup"
	}
	@RequestMapping("/signup/createUser")
	public def createUser(@RequestParam(value = "username", required = true)String username,
						  @RequestParam(value = "password", required = true)String password) {
		User user = User.createUser(username, password)

		logger.debug(user.toString())
		userRepository.save(user)
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
