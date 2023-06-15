package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Interface1 extends CrudRepository<Bean1, String>{
	List <Bean1> findByUsernameAndPassword(String username,String password);
	
	List <Bean1> findByUsername(String username);
	
}
