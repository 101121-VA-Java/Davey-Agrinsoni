package com.revature.models;

import java.time.LocalDate;

public class ImportantTask extends Task{

	
	public ImportantTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImportantTask(String name, LocalDate date) {
		super(name, date);
		// TODO Auto-generated constructor stub
	}

	public void stress() {
		/*
		 * Because date is a private field in Task, it is not visible/accessible via the child class
		 * in order to access we could make the field not private or use setters/getters
		 */
		this.setDate(this.getDate().minusDays(1));
	}
}