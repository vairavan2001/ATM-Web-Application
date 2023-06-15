package com.example.demo;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

public interface Interface3 extends JpaRepository<Bean3, Integer> {
	@Query("from Bean3 where pancardnumber=:i and branchname=:j")
List<Bean3> findByPanAndBranch(String i, String j);
	
	@Query("Select accountnumber From Bean3 where accountnumber>=:a and accounttype=:s")
public List <Integer> accountNumber(long a,String s);
	
	@Query("Select pin From Bean3 order by pin")
	public List <Integer> pin();
	
	@Query("Select cardnumber From Bean3 order by pin")
	public List <String> cardnumber();
	
	@Query("from Bean3 where customerid=:ci and accountnumber=:ac")
	public List customerdetails(int ci,long ac);
	
	@Query("from Bean3 where customerid=:ci")
	public List minicustomer(int ci);
	
	@Modifying 
	@Transactional
	@Query("delete from Bean3 where customerid=:ci and accountnumber=:ac")
	public int closeAccount(int ci , Long ac);
	
	@Modifying
	@Transactional
	@Query("update Bean3 set branchname=:bn where customerid=:ci and accountnumber=:an")
	public int changeBranch(String bn,int ci,long an);
	
	@Modifying
	@Transactional
	@Query("update Bean3 set fathername=:bn where customerid=:ci and accountnumber=:an")
	public int changeFatherName(String bn,int ci,long an);
	
	@Modifying
	@Transactional
	@Query("update Bean3 set mobilenumber=:bn where customerid=:ci and accountnumber=:an")
	public int changeMobileNumber(long bn,int ci,long an);
	
	@Modifying
	@Transactional
	@Query("update Bean3 set name=:bn where customerid=:ci and accountnumber=:an")
	public int changeName(String bn,int ci,long an);
	
	@Modifying
	@Transactional
	@Query("update Bean3 set permanentaddress=:bn where customerid=:ci and accountnumber=:an")
	public int changePermanentAddress(String bn,int ci,long an);
	
	@Modifying
	@Transactional
	@Query("update Bean3 set presentaddress=:bn where customerid=:ci and accountnumber=:an")
	public int changePresentAddress(String bn,int ci,long an);
	
	@Modifying 
	@Transactional
	@Query("update Bean3 set pin=:p where customerid=:ci and pinchange=:pc")
	public int changepin(int p , int ci,int pc); 
	
	@Modifying 
	@Transactional
	@Query("update Bean3 set pinchange=:pc where customerid=:ci")
	public int addcount(int pc , int ci); 
	
	@Query("select pinchange from Bean3 where customerid=:ci")
	List checkpinchange(int ci);
	
	@Query("select openingbalance from Bean3 where customerid=:ci and cardnumber=:cn and pin=:p")
	public List getCash(int ci,String cn ,int p);
	
	@Query("select openingbalance from Bean3 where customerid=:ci")
	public List checkopeningbalance(int ci);
	
	@Modifying
	@Transactional
	@Query("update Bean3 set openingbalance=:op where customerid=:ci")
	public int updateopeningamount(int op,int ci);
	
	@Query("select accountnumber from Bean3 where customerid=:ci")
	public List accountnumber(int ci);
	
	@Query("select branchname from Bean3 where customerid=:ci")
	public List branch(int ci);
	
	@Query("select openingbalance from Bean3 where customerid=:ci")
	public List balance(int ci);
	
	@Query("from Bean3 where customerid=:ci and mobilenumber=:mn")
	public List neuser(int ci,long mn);

}
