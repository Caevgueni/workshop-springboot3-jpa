package com.devcarlos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devcarlos.course.entities.Product;
import com.devcarlos.course.repositories.ProductRepository;

@Component // assim registamos o ProductService como componente do spring para que as outras
			// classes possam beneficiar das suas dependencia e tambem existe anotecion com nome de @Service
public class ProductService {

	@Autowired // fazemos a dependencia do ProductService para ProductRepository
	private ProductRepository repository;

	public List<Product> findAll() { // metodo para busta todos o usuarios existentes na banco de dados
		return repository.findAll();
	}
	
	public Product findById(Long id) {  // procurar por id
		Optional<Product> obj = repository.findById(id); // retorna um objeto do tipo optional que é existente desde o java 08
		return obj.get();
		
	}

}
