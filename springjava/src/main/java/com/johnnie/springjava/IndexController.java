package com.johnnie.springjava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by johney on 15. 6. 3..
 */

@Controller
public class IndexController {

	@RequestMapping("/welcome")
	public String index(Model model) {
		model.addAttribute("message", "dsfjsdafkjsdf;asd");
		return "welcome";
	}
}
