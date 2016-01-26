package com.june.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Changer 객체
 *
 * @author trk
 */

@Entity
@Table(name = "company_locale")
public class CompanyLocale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "company_id", updatable = false, columnDefinition = "INT")
	private int company_id;
	/* 다국어영억 */
	@Column(name = "locale", updatable = false, columnDefinition = "VARCHAR(10)")
	@NotEmpty
	private String locale;

	@Column(name = "company_name", columnDefinition = "VARCHAR(200)")
	private String company_name;

	@Column(name = "branch_name", columnDefinition = "VARCHAR(400)")
	private String branch_name;

	@Column(name = "benefit", columnDefinition = "VARCHAR(400)")
	private String benefit;

	@Column(name = "conditions", columnDefinition = "VARCHAR(400)")
	private String conditions;

	@Column(name = "working_hour", columnDefinition = "VARCHAR(100)")
	private String working_hour;

	@Column(name = "rest_day", columnDefinition = "VARCHAR(100)")
	private String rest_day;

	@Column(name = "phone_number", columnDefinition = "VARCHAR(200)")
	private String phone_number;

	@Column(name = "homepage", columnDefinition = "VARCHAR(200)")
	private String homepage;

	@Column(name = "items", columnDefinition = "VARCHAR(400)")
	private String items;

	@Column(name = "descs", columnDefinition = "TEXT")
	private String descs;

	@Column(name = "first_address", columnDefinition = "VARCHAR(200)")
	private String first_address;

	@Column(name = "middle_address", columnDefinition = "VARCHAR(200)")
	private String middle_address;

	@Column(name = "last_address", columnDefinition = "VARCHAR(200)")
	private String last_address;

	@Column(name = "use_at", columnDefinition = "CHAR(1)")
	private String use_at;

	@Column(name = "view_yn", columnDefinition = "CHAR(1)")
	private String view_yn;

	@Column(name = "company_content", columnDefinition = "LONGTEXT")
	private String company_content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getWorking_hour() {
		return working_hour;
	}

	public void setWorking_hour(String working_hour) {
		this.working_hour = working_hour;
	}

	public String getRest_day() {
		return rest_day;
	}

	public void setRest_day(String rest_day) {
		this.rest_day = rest_day;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public String getFirst_address() {
		return first_address;
	}

	public void setFirst_address(String first_address) {
		this.first_address = first_address;
	}

	public String getMiddle_address() {
		return middle_address;
	}

	public void setMiddle_address(String middle_address) {
		this.middle_address = middle_address;
	}

	public String getLast_address() {
		return last_address;
	}

	public void setLast_address(String last_address) {
		this.last_address = last_address;
	}

	public String getUse_at() {
		return use_at;
	}

	public void setUse_at(String use_at) {
		this.use_at = use_at;
	}

	public String getView_yn() {
		return view_yn;
	}

	public void setView_yn(String view_yn) {
		this.view_yn = view_yn;
	}

	public String getCompany_content() {
		return company_content;
	}

	public void setCompany_content(String company_content) {
		this.company_content = company_content;
	}

	@Override
	public String toString() {
		return "CompanyLocale [id=" + id + ", company_id=" + company_id + ", locale=" + locale + ", company_name="
				+ company_name + ", branch_name=" + branch_name + ", benefit=" + benefit + ", conditions=" + conditions
				+ ", working_hour=" + working_hour + ", rest_day=" + rest_day + ", phone_number=" + phone_number
				+ ", homepage=" + homepage + ", items=" + items + ", descs=" + descs + ", first_address="
				+ first_address + ", middle_address=" + middle_address + ", last_address=" + last_address + ", use_at="
				+ use_at + ", view_yn=" + view_yn + ", company_content=" + company_content + "]";
	}

}