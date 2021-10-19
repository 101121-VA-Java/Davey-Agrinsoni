package com.revature.models;

public class Task {
	//Instance Variable
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	public Task(String name) {
		super();
		this.name = name;
	}

}
