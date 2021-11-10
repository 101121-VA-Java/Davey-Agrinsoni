package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Album;
import com.revature.repositories.AlbumPostgres;
import com.revature.repositories.BagPostgres;
import com.revature.repositories.BuyerPostgres;

public class BagController {
	private static AlbumPostgres ap = new AlbumPostgres();
	private static BagPostgres bagp = new BagPostgres();
	private static BuyerPostgres bp = new BuyerPostgres();
	String input = new String();
	Scanner sc = new Scanner(System.in);

	public void addToBag(int purchase, int id) {
		Album sold = new Album();
		sold = ap.getById(purchase);
		System.out.println("Adding "+ sold + " to your cart.");
		bagp.add(sold, bp.getById(id));
		ap.remove(sold);
	}
	
	public void payment(int id) {
		boolean status = true;
		while(status) {
		System.out.println("\nPlease input your credit card number:");
		String ccn = sc.nextLine();
		ccn = ccn.replace(" ", "");
			if (ccn.length() == 16 && ccn.matches("[^a-zA-Z]+")) {
				if(bagp.updatePaid(id) == true) {
					System.out.println("Item is now paid");
					status = false;
				}
				else {
					System.out.println("\nInvalid item id");
				}
			}
			else {
				System.out.println("\nInvalid credit card number.");
			}
			
		}
	}

	public void removeFromCart(int id) {

			if(bagp.remove(id) == true) {
				System.out.println("Item removed from cart");
				
			}
			else {
				System.out.println("Invalid item id");
			}
	}
	
}