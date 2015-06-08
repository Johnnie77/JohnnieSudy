package com.pepperclab.springgroovy

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by johney on 15. 6. 5..
 */
@Controller
class HelloController {

	@RequestMapping("/")
	public def hello() {
		return "home"
	}

	@RequestMapping("/hello")
	public def hello(Model model) {
		model.addAttribute("message", "Hello Johnnie")

		return "hello"
	}
}
