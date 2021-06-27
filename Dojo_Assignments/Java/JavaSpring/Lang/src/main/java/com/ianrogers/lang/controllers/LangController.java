package com.ianrogers.lang.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ianrogers.lang.models.Lang;
import com.ianrogers.lang.services.LangService;

@Controller
public class LangController {
	private final LangService ls;
	
	public LangController(LangService ls) {
		this.ls = ls;
	}
	
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("lang") Lang lang) {
		List<Lang> langs = ls.allLangs();
		model.addAttribute("langs", langs);
		return "index.jsp";
	}
	
	@RequestMapping(value="/langs", method=RequestMethod.PUT)
	public String create(@Valid @ModelAttribute("lang") Lang lang, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else { 
			ls.createLang(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/langs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Lang lang = ls.findLang(id);
		model.addAttribute("lang", lang);
		return "/show.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	public String editLang(@PathVariable("id") Long id, Model model) {
		Lang lang = ls.findLang(id);
		model.addAttribute("lang", lang);
		return "/edit.jsp";
	}
	
	@PostMapping("/langs/{id}/update")
	public String update(@Valid @ModelAttribute("lang") Lang lang, BindingResult result) {
		if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            ls.updateLang(lang.getId(), lang.getName(), lang.getCreator(), lang.getVersion());
            return "redirect:/languages";
        }
	}
	
	@RequestMapping(value="langs/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		ls.deleteLang(id);
		return "redirect:/languages";
	}
	
	
	
	
}
