package com.devcarlos.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devcarlos.course.entities.Category;
import com.devcarlos.course.entities.Order;
import com.devcarlos.course.entities.User;
import com.devcarlos.course.entities.enums.OrderStatus;
import com.devcarlos.course.repositories.CategoryRepository;
import com.devcarlos.course.repositories.OrderRepository;
import com.devcarlos.course.repositories.UserRepository;

@Configuration
// isto é para falar para o spring que isso é a nossa classe de configuracao
@Profile("test") // este nome test tem que ser igual aquele que colocamos no profiles do afile aplication.properity
// assim o spring entenque que so vai rodar essa configuracao so quando estamos no perfil de teste
public class TestConfig implements CommandLineRunner {
	@Autowired  // isto é a implementacao de injecao de dependencia de forma automatico
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}

}
