package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.exceptions.UsernameAlreadyInUseException;
import com.revature.models.Buyer;
import com.revature.repositories.BuyerDao;
import com.revature.repositories.BuyerList;

public class BuyerService {
	
	private BuyerDao bd = new BuyerList();
	
	public Buyer addBuyer (Buyer b) throws UsernameAlreadyInUseException {
		Buyer newBuyer = bd.getByUsername(b.getUsername());
		if(newBuyer != null) {
			throw new UsernameAlreadyInUseException();
		}
		return bd.add(b);
	}
	
//	public Buyer getBuyerByUsername(String username) {
//		List<Buyer> buyers = bd.getAll();
//		for(Buyer b: buyers) {
//			if (b.getUsername().equals(username)) {
//				return b;
//			}
//		}
//		return null;
//	}
	
	public boolean removeBuyer(Buyer b) {
		List<Buyer> buyers = bd.getAll();
		for (Buyer b1: buyers) {
			if(b1.equals(b)) {
				return bd.remove(b);
			}
		}
		return false;
	}
	
	public Buyer login(String username, String password) throws UserNotFoundException {
		Buyer temp = bd.getByUsername(username);
		if(temp ==null || temp.getPassword().equals(password)) {
			throw new UserNotFoundException();
		}
		return temp;
	}
}