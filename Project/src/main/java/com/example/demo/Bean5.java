package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Table(name="deposit")
@Entity
public class Bean5 {
	@Id
	@Column(name="s_no")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dsno")
	@SequenceGenerator(name="dsno" ,sequenceName="dsno" ,initialValue=1 , allocationSize=1)
private int sno;
	@Column(name="customer_id")
private int customerid;
	@Column(name="account_number")
private long accountnumber;
	@Column(name="cheque_number")
private int chequenumber;
	@Column(name="amount")
private int amount;
	@Column(name="status")
private String status;
	@Column(name="bank_name")
private String bankname;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public int getChequenumber() {
		return chequenumber;
	}
	public void setChequenumber(int chequenumber) {
		this.chequenumber = chequenumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	@Override
	public String toString() {
		return  sno + "=" +customerid + "=" +accountnumber+ "=" + chequenumber + "=" + amount + "=" + status +"="+bankname;
	}
	
	
}
