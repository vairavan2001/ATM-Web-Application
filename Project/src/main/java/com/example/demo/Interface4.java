package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Interface4 extends CrudRepository<Bean4, Integer>{
	@Query("from Bean4 where customerid=:ci and accountnumber=:an and transactiondate between :fd and :td order by transactiondate,sno asc")
	public List generatestatement(int ci,long an, String fd , String td);
	
	@Query("from Bean4 where customerid=:ci order by transactiondate,sno desc")
	public List ministatement(int ci);
	
	@Modifying 
	@Transactional
	@Query("delete from Bean3 where customerid=:ci")
	public int closeAccount(int ci);
	
}
