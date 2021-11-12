package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int REIMB_ID;
	private double REIMB_AMOUNT;
	private Timestamp REIMB_SUBMITTED;
	private Timestamp REIMB_RESOLVED;
	private String REIMB_DESCRIPTION;
	private User REIMB_AUTHOR;
	private User REIMB_RESOLVER;
	private Status REIMB_STATUS_ID;
	private	Type REMI_TYPE_ID;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int rEIMB_ID, double rEIMB_AMOUNT, Timestamp rEIMB_SUBMITTED, Timestamp rEIMB_RESOLVED,
			String rEIMB_DESCRIPTION, User rEIMB_AUTHOR, User rEIMB_RESOLVER, Status rEIMB_STATUS_ID,
			Type rEMI_TYPE_ID) {
		REIMB_ID = rEIMB_ID;
		REIMB_AMOUNT = rEIMB_AMOUNT;
		REIMB_SUBMITTED = rEIMB_SUBMITTED;
		REIMB_RESOLVED = rEIMB_RESOLVED;
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		REIMB_AUTHOR = rEIMB_AUTHOR;
		REIMB_RESOLVER = rEIMB_RESOLVER;
		REIMB_STATUS_ID = rEIMB_STATUS_ID;
		REMI_TYPE_ID = rEMI_TYPE_ID;
	}

	public Reimbursement(double rEIMB_AMOUNT, Timestamp rEIMB_SUBMITTED, Timestamp rEIMB_RESOLVED,
			String rEIMB_DESCRIPTION, User rEIMB_AUTHOR, User rEIMB_RESOLVER, Status rEIMB_STATUS_ID,
			Type rEMI_TYPE_ID) {
		this.REIMB_AMOUNT = rEIMB_AMOUNT;
		this.REIMB_SUBMITTED = rEIMB_SUBMITTED;
		this.REIMB_RESOLVED = rEIMB_RESOLVED;
		this.REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		this.REIMB_AUTHOR = rEIMB_AUTHOR;
		this.REIMB_RESOLVER = rEIMB_RESOLVER;
		this.REIMB_STATUS_ID = rEIMB_STATUS_ID;
		this.REMI_TYPE_ID = rEMI_TYPE_ID;
	}

	
}
