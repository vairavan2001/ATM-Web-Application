package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Interface5 extends CrudRepository<Bean5, Integer> {
	
	@Query("from Bean5 where status=:s")
	public List status(String s);
	
	@Modifying
	@Transactional
	@Query("update Bean5 set status=:s where customerid=:ci and chequenumber=:cn")
	public int changeStatus(String s,int ci,int cn);
}
