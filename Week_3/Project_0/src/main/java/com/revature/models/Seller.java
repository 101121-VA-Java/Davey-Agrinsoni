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
		return "Seller [username= " + username + ", password= " + password + ", name= " + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (seller ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		if (seller != other.seller)
			return false;
		return true;
	}
	

}