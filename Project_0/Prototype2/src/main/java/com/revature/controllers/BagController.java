package com.revature.controllers;

import com.revature.models.Album;
import com.revature.repositories.AlbumPostgres;
import com.revature.repositories.BagPostgres;
import com.revature.repositories.BuyerPostgres;

public class BagController {
	private static AlbumPostgres ap = new AlbumPostgres();
	private static BagPostgres bagp = new BagPostgres();
	private static BuyerPostgres bp = new BuyerPostgres();
	String input = new String();

	public void addToBag(int purchase, int id) {
		Album sold = new Album();
		sold = ap.getById(purchase);
		System.out.println("Adding "+ sold + " to your bog.");
		bagp.add(sold, bp.getById(id));
		//ap.remove(sold);
	}
}