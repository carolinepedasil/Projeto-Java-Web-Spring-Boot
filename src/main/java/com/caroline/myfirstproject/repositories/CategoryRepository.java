package com.caroline.myfirstproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.caroline.myfirstproject.entities.Category;

@Component
public class CategoryRepository {
	
	private Map<Long, Category> map = new HashMap<>(); //Map é uma coleção/dicionário de chave-valor 

	public void save(Category obj) { //void retorna nada
		map.put(obj.getId(), obj); //put é para inserir
	}

	public Category findById(Long id) {
		return map.get(id);
	}
	
	public List<Category> findAll() {
		return new ArrayList<Category>(map.values());
	}
}