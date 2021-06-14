package com.ianrogers.gettingfamiliarwithrouting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class HomeController {
	@RequestMapping("")
	public String hello() {
		return "Hello Coding Dojo!";
	}
	@RequestMapping("/python")
	public String awesome() {
		return "Python/Django was awesome!";
	}
	@RequestMapping("/java")
	public String better(){
		return "Java/Spring is better!";
	}

}
