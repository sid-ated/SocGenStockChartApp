package com.siddhartha.SocGenPhase3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_Id", nullable=false)
	private int id;
	
	@Column(name = "user_name", nullable=false)
	private String name;
	
	@Column(name = "password", nullable=false)
	private String password;
	
	@Column(name = "email", nullable=false)
	private String email;
	
	@Column(name = "mobile_no", nullable=false)
	private String mobile;
	
	@Column(name = "is_admin", nullable=false, insertable=false)
	private String isAdmin;
	
	@Column(name = "confirmed", nullable=false)
	private Boolean confirmed;
	
	public UserEntity(){
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	
	public UserEntity(String name, String password, String email, String mobile, String isAdmin, Boolean confirmed) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.isAdmin = isAdmin;
		this.confirmed = confirmed;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", mobile="
				+ mobile + ", isAdmin=" + isAdmin + ", confirmed=" + confirmed + "]";
	}
	
	
	
}
