package com.ianrogers.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	private boolean activeSession = false;
	@RequestMapping("/your_server")
	public String home(HttpSession session) {
		if (activeSession == true) {
			Integer count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		} else {
			session.setAttribute("count", 0);
			activeSession = true;
		}
		
		return "index.jsp";
	}
	
	@RequestMapping("/your_server/counter")
	public String counter(HttpSession session) {
		if (activeSession == true) {
			Integer count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		} else {
			session.setAttribute("count", 0);
			activeSession = true;
		}
		return "counter.jsp";
	}
}
