package com.june.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class UserInfo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_id", columnDefinition = "VARCHAR(40)", updatable = false)
	@NotEmpty
	private String user_id;

	@Column(name = "name", columnDefinition = "VARCHAR(40)")
	@NotEmpty
	private String name;

	@Column(name = "company_name", columnDefinition = "VARCHAR(40)")
	@NotEmpty
	private String company_name;

	@Column(name = "email", columnDefinition = "VARCHAR(400)")
	private String email;

	@Column(name = "status", columnDefinition = "CHAR(1)")
	private String status;

	@Column(name = "password", columnDefinition = "VARCHAR(400)", updatable = false)
	private String password;

	@Column(name = "phone", columnDefinition = "VARCHAR(100)")
	private String phone;

	@Column(name = "mobile", columnDefinition = "VARCHAR(100)")
	private String mobile;

	@Column(name = "part", columnDefinition = "VARCHAR(200)")
	private String part;

	@Column(name = "degree", columnDefinition = "VARCHAR(200)")
	private String degree;

	@Column(name = "role", columnDefinition = "VARCHAR(400)", updatable = false)
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", user_id=" + user_id + ", name=" + name + ", company_name=" + company_name
				+ ", email=" + email + ", status=" + status + ", password=" + password + ", phone=" + phone
				+ ", mobile=" + mobile + ", part=" + part + ", degree=" + degree + ", role=" + role + "]";
	}

}
