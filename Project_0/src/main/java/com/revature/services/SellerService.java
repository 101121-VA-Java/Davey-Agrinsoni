package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.exceptions.UserNotSellerException;
import com.revature.exceptions.UsernameAlreadyInUseException;
import com.revature.models.Seller;
import com.revature.repositories.SellerDao;
import com.revature.repositories.SellerList;

public class SellerService {
	private SellerDao sd = new SellerList();
	
	public Seller addSeller(Seller s) throws UsernameAlreadyInUseException{
		Seller newSeller = sd.getByUsername(s.getUsername());
		if(newSeller !=null) {
			throw new UsernameAlreadyInUseException();
		}
		return sd.add(s);
	}
	
	public boolean removeSeller(Seller s) {
		List<Seller> sellers = sd.getAll();
		for (Seller s1: sellers) {
			if(s1.equals(s)) {
				return sd.remove(s);
			}
		}
		return false;
	}
	
	public Seller login(String username, String password) throws UserNotFoundException, UserNotSellerException{
		Seller temp = sd.getByUsername(username);
		if(temp == null || !temp.getPassword().equals(password)) {
			throw new UserNotFoundException();
		}
		if (temp.isSeller() == false) {
			throw new UserNotSellerException();
		}
		return temp;
	}
}
