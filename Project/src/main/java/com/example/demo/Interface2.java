package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Interface2 extends CrudRepository<Bean2,Long>{
	List <Bean2> findBybranchname(String n);
	
	@Query("from Bean2 where branchname=:bn")
	public List branch(String bn);
}
