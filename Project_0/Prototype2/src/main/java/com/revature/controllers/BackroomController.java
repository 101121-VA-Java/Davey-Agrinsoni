package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Album;
import com.revature.models.Bag;
import com.revature.repositories.AlbumPostgres;
import com.revature.repositories.BagPostgres;

public class BackroomController {

	private static AlbumPostgres ap = new AlbumPostgres();
	private static BagPostgres bagp = new BagPostgres();
	private static BagController bc = new BagController();
	private static InventoryController ic = new InventoryController();
	
	public void run(Scanner sc) {
		boolean run = true;
		String input = new String();

		while(run) {
			System.out.println("\nWelcome to the backroom. What would you like to do?");
			System.out.println("1: View inventory");
			System.out.println("2: View orders");
			System.out.println("3: Exit");
			
			input = sc.nextLine();
			switch(input) {
			case "1":
				
				boolean status = true;
				while (status) {
					List<Album> albums = ap.getAll();
					System.out.println("\n\nCurrent stock");
					for (Album a : albums) {
						System.out.println(a);
					}
					System.out.println("\nWhat would you like to do?");
					System.out.println("1: Add an album to the shop");
					System.out.println("2: Remove an album fom the shop");
					System.out.println("3: Edit the price");
					System.out.println("4: Exit");
					String in = sc.nextLine();
					switch(in) {
					case "1":
						ic.addToShop();
						break;
					case "2":
						ic.removeFromShop();
						break;
					case "3":
						ic.editPrice();
						break;
					case "4":
						status = false;
						break;
					default:
						System.out.println("Invalid input");
					}
				}
				break;
			case "2":
				
				boolean status1 = true;
				while(status1) {
					List<Bag> bags = bagp.getAll();
					System.out.println("\n\nAll items ordered.");
					for (Bag b: bags) {
						System.out.println("User id: " + b.getBuyer_id() +" Order id/item: " + b);
					}
					System.out.println("\nWhat would you like to do?");
					System.out.println("1: Remove order");
					System.out.println("2: Change the price on an order");
					System.out.println("3: Exit");
					String in1 = sc.nextLine();
					
					
					switch(in1) {
					case "1":
						ic.removeOrder();
						break;
					case "2":
						ic.editOrderPrice();
						break;
					case "3":
						status1 = false;
						break;
					default:
						System.out.println("Invalid input");
					}
				}
				break;
			case "3":
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
	}
}
