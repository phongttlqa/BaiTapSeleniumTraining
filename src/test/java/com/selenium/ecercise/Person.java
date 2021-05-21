package com.selenium.ecercise;

public class Person {
	private String name, address, job;

	public Person(String name, String address, String job) {
		super();
		this.name = name;
		this.address = address;
		this.job = job;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
}
