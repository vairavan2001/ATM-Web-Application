package com.example.demo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="admin")
@Entity
public class Bean1 {
	@Id
	@Column(name="username")
private String username;
	@Column(name="password")
private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Bean1 [username=" + username + ", password=" + password + "]";
	}
	
}
