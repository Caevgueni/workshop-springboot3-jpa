package com.devcarlos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devcarlos.course.entities.User;
import com.devcarlos.course.repositories.UserRepository;
import com.devcarlos.course.services.exceptions.ResourceNotFoundException;

@Component // assim registamos o UserService como componente do spring para que as outras
			// classes possam beneficiar das suas dependencia e tambem existe anotecion com
			// nome de @Service
public class UserService {

	@Autowired // fazemos a dependencia do UserService para UserRepository
	private UserRepository repository;

	public List<User> findAll() { // metodo para busta todos o usuarios existentes na banco de dados
		return repository.findAll();
	}

	public User findById(Long id) { // procurar por id
		Optional<User> obj = repository.findById(id); // retorna um objeto do tipo optional que é existente desde o java
														// 08
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));

	}

	// esta é a operacao basica para inseirir um novo objeto do tipo user

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {

		repository.deleteById(id);
	}

	public User update(Long id, User obj) { // é do tipo User porque vai retornar usuaria atualizado, com id de usaurio
											// que vamos atualizar eo o obj user que vai conter os dados para serem
											// atualizados
		
		User entity = repository.getReferenceById(id);
		updateData(entity, obj); // isto vou atualizar o meu dados de  entity basiados na dados que chegaram do meu obj
        return repository.save(entity); // depois de td, aqui vou salvar no bd o meu entity
	}

	private void updateData(User entity, User obj) { // este metodo é para atualizar os dados de entity com baso nos dados que chegaram do obj
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}

}
