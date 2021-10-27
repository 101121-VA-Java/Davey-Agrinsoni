package com.revature.models;

public class Seller extends Buyer {
	
	private boolean seller;

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seller(String username, String password, String name, boolean seller) {
		super(username, password, name);
		this.seller = seller;
		// TODO Auto-generated constructor stub
	}

	public boolean isSeller() {
		return seller;
	}

	public void setSeller(boolean seller) {
		this.seller = seller;
	}
	
	@Override
	public String toString() {
		return "Seller [username=" + getUsername() + ", password=" + getPassword() + ", name=" + getName() + "]";
	}
}