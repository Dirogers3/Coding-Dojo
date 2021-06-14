package com.ianrogers.gettingfamiliarwithrouting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{x}")
	public String dojo(@PathVariable("x") String x) {
		String output = "The " + x + " is awesome!";
		if(x.equals("burbank-dojo")) {
			output = "Burbank Dojo is located in Southern California";
		}
		if(x.equals("san-jose")) {
			output = "SJ dojo is the headquarters";
		}
		return output;
	}

}
