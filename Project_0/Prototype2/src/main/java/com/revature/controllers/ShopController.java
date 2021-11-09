package com.revature.controllers;


import java.util.List;
import java.util.Scanner;

import com.revature.models.Album;
import com.revature.models.Bag;
import com.revature.repositories.AlbumPostgres;
import com.revature.repositories.BagPostgres;

public class ShopController {
	
	private static AlbumPostgres ap = new AlbumPostgres();
	private static BagPostgres bagp = new BagPostgres();
//	private static Scanner sc;
	private BagController bc;
	
	
	public ShopController() {
//		sc = new Scanner(System.in);
		bc = new BagController();
	}
	
	public void run(Scanner sc, int id) {
		boolean run = true;
		String input = new String();
		int purchase;
		while(run) {
			System.out.println("\nPlease select an option: ");
			System.out.println("1: View inventory");
			System.out.println("2: View orders");
			System.out.println("3: Exit");
			
			input = sc.nextLine();
			switch(input) {
			case "1":
				System.out.println("Here are our current wares.");
				List<Album> albums = ap.getAllSet();			
				for (Album a : albums) {
					System.out.println(a);
				}
				boolean status = true;
				while(status) {
					System.out.println("\nInput the ID number of your desired item.");
					System.out.println("Input 0 if you would like to exit.");
					purchase = sc.nextInt();
					
					if(purchase == 0) {
						System.out.println("Thank you! Come again.");
						status = false;
					}
					else {
						if(ap.getById(purchase)!= null) {
							bc.addToBag(purchase, id);
							sc.nextLine();
							status = false;
						}
						else {
							System.out.println("Invalid input.");
							sc.nextLine();
							}
						}
					}
				sc.nextLine();
				break;
			case "2":
				System.out.println("\nItems you've ordered");
				List<Bag> bags = bagp.getByUserId(id);
				for (Bag b : bags) {
					System.out.println(b);
				}
				System.out.println("\nWhat would you like to do?");
				System.out.println("1.Pay for an item.");
				System.out.println("2.Remove from cart.");
				System.out.println("3.Exit");
				String in1 = sc.nextLine();
				
				switch(in1) {
				case "1":
					boolean status1 = true;
					while(status1) {
						System.out.println("\nInput the ID number of item you would like to pay.");
						System.out.println("Input 0 if you would like to exit.");
						int in2 = sc.nextInt();
						
						if (in2 == 0) {
							sc.nextLine();
							status1 = false;
						}
						else if(bagp.checkPaid(in2) == false) {
							bc.payment(in2);
							sc.nextLine();
							status1 = false;
						}
						else if(bagp.checkPaid(in2) == true) {
							System.out.println("Item is already paid");
						}
						else {
							System.out.println("Invalid input.");
						}
					}
					break;
				case "2":
					boolean status2 = true;
					Bag test = new Bag();
					while(status2) {
						System.out.println("Which item would? you like to remove");
						int in3 = sc.nextInt();
						test = bagp.getById(in3);
						if(bagp.checkPaid(in3) == true) {
							System.out.println("Item already paid for can't remove from cart.");
						}
						else if(bagp.checkPaid(in3) == false && test != null) {
							Album restock = new Album();
							Bag remove = new Bag();
							remove = bagp.getById(in3);
							restock = new Album(remove.getTitle(),remove.getArtist(), remove.getPrice());
							ap.add(restock);
							bc.removeFromCart(in3);
							sc.nextLine();
							status2 = false;
						}
						else {
							System.out.println("Invalid item id.");
						}
					}
					break;
				case "3":
					break;
				default:
					System.out.println("Invalid input");
				}
				
				break;
			case "3":
				run = false;
				break;
			default:
				System.out.println("Invalid input");
			}
		}
		//sc.close();
	}

}
