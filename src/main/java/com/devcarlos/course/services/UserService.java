package com.devcarlos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devcarlos.course.entities.User;
import com.devcarlos.course.repositories.UserRepository;

@Component // assim registamos o UserService como componente do spring para que as outras
			// classes possam beneficiar das suas dependencia e tambem existe anotecion com nome de @Service
public class UserService {

	@Autowired // fazemos a dependencia do UserService para UserRepository
	private UserRepository repository;

	public List<User> findAll() { // metodo para busta todos o usuarios existentes na banco de dados
		return repository.findAll();
	}
	
	public User findById(Long id) {  // procurar por id
		Optional<User> obj = repository.findById(id); // retorna um objeto do tipo optional que é existente desde o java 08
		return obj.get();
		
	}
	
	//esta é a operacao basica para inseirir um novo objeto do tipo user
	
	public User insert(User obj) {
		return repository.save(obj);
	}

}
