package com.revature.controllers;

import java.util.Scanner;

import com.revature.services.AlbumService;

public class ShopController {
	
	private static AlbumService bs = new AlbumService();
	private static Scanner sc;
	
	//I'm still not sure if these should go here or be separated into different Service files.????
	public void enterShop(){
		//TODO Logic 
		//Present options to either 1. View Inventory or 2.View Purchases
		System.out.println("Please select an option: ");
		System.out.println("1: View inventory");
		System.out.println("2: View purchases");
		System.out.println("3: Exit");
		
		String input = sc.nextLine();
		
		switch(input) {
		case "1": 
			//Temp stuff but might just call a different controller? Or more this to front somehow??
			System.out.println("Here are our current wares.");
			//go into inventory controller?
			break;
		
		case "2":
			System.out.println("Here are all your orders.");
			break;
			
		case "3":
			//run = false;
			break;
			
		default:
			System.out.println("Invalid input");
		}
		sc.close();
	}
	
	public double makeOffer(Scanner scan) {
		//TODO Logic
		//Maybe this should be void or boolean? which goes into another method
		return 0.0;
	}
	
	public void viewPurchases(){ //List<Album> possibly a return type?
		//TODO Logic
		//List<Album> bag = new ArrayList<>();
	}
	
	public void viewPayments() {
		//TODO Logic
	}
	
	public void makePayment() {
		//TODO Logic
	}

}