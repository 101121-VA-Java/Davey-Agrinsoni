package com.revature.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ReimbDao;
import com.revature.repositories.ReimbursementPostgres;

public class ReimbService {

	private ReimbDao rd = new ReimbursementPostgres();

	public List<Reimbursement> getReimbs() {
		List<Reimbursement> reimbs = rd.getAll().stream().map(r -> {
			return r;
		}).collect(Collectors.toList());
		return reimbs;
	}
	
	public Reimbursement getReimbById(int id) {
		Reimbursement r = rd.getById(id);
		return r;
	}
	
	public List<Reimbursement> getReimbByUserId(int id) {
		List<Reimbursement> reimbs = rd.getAllByUserId(id);
		return reimbs;
	}
	
	public Reimbursement addReimb(String token, Reimbursement r) {
		r.setStatusId(new Status(1));
		r.setTimeSubmitted(new Timestamp(System.currentTimeMillis()));
		r.setReimbAuthor(new User(Integer.parseInt(token.split(":")[0])));
		return rd.add(r);
	}
	
	public boolean updateReimb(Reimbursement r){
		Reimbursement update = rd.getById(r.getReimbId());
		
		if(r.getAmount() != 0 && r.getAmount() == update.getAmount()) {
			update.setAmount(r.getAmount());
		}
		
		return rd.update(r);
		
	}
	
	public List<Reimbursement> getReimbByStatusId(int id) {
		List<Reimbursement> reimbs = rd.getAllByStatusId(id);
		return reimbs;
	}
}