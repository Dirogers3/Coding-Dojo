package com.ianrogers.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianrogers.productsandcategories.models.Category;
import com.ianrogers.productsandcategories.models.Product;
import com.ianrogers.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pr;
	
	//CRUD
	
	//create a product
	public void createProduct(Product product) {
		pr.save(product);
	}
	
	//Read product by ID
	public Product productById(Long id) {
		Optional<Product> optionalProduct = pr.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	
	//read all products
	public List<Product> allProducts() {
		return pr.findAll();
	}
	
	//update product by id
	 public Product editProduct(Product product) {
	        return pr.save(product);
	    }
	//delete product by id
	public void deleteProduct(Long id) {
		pr.deleteById(id);
	}
	
	public List<Product> findByCategoriesNotContaining(Category category) {
    	return pr.findByCategoriesNotContaining(category);
    }
}
