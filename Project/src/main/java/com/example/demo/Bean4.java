package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="customer_transaction")
@Entity
public class Bean4 {
	@Id
	@Column(name="s_no")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "sno")
	@SequenceGenerator(name="sno" ,sequenceName="sno" ,initialValue=1 ,allocationSize=1)
private int sno;
	@Column(name="transaction_date")
private String transactiondate;
	@Column(name="customer_id")
private int customerid;
	@Column(name="cheque_number")
private int chequenumber;
	@Column(name="account_number")
private Long accountnumber;
	@Column(name="transfred_account")
private String transactionaccount;
	@Column(name="withdrawal_amount")
private int withdrawalamount;
	@Column(name="deposite_amount")
private int depositeamount;
	@Column(name="closing_balance")
private int closingbalance;
public Bean4(int sno, String transactiondate, int customerid, int chequenumber, Long accountnumber,
		String transactionaccount, int withdrawalamount, int depositeamount, int closingbalance) {
	super();
	this.sno = sno;
	this.transactiondate = transactiondate;
	this.customerid = customerid;
	this.chequenumber = chequenumber;
	this.accountnumber = accountnumber;
	this.transactionaccount = transactionaccount;
	this.withdrawalamount = withdrawalamount;
	this.depositeamount = depositeamount;
	this.closingbalance = closingbalance;
}
public Bean4() {
	super();
}
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getTransactiondate() {
	return transactiondate;
}
public void setTransactiondate(String transactiondate) {
	this.transactiondate = transactiondate;
}
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public int getChequenumber() {
	return chequenumber;
}
public void setChequenumber(int chequenumber) {
	this.chequenumber = chequenumber;
}
public Long getAccountnumber() {
	return accountnumber;
}
public void setAccountnumber(Long accountnumber) {
	this.accountnumber = accountnumber;
}
public String getTransactionaccount() {
	return transactionaccount;
}
public void setTransactionaccount(String transactionaccount) {
	this.transactionaccount = transactionaccount;
}
public int getWithdrawalamount() {
	return withdrawalamount;
}
public void setWithdrawalamount(int withdrawalamount) {
	this.withdrawalamount = withdrawalamount;
}
public int getDepositeamount() {
	return depositeamount;
}
public void setDepositeamount(int depositeamount) {
	this.depositeamount = depositeamount;
}
public int getClosingbalance() {
	return closingbalance;
}
public void setClosingbalance(int closingbalance) {
	this.closingbalance = closingbalance;
}
@Override
public String toString() {
	return  sno + "=" + transactiondate + "=" + customerid
			+ "=" + chequenumber + "=" + accountnumber + "="
			+ transactionaccount + "=" + withdrawalamount + "=" + depositeamount
			+ "=" + closingbalance;
}




}
