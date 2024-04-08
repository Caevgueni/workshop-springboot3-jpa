package com.devcarlos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devcarlos.course.entities.Category;
import com.devcarlos.course.repositories.CategoryRepository;

@Component // assim registamos o CategoryService como componente do spring para que as outras
			// classes possam beneficiar das suas dependencia e tambem existe anotecion com nome de @Service
public class CategoryService {

	@Autowired // fazemos a dependencia do CategoryService para CategoryRepository
	private CategoryRepository repository;

	public List<Category> findAll() { // metodo para busta todos o usuarios existentes na banco de dados
		return repository.findAll();
	}
	
	public Category findById(Long id) {  // procurar por id
		Optional<Category> obj = repository.findById(id); // retorna um objeto do tipo optional que é existente desde o java 08
		return obj.get();
		
	}

}
