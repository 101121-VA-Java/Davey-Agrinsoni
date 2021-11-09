package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Bag;
import com.revature.repositories.AlbumPostgres;
import com.revature.repositories.BagPostgres;

public class BackroomController {

	private static AlbumPostgres ap = new AlbumPostgres();
	private static BagPostgres bagp = new BagPostgres();
	private static BagController bc = new BagController();
	
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
				break;
			case "2":
				System.out.println("\nAll items ordered.");
				List<Bag> bags = bagp.getAll();
				for (Bag b: bags) {
					System.out.println("User id: " + b.getBuyer_id() +" Order id and item: " + b);
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
