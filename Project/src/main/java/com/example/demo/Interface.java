package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Interface extends CrudRepository<Bean, String>{
	List <Bean> findByUsernameAndPassword(String username,String password); 
	
	@Query("from Bean where customerid=:ci and mobilenumber=:mn")
	public List changepassword(int ci,long mn);
	
	@Modifying
	@Transactional
	@Query("update Bean set password=:p where customerid=:ci and mobilenumber=:mn")
	public int password(String p , int ci , long mn);
	
	@Modifying
	@Transactional
	@Query("update Bean set mobilenumber=:p where customerid=:ci")
	public int changemobilenumber(long p , int ci);
}
