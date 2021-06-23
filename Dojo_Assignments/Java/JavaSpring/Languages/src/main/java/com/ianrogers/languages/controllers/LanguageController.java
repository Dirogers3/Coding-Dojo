package com.ianrogers.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ianrogers.languages.models.Language;
import com.ianrogers.languages.services.LanguageService;

@Controller
public class LanguageController {

	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		model.addAttribute("allLanguages", this.languageService.allLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/languages")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model viewModel) {
        if (result.hasErrors()) {
        	viewModel.addAttribute("allLanguages", this.languageService.allLanguages());
            return "jsp/index.jsp";
        } else {
        	this.languageService.createLanguage(language);
        	
            return "redirect:/languages";
        }
	}
    
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
    	model.addAttribute("language", language);
    	return "edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language.getId(), language.getName(), language.getCreator(), language.getVersion());
            return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	languageService.delete(id);
    	return "redirect:/languages";
    }
}
