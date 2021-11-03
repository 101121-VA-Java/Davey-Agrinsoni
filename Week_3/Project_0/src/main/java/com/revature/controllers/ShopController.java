package com.revature.controllers;

import java.util.Scanner;

import com.revature.services.AlbumService;

public class ShopController {
	
	private static AlbumService bs = new AlbumService();
	private static Scanner sc;
	
	//I'm still not sure if these should go here or be separated into different Service files.????
	public void run() {
		boolean run = true;
		//TODO Logic 
		
		while(run) {
			
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
				run = false;
				break;
			
			default:
				System.out.println("Invalid input");
				}
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
		//Have a way for people to pay for things they've been approved for.
	}
	
	public void viewPayments() {
		//TODO Logic
	}
	
	public void makePayment() {
		//TODO Logic
	}


	
	/* IDEAS THAT NEED TO BE FLUSHED OUT ARE JUST BEING PLACED HERE SO I DON'T FORGET THEM.
	 * Make a big ArrayList of Object type Albums. Duplicates allowed. Inventory will be just be how many times it shows up on the list.
	 * 
	 * When showing the Buyer what is in the store maybe make a set from the list to remove duplicates and only show unique entries.
	 *
	 * Some kinda of input prompt which will ask them to type a number based on which album they want. 
	 * 
	 * Have a comparator compare the contents of the object at the index of the input from the set to the contents of the bigger <Album> Array List
	 * 
	 * When it finds a match it will remove one instance of that item to indicate the stock going down by one to reserve a copy for the Buyer
	 * 
	 * A copy of the chosen Album object will placed into another <Album>ArrayList which will be called something along the lines of UnpaidAlbumsBag
	 * 
	 * After each "Reservation" ask the Buyer if they are done shopping/ want to view their bag or are done shopping.
	 * 
	 * In a controller that will handle the shop interface (so maybe this one(?)) have an option to view your UnpaidAlbumsBag to see what you need to pay.
	 * 
	 * Assuming I figure out how the approval thing works it'll show if an item has been approved for purchase and if so the customer get's a prompt to input a payment method.
	 * 
	 * The payment method will only be Credit/Debit card which be a another model constructed which takes in a 10 digit number as the Card# then a random date in the future and a pin of 3 numbers
	 * 
	 * If the user's inputs don't match those presets let them know it's not a "valid" card.
	 * 
	 * Once a "valid" card has been inputted the Album that they are trying to payoff will be removed from the UnpaidAlbumsBag and moved into a different list called OwnedAlbums.
	 */
	
}