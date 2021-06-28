package com.ianrogers.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ianrogers.productsandcategories.models.Category;
import com.ianrogers.productsandcategories.services.CategoryService;
import com.ianrogers.productsandcategories.services.ProductService;

@Controller
public class CategoryController {
	@Autowired
	private ProductService ps;
	@Autowired
	private CategoryService cs;
	
	//Renders the Products create page and connects the form
	@RequestMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	//Adds product into database
	@PostMapping("/newCategory")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect/category/new";
		} else {
			cs.createCategory(category);
			return "/products/"+category.getId();
		}
	}

}
