package com.ianrogers.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/validate", method=RequestMethod.POST)
	public String Validate(@RequestParam(value = "code") String code, RedirectAttributes redirectAttributes) {
		if(code.equals("bushido")) {
			return "code.jsp";
		}
		else {
			redirectAttributes.addFlashAttribute("flashError", "You must train harder.");
			return "redirect:/";
		}
	
	 
	 }
}
