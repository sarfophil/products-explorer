package com.phil.elasticproject;

import java.util.UUID;

import org.elasticsearch.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.NodeClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ElasticprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticprojectApplication.class, args);
	}
	
	@Bean
	public NodeClientFactoryBean client() {

		NodeClientFactoryBean bean = new NodeClientFactoryBean(true);
		bean.setClusterName(UUID.randomUUID().toString());
		bean.setEnableHttp(false);
		bean.setPathData("target/elasticsearchTestData");
		bean.setPathHome("src/test/resources/test-home-dir");

		return bean;
	}
	
	
	@Bean
	public ElasticsearchTemplate elasticsearchTemplate(Client client) throws Exception {
		return new ElasticsearchTemplate(client);
	}
	
	
}
