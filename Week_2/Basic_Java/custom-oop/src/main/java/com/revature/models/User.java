package com.revature.models;

public class User {

	private int age;
	private String name;
	private Task task;

	// static variable
	public static int numberOfUsers;

	public User() {
		super();
	}

	public User(int age) {
		super();
		this.age = age;
	}

	public User(int age,String name) {
		super();
		this.age = age;
		this.name = name;
	}

	// method that return the age of that instance
	public int getAge() {
		return age;
	}


	public String getUsername() {
		return name;
	}

	public void setUsername(String name) {
		this.name = name;
	}
	
	// method that changes the age of that instance
	public void setAge(int age) {
		if (age < 0) {
			this.age = 0;
		} else {
			this.age = age;
		}
	}

	public static int getNumberOfUsers() {
		return numberOfUsers;
	}

	public static void setNumberOfUsers(int numberOfUsers) {
		User.numberOfUsers = numberOfUsers;
	}

	public static int getNumOfUsers() {
		return numberOfUsers;
	}


	public User(String username, String password, int age, Task task) {
		super();
		this.name = username;
		this.age = age;
		this.task = task;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}