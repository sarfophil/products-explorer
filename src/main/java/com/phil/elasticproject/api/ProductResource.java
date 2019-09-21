/**
 * 
 */
package com.phil.elasticproject.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phil.elasticproject.dto.Product;
import com.phil.elasticproject.service.ProductService;

/**
 * @author SARFO PHILIP
 *
 */

@RestController
@RequestMapping("/v0.1/")
public class ProductResource {

	@Autowired
	private ProductService productService;

	/**
	 * Sends a Product to the elastic server
	 */
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@Valid @RequestBody Product product) {
		productService.addProduct(product);
		return ResponseEntity.accepted().build();
	}

	/**
	 * Sends a list of Products to the elastic server
	 */
	@PostMapping("/products")
	public ResponseEntity<?> addProducts(@Valid @RequestBody List<Product> products) {
		productService.addProducts(products);
		return ResponseEntity.accepted().build();
	}

	/** Search for a product by name */
	@GetMapping("/products/name/{productName}")
	public ResponseEntity<?> search(@PathVariable("productName") String productName) {
		return ResponseEntity.ok(productService.searchProductByName(productName));
	}
	
	/**
	 * Search for a product by a category
	 * @param category
	 * @return
	 */
	@GetMapping("/products")
	public ResponseEntity<?> searchLocationByKeywords(@RequestParam("location") String location){
		return ResponseEntity.ok(productService.searchByLocationName(location));
	}
	
}
