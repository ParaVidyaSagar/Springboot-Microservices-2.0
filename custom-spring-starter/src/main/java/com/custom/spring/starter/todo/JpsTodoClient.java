package com.custom.spring.starter.todo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import com.custom.spring.starter.JpsClient;

public class JpsTodoClient implements JpsClient<Todo> {

private static final Logger log = LoggerFactory.getLogger(JpsTodoClient.class);
private final RestClient restClient;

public JpsTodoClient(@Qualifier("jsonPlaceholderRestClient") RestClient restClient) {
	this.restClient = restClient;
}

@Override
public List<Todo> findAll() {
	// TODO Auto-generated method stub
	return restClient.get()
			.uri("/todos")
			.retrieve()
			.body(new ParameterizedTypeReference<>() {});
}

@Override
public Todo findById(Integer id) {
	// TODO Auto-generated method stub
	return restClient.get()
			.uri("/todos/{id}",id)
			.retrieve()
			.body(Todo.class);
}

@Override
public Todo create(Todo todo) {
	// TODO Auto-generated method stub
    return restClient.post()
            .uri("/todos")
            .body(todo)
            .retrieve()
            .body(Todo.class);
}

@Override
public Todo update(Integer id, Todo todo) {
	// TODO Auto-generated method stub
	 return restClient.put()
             .uri("/todos/{id}", id)
             .body(todo)
             .retrieve()
             .body(Todo.class);
 }

@Override
public ResponseEntity<Void> delete(Integer id) {
	// TODO Auto-generated method stub
	return (ResponseEntity<Void>) restClient.delete();
}


}


