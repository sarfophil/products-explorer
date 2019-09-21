package com.phil.elasticproject.service;

import java.util.List;

import com.phil.elasticproject.dto.Product;

public interface ProductService {
	void addProduct(Product product);

	void addProducts(List<Product> product);

	List<Product> searchProductByName(String name);

	List<Product> searchByLocationName(String category);
	
	void deleteProduct(Product product);
	
}
