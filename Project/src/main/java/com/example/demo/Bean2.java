package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="Branch")
@Entity
public class Bean2 {
	@Id
	@Column(name="branch_code")
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "sequence_branch")
	@SequenceGenerator(name = "sequence_branch",sequenceName = "update_sequence", initialValue = 1000 ,allocationSize =1)
private long branchcode;
	@Column(name="branch_name")
private String branchname;
	@Column(name="micr_code")
private int micrcode;
	@Column(name="ifsc_code")
private String ifsccode;
	@Column(name="address")
private String address;
	@Column(name="telephone_number")
private String telephonenumber;

public Bean2() {
	super();
}

public Bean2(String branchname, int micrcode, String ifsccode, String address, String telephonenumber) {
	super();
	this.branchname = branchname;
	this.micrcode = micrcode;
	this.ifsccode = ifsccode;
	this.address = address;
	this.telephonenumber = telephonenumber;
}

public long getBranchcode() {
	return branchcode;
}

public void setBranchcode(long branchcode) {
	this.branchcode = branchcode;
}

public String getBranchname() {
	return branchname;
}

public void setBranchname(String branchname) {
	this.branchname = branchname;
}

public int getMicrcode() {
	return micrcode;
}

public void setMicrcode(int micrcode) {
	this.micrcode = micrcode;
}

public String getIfsccode() {
	return ifsccode;
}

public void setIfsccode(String ifsccode) {
	this.ifsccode = ifsccode;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getTelephonenumber() {
	return telephonenumber;
}

public void setTelephonenumber(String telephonenumber) {
	this.telephonenumber = telephonenumber;
}

@Override
public String toString() {
	return  branchcode + "=" + branchname + "=" + micrcode + "="
			+ ifsccode + "=" + address + "=" + telephonenumber;
}


}
