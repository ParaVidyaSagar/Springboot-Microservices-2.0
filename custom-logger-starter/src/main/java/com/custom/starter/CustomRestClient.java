package com.custom.starter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

public class CustomRestClient {
	
	private static final Logger log = LoggerFactory.getLogger(CustomRestClient.class);
	private RestClient restClient;
	
	public CustomRestClient(@Qualifier("ExternalRestClient")RestClient restClient) {
		// TODO Auto-generated constructor stub
		this.restClient = restClient;
	}
	
	public List<ToDo> findAll(){
		return restClient.get()
				.uri("/todos")
				.retrieve()
				.body(new ParameterizedTypeReference<>() {});
	}
	
	public ToDo findById(Integer id){
		return restClient.get()
				.uri("/todos/{id}",id)
				.retrieve()
				.body(ToDo.class);
	}
	
	public ToDo create(ToDo todo) {
		return restClient.post()
				.uri("/todos")
				.body(todo)
				.retrieve()
				.body(ToDo.class);
	}

}
