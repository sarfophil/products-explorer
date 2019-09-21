package com.phil.elasticproject.dto;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@Document(indexName="products-index",type = "products-class-point-type", shards = 1, replicas = 0,
refreshInterval = "-1")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Id int productId;
	private String name;
	private double price;
	private String category;
	private String location;
	private String dateInputted;
	
	public Product() {
		
	}
	
	public Product(int productId,String name,Double price,String category,String location,String dateInputted) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.category = category;
		this.location = location;
		this.dateInputted = dateInputted;
	}

	

}
