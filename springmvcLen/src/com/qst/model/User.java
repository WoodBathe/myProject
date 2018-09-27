package com.qst.model;

import java.util.Date;
import java.util.List;

public class User {

	private String username;
	private String userpass;
	private Integer age;
	private List<String> check;

	private Date date;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getCheck() {
		return check;
	}

	public void setCheck(List<String> check) {
		this.check = check;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userpass=" + userpass + ", age=" + age + ", check=" + check + ", date="
				+ date + "]";
	}

}
