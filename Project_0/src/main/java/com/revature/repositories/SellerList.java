package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Seller;

public class SellerList implements SellerDao{
	
	private List<Seller> sellers;
	
	public SellerList() {
		sellers = new ArrayList<>();
	}

	@Override
	public Seller add(Seller o) {
		// TODO Auto-generated method stub
		o.setSeller(true);
		sellers.add(o);
		return o;
	}

	@Override
	public List<Seller> getAll() {
		// TODO Auto-generated method stub
		return sellers;
	}

	@Override
	public Seller getByUsername(String username) {
		// TODO Auto-generated method stub
		for(Seller s : sellers) {
			if(s.getUsername() == username) {
				return s;
			}
		}
		return null;
	}

	@Override
	public boolean remove(Seller o) {
		// TODO Auto-generated method stub
		Seller temp = getByUsername(o.getUsername());
		if(temp == null) {
			return false;
		}
		sellers.remove(0);
		return true;
	}
	
	public boolean checkIfSeller(Seller o) {
		Seller temp = getByUsername(o.getUsername());
		if(temp.isSeller() == false) {
			return false;
		}
		return true;
	}
	
}
