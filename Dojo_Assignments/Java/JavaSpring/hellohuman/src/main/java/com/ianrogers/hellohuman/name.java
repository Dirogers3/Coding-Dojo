package com.ianrogers.hellohuman;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class name {
	@RequestMapping("/your_server")
	public String human() {
		return "Hello Human! Welcome to SpringBoot!";
		
	}
	@RequestMapping("/your_server/name={x}/lastname={y}")
	public String greet(@PathVariable("x") String x, @PathVariable("y") String y) {
		String output = "";
		if (x.equals(x)) {
			output = "Hello " + x + " " + y + "! Welcome to SpringBoot!";
		}
		return output;
	}

}
