package com.ianrogers.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ianrogers.dojoandninjas.models.Dojo;
import com.ianrogers.dojoandninjas.models.Ninja;
import com.ianrogers.dojoandninjas.services.DojoService;
import com.ianrogers.dojoandninjas.services.NinjaService;

@Controller
public class DojoController {
	@Autowired
	private DojoService ds;
	@Autowired
	private NinjaService ns;
	
	@GetMapping("/new")
	public String dojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/newDojo")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/new";
		} else {
			ds.createDojo(dojo);
			return "location.jsp";
		}
	}
	
	@GetMapping("/dojos/{dojoid}")
	public String dojoLocation(@PathVariable("dojoid") Long id, Model model) {
		Dojo dojo = ds.findDojo(id);
		List<Ninja> ninjas = ns.findAllByDojo(dojo);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjas);
		return "location.jsp";
	}
}
