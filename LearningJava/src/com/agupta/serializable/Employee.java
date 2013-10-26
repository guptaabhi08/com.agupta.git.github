package com.agupta.serializable;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1455L;
	private int age;
	private String name;
	private String emailId;
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public void printName() {
		System.out.println("Age/Name/EmailId is : " + age + "/" + name + "/"
				+ emailId);
	}
}
