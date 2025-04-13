package com.consume.custom.starter;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.custom.starter.CustomRestClient;
import com.custom.starter.ToDo;

@RestController
@RequestMapping("/api")
public class CustomStarterController {

	
	private  final CustomRestClient restClient;
	
	public CustomStarterController(CustomRestClient restClient) {
		// TODO Auto-generated constructor stub
		
		this.restClient = restClient;
	}
	
	
	@GetMapping("/findAll")
	public List<ToDo> findAll(){
		return restClient.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public ToDo findbyId(@PathVariable Integer id){
		return restClient.findById(id);
	}
	
	
	
	
	
}
