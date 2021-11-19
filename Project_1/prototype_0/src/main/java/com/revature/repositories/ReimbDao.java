package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbDao extends GenericDao<Reimbursement>{
	
	List<Reimbursement> getAllByUserId(int id);
}