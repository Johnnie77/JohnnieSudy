package org.test.demo.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by johney on 15. 5. 29..
 */
@RestController
public class HelloController {

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello";
	}

}
