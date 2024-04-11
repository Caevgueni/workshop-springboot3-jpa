
package com.devcarlos.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devcarlos.course.entities.User;
import com.devcarlos.course.services.UserService;

@RestController
@RequestMapping(value = "/users") // se u pesqyusar por users ele vai retorar todos os usuarios
public class UserResource {
	
	@Autowired
    private UserService service;
	
	@GetMapping 
	public ResponseEntity<List<User>> findAll() {
		List<User> list =service.findAll();
		return  ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") // isso implica que a minha requesicao vai aceitar o id dentro da url ou melhor se eu pesquisaor por id ele vai me retornar um usuario do respeitivo id
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
}