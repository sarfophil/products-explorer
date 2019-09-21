package com.phil.elasticproject.service.impl;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import com.phil.elasticproject.dto.Product;
import com.phil.elasticproject.repository.ProductRepository;
import com.phil.elasticproject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ElasticsearchOperations operations;
	
	

	/**
	 * This method registers a product
	 *  on the elastic search server
	 *  */
	@Override
	public void addProduct(Product product) {

		operations.refresh(Product.class);
		productRepository.save(Product.builder() //
								.name(product.getName())
								.price(product.getPrice())
								.category(product.getCategory())
								.dateInputted(product.getDateInputted())
								.location(product.getLocation())
								.productId(product.getProductId()).build()); //
	}

	/** This method registers list of products on the elastic search server*/
	@Override
	public void addProducts(List<Product> products) {
		operations.refresh(Product.class);
		for(Product product : products)
			productRepository.save(Product.builder() //
					.name(product.getName())
					.price(product.getPrice())
					.category(product.getCategory())
					.dateInputted(product.getDateInputted().toString())
					.location(product.getLocation())
					.productId(product.getProductId()).build()); //
		
	}
	
	@Override
	public List<Product> searchProductByName(String name){
		operations.refresh(Product.class);
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> searchByLocationName(String category) {
		return productRepository.findByLocationLike(category);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(Product.builder() //
				.name(product.getName())
				.price(product.getPrice())
				.category(product.getCategory())
				.dateInputted(product.getDateInputted())
				.location(product.getLocation())
				.productId(product.getProductId()).build());
	}
	
	
	
	
	
}
