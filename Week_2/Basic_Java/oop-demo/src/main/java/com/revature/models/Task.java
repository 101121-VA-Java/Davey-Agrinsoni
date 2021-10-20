package com.revature.models;

import java.time.LocalDate;

public class Task {
	
	//Instance Variable
	private String name;
	private LocalDate date = LocalDate.now();
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public Task() {
		super();
	}
	
	public Task(String name, LocalDate date) {
		super();
		this.name = name;
		this.date = date;
	}
	
	
	public String toString() {
		return "Task : " + name + " Due date: " + date;
	}
	
	public Task getATask() {
		return new Task();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
