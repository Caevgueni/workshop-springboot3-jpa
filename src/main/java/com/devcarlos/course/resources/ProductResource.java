
package com.devcarlos.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcarlos.course.entities.Product;
import com.devcarlos.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
    private ProductService service;
	
	@GetMapping 
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list =service.findAll();
		return  ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") // isso implica que a minha requesicao vai aceitar o id dentro da url
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}