package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Buyer;
import com.revature.repositories.BuyerPostgres;

public class BuyerController {
	
	private static BuyerPostgres bp = new BuyerPostgres();
	private static Scanner sc;
	
	public void registerBuyer(Scanner scan) {
		System.out.println("Please enter a username: ");
		String username = scan.nextLine();
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		Buyer newBuyer = new Buyer(username, password, name);
		
		newBuyer = bp.add(newBuyer);
		System.out.println("Successfully registered!");

	}
	
	public int loginBuyer(Scanner scan) {
		System.out.println("Please enter a username: ");
		String username = scan.nextLine();
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		Buyer Logger = new Buyer();
		Logger = bp.getByUsername(username);
		if(Logger == null) {
			System.out.println("Incorrect Username/Password. Please try again.");
			return 0;
		}
		else if (Logger.getUsername().equals(username) && Logger.getPassword().equals(password)) {
			System.out.println("Successfully logged in!");
			return Logger.getId();
		}
		else {
			System.out.println("Incorrect Username/Password. Please try again.");
			return 0;
		}

	}
}
