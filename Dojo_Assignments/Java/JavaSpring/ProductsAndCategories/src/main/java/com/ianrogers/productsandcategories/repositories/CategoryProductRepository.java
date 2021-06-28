package com.ianrogers.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ianrogers.productsandcategories.models.CategoryProduct;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {
	List<CategoryProduct> findAll();

}
