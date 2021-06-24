package com.ianrogers.hellohuman1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("your_server")
public class HomeController {
	@RequestMapping("")
	public String hello() {
		return "Hello Human!";
	}
	
	@RequestMapping("/")
	public String helloName(@RequestParam(value="name") String name, @RequestParam(value="lastname") String lastName) {
		return "Hello " + name + " " + lastName;
	}
}
