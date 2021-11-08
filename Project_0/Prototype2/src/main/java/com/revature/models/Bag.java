package com.revature.models;

public class Bag {
	private int id;
	private int buyer_id;
	private String title;
	private String artist;
	private double price;
	private boolean paid;
	
	
	public Bag() {
		super();
	}

	public Bag(int id, int buyer_id, String title, String artist, double price, boolean paid) {
		super();
		this.id = id;
		this.buyer_id = buyer_id;
		this.title = title;
		this.artist = artist;
		this.price = price;
		this.paid = paid;
	}

	public Bag(int buyer_id, String title, String artist, double price, boolean paid) {
		super();
		this.buyer_id = buyer_id;
		this.title = title;
		this.artist = artist;
		this.price = price;
		this.paid = paid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return  id + " " + title + " by " + artist + ": $" + price + " paid status: " + paid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + buyer_id;
		result = prime * result + id;
		result = prime * result + (paid ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bag other = (Bag) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (buyer_id != other.buyer_id)
			return false;
		if (id != other.id)
			return false;
		if (paid != other.paid)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
