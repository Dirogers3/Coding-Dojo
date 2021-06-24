package com.ianrogers.routingpractice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("/{x}")
	public String awesome(@PathVariable("x") String x) {
		if (x.equals("dojo")) {
			return "The " + x + " is awesome!";
		} else if (x.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California.";
		} else if (x.equals("san-jose")){
			return "SJ dojo is the headquarters";
		} else {
			return "Request could not be found";
		}
	}
}
	
	