package com.ianrogers.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/date") 
	public String date(Model model) {
		SimpleDateFormat format = new SimpleDateFormat("EEEE 'the' dd 'of' MMMM',' yyyy");
		Date date = new Date();
		model.addAttribute("date", format.format(date));
		return "date.jsp";
	}
		
	@RequestMapping("/time") 
	public String time(Model model) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm aa");
		Date time = new Date();
		model.addAttribute("time", format.format(time));
		return "time.jsp";
	}
}
