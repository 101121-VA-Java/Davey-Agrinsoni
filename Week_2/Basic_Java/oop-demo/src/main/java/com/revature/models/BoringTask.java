package com.revature.models;

import java.time.LocalDate;

public class BoringTask extends Task{

	public BoringTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoringTask(String name, LocalDate date) {
		super(name, date);
		// TODO Auto-generated constructor stub
	}
	
	public void procastinate() {
		this.setDate(this.getDate().plusDays(1));
	}
	

}
