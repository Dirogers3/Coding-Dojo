package com.ianrogers.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ianrogers.productsandcategories.models.Category;
import com.ianrogers.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContaining(Product product);
	List<Category> findByProductsContaining(Product product);
}
