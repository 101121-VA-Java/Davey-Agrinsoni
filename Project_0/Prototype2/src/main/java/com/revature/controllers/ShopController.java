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
			System.out.println("Please select an option: ");
			System.out.println("1: View inventory");
			System.out.println("2: View purchases");
			System.out.println("3: Exit");
			
			input = sc.nextLine();
			switch(input) {
			case "1":
				System.out.println("Here are our current wares.");
				List<Album> albums = ap.getAll();
				for (Album a : albums) {
					System.out.println(a);
				}
				
				System.out.println("Choose an item.");
				purchase = sc.nextInt();
				
				if(ap.getById(purchase)!= null) {
					bc.addToBag(purchase, id);
					sc.nextLine();
					break;
				}
				else {
					System.out.println("Invalid input.");
					sc.nextLine();
					break;
				}	
			case "2":
				//TODO Logic
				System.out.println("Items in your bag");
				List<Bag> bags = bagp.getByUserId(id);
				for (Bag b : bags) {
					System.out.println(b);
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
