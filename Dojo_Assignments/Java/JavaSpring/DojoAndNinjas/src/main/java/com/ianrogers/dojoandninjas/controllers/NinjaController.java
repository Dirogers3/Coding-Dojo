package com.ianrogers.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ianrogers.dojoandninjas.models.Ninja;
import com.ianrogers.dojoandninjas.services.DojoService;
import com.ianrogers.dojoandninjas.services.NinjaService;

@Controller
public class NinjaController {

	@Autowired
	private NinjaService ns;
	
	@Autowired 
	private DojoService ds;
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", ds.allDojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("/newNinja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/ninjas/new";
		} else {
			ns.createNinja(ninja);
			return "redirect:/dojos/"+ninja.getDojo().getId();
		}
	}
}
