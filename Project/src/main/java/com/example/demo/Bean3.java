package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Table(name="Customer_details")
@Entity
public class Bean3 {
	@Column(name="name")
private String name;
	@Column(name="father_name")
private String fathername;
	@Column(name="date_of_birth")
private String dateofbirth;
	@Column(name="gender")
private String gender;
	@Column(name="permanent_address")
private String permanentaddress;
	@Column(name="present_address")
private String presentaddress;
@Column(name="Pan_card_number")
private String pancardnumber;
@Column(name="mobile_number")
private long mobilenumber;
@Column(name="check_book")
private String checkbook;
@Column(name="account_type")
private String accounttype;
@Column(name="opening_balance")
private int openingbalance;
@Column(name="branch_name")
private String branchname;
@Column(name="account_number")
private long accountnumber;
@Id
@GeneratedValue(strategy =GenerationType.SEQUENCE , generator ="customer_id")
@SequenceGenerator(name="customer_id",sequenceName="customer_id",initialValue=1543269,allocationSize=1)
@Column(name="customer_id")
private int customerid;
@Column(name="card_number")
private String cardnumber;
@Column(name="pin")
private int pin;
@Column(name="pin_changed")
private int pinchange;


public Bean3(String name, String fathername, String dateofbirth, String gender, String permanentaddress,
		String presentaddress, String pancardnumber, long mobilenumber, String checkbook, String accounttype,
		int openingbalance, String branchname) {
	super();
	this.name = name;
	this.fathername = fathername;
	this.dateofbirth = dateofbirth;
	this.gender = gender;
	this.permanentaddress = permanentaddress;
	this.presentaddress = presentaddress;
	this.pancardnumber = pancardnumber;
	this.mobilenumber = mobilenumber;
	this.checkbook = checkbook;
	this.accounttype = accounttype;
	this.openingbalance = openingbalance;
	this.branchname = branchname;
}
public Bean3(String name, String fathername, String dateofbirth, String gender, String permanentaddress, String presentaddress,
		String pancardnumber, long mobilenumber, String checkbook, String accounttype, int openingbalance,
		String branchname, long accountnumber, String cardnumber, int pin) {
	super();
	this.name = name;
	this.fathername = fathername;
	this.dateofbirth = dateofbirth;
	this.gender = gender;
	this.permanentaddress = permanentaddress;
	this.presentaddress = presentaddress;
	this.pancardnumber = pancardnumber;
	this.mobilenumber = mobilenumber;
	this.checkbook = checkbook;
	this.accounttype = accounttype;
	this.openingbalance = openingbalance;
	this.branchname = branchname;
	this.accountnumber = accountnumber;
	this.cardnumber = cardnumber;
	this.pin = pin;
}
public Bean3() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFathername() {
	return fathername;
}
public void setFathername(String fathername) {
	this.fathername = fathername;
}
public String getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPermanentaddress() {
	return permanentaddress;
}
public void setPermanentaddress(String permanentaddress) {
	this.permanentaddress = permanentaddress;
}
public String getPresentaddress() {
	return presentaddress;
}
public void setPresentaddress(String presentaddress) {
	this.presentaddress = presentaddress;
}
public String getPancardnumber() {
	return pancardnumber;
}
public void setPancardnumber(String pancardnumber) {
	this.pancardnumber = pancardnumber;
}
public long getMobilenumber() {
	return mobilenumber;
}
public void setMobilenumber(long mobilenumber) {
	this.mobilenumber = mobilenumber;
}
public String getCheckbook() {
	return checkbook;
}
public void setCheckbook(String checkbook) {
	this.checkbook = checkbook;
}
public String getAccounttype() {
	return accounttype;
}
public void setAccounttype(String accounttype) {
	this.accounttype = accounttype;
}
public int getOpeningbalance() {
	return openingbalance;
}
public void setOpeningbalance(int openingbalance) {
	this.openingbalance = openingbalance;
}
public String getBranchname() {
	return branchname;
}
public void setBranchname(String branchname) {
	this.branchname = branchname;
}

public long getAccountnumber() {
	return accountnumber;
}
public void setAccountnumber(long accountnumber) {
	this.accountnumber = accountnumber;
}

public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public String getCardnumber() {
	return cardnumber;
}
public void setCardnumber(String cardnumber) {
	this.cardnumber = cardnumber;
}
public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}

public int getPinchange() {
	return pinchange;
}
public void setPinchange(int pinchange) {
	this.pinchange = pinchange;
}
@Override
public String toString() {
	return  name + "=" + fathername + "=" + dateofbirth + "=" + gender
			+ "=" + permanentaddress + "=" + presentaddress + "="
			+ pancardnumber + "=" + mobilenumber + "=" + checkbook + "="
			+ accounttype + "=" + openingbalance + "=" + branchname + "="
			+ accountnumber + "=" + customerid + "=" + cardnumber + "=" + pin;
}

}
