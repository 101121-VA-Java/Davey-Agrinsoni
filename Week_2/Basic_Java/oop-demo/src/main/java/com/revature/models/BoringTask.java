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
	
	public void procrastinate() {
		this.setDate(this.getDate().plusDays(1));
	}
	
	public void procrastinate(int days) {
		this.setDate(this.getDate().plusDays(days));
	}
	
	public void procrastinate(int days, int times) {
		this.setDate(this.getDate().plusDays(days * times));
	}
	
	@Override
	public String toString() {
		return "Overriden toStringMethod!";
	}
	
	@Override
	public BoringTask getATask() {
		return new BoringTask();
	}

}
