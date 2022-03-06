package com.caroline.myfirstproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.caroline.myfirstproject.entities.Product;

@Component
public class ProductRepository {
	
	private Map<Long, Product> map = new HashMap<>(); //Map é uma coleção/dicionário de chave-valor 

	public void save(Product obj) { //void retorna nada
		map.put(obj.getId(), obj); //put é para inserir
	}

	public Product findById(Long id) {
		return map.get(id);
	}
	
	public List<Product> findAll() {
		return new ArrayList<Product>(map.values());
	}
}