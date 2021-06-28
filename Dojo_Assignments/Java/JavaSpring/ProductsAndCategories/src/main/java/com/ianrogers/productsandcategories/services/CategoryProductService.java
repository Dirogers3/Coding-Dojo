package com.ianrogers.productsandcategories.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianrogers.productsandcategories.models.CategoryProduct;
import com.ianrogers.productsandcategories.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {

	@Autowired
	private CategoryProductRepository cpr;
	
	/*public void addCategoryToProduct(Long categoryid, Long productid) {
		cpr.addCategoryToProduct(categoryid, productid);
	}
	*/
	public void saveCategoryToProduct(CategoryProduct cp) {
		cpr.save(cp);
	}
	
	/*
	public void addProductToCategory(Long categoryid, Long productid) {
		cps.addCategoryToProduct(categoryid, productid);
	}
	*/
}
