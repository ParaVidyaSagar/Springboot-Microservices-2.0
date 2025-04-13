package com.custom.spring.starter;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface JpsClient<T> {
	
	List<T> findAll();
	T findById(Integer id);
	T create(T t);
	T update(Integer id, T t);
	ResponseEntity<Void> delete(Integer id);
	

}
