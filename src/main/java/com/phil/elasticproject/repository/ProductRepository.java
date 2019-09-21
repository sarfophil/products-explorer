package com.phil.elasticproject.repository;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.phil.elasticproject.dto.Product;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {
	List<Product> findByName(String name);

	List<Product> findByLocationLike(String category);
}
