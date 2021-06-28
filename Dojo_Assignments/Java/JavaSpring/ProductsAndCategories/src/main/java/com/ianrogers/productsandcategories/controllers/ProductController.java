package com.ianrogers.productsandcategories.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.ianrogers.productsandcategories.models.Category;
import com.ianrogers.productsandcategories.models.CategoryProduct;
import com.ianrogers.productsandcategories.models.Product;
import com.ianrogers.productsandcategories.services.CategoryProductService;
import com.ianrogers.productsandcategories.services.CategoryService;
import com.ianrogers.productsandcategories.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService ps;
	@Autowired
	private CategoryService cs;
	@Autowired
	private CategoryProductService cps;
	
	//Renders the Products create page and connects the form
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	//Adds product into database
	@PostMapping("/newProduct")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/products/new";
		} else {
			ps.createProduct(product);
			return "/products/"+product.getId();
		}
	}
	
	@GetMapping("/products/{id}")
	public String ShowProduct(@PathVariable("id") Long id, Model model, @ModelAttribute("addCategory") CategoryProduct categoryProduct) {
		Product product =  ps.productById(id);
		List<Category> notCategories = cs.findByProductsNotContaining(product);
		model.addAttribute("notCategories", notCategories);
		model.addAttribute("product", product);
		return "/productPage.jsp";
	}
	
	
	@PostMapping("/addCategory")
	public String AddCategory(@Valid @ModelAttribute("addCategory") CategoryProduct cp, BindingResult result) {
	
		if (result.hasErrors()) {
			return "redirect:/products/"+cp.getProduct().getId();
		} else {
	
			cps.saveCategoryToProduct(cp);
			return "redirect:/products/"+cp.getProduct().getId();
		}
	}
	
}
