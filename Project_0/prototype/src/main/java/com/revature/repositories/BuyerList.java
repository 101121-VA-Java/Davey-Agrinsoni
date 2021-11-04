package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Buyer;

public class BuyerList implements BuyerDao{
	
	private List<Buyer> buyers;
	
	public BuyerList() {
		buyers = new ArrayList<>();
	}

	@Override
	public Buyer add(Buyer o) {
		// TODO Auto-generated method stub
		buyers.add(o);
		return o;
	}
	
	@Override
	public Buyer getByUsername(String username) {
		// TODO Auto-generated method stub
		for(Buyer b : buyers) {
			if(b.getUsername() == username) {
				return b;
			}
		}
		return null;
	}
	
	@Override
	public List<Buyer> getAll() {
		// TODO Auto-generated method stub
		return buyers;
	}

	@Override
	public boolean remove(Buyer o) {
		Buyer temp = getByUsername(o.getUsername());
		if(temp == null) {
			return false;
		}
		buyers.remove(o);
		return true;
	}
}