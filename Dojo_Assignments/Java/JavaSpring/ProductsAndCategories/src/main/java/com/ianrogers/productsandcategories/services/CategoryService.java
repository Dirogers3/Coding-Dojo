package com.ianrogers.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianrogers.productsandcategories.models.Category;
import com.ianrogers.productsandcategories.models.Product;
import com.ianrogers.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cr;
	
	//CRUD
	//create one category
	public void createCategory(Category category) {
		cr.save(category);
	}
	
	//read all categories
	public List<Category> allCategories() {
		return cr.findAll();
	}
	
	//read one category
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = cr.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	//update
	public Category updateCategory(Long id, String name) {
		Category category = findCategory(id);
		category.setName(name);
		return cr.save(category);
	}
	
	//delete
	public void deleteCategory(Long id) {
		cr.deleteById(id);
	}
	
	public List<Category> findByProductsNotContaining(Product product){
    	return cr.findByProductsNotContaining(product);
    }
	
	public List<Category> findByProductsContaining(Product product){
		return cr.findByProductsNotContaining(product);
	}
	
	
	
}
