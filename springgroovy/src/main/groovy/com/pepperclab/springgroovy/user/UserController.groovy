package com.pepperclab.springgroovy.user

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

/**
 * Created by johney on 15. 6. 5..
 */
@Controller
class UserController {

	private static Logger logger = LoggerFactory.getLogger(this.class)

	@Autowired
	UserRepository userRepository

	@RequestMapping(value = "/user/signup", method = RequestMethod.GET)
	public def signup(Model model) {
		return "signup"
	}

	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public def create(@RequestParam(value = "username", required = true)String username,
						  @RequestParam(value = "password", required = true)String password) {
		User user = User.createUser(username, password)

		logger.debug(user.toString())
		userRepository.save(user)
		return "redirect:"+"/login"
	}

}
