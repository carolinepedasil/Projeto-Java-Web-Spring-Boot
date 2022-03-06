package com.caroline.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caroline.myfirstproject.entities.Category;
import com.caroline.myfirstproject.repositories.CategoryRepository;

@RestController //define que essa classe vai ser um recurso REST
@RequestMapping(value = "/categories") //define o caminho por qual esse recurso vai responser, ou seja: /categories
public class CategoryResource {
	
	@Autowired // resolve a dependência - vai obter uma instância do categoryRepository que está na depedência da classe - Para o @Autowired funcionar precisa do @Component
	private CategoryRepository categoryRepository;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) { //@PathVariable vai reconhecer o id /1 do caminho no Postman
		Category cat = categoryRepository.findById(id).get(); //.get() vai obter o objeto que está dentro do Optional
		return ResponseEntity.ok().body(cat);
	}
}