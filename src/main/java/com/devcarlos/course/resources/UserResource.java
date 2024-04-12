
package com.devcarlos.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
		// esta inha de URI é para ter a resposta 201 emves de 200
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value = "/{id}") // quando vamos deletar temos que passaar o id
	public ResponseEntity<Void> delete(@PathVariable Long id) { // é void porque nao vai retorar nada e usamos  o @PathVariable para que este meto possa reconecer o variavel id 
		service.delete(id);
       return ResponseEntity.noContent().build(); // o noContent() ele vai tornar para nos uma resposta vazia e codigo http de uma resposta que nao tem conteudo é o 204
	}
	// anotacao para atualizar
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> padate(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}