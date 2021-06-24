package com.ianrogers.counter1.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class HomeController {
	private boolean activeSession = false;
	@RequestMapping("")
	public String home(HttpSession session) {
		if (activeSession == true) {
			Integer count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		} else {
			session.setAttribute("count", 1);
			activeSession = true;
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		return "counter.jsp";
	}
}
