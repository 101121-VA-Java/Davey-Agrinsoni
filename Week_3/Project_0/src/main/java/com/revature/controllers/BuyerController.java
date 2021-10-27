package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Buyer;

public class BuyerController {
	
	public void registerBuyer(Scanner scan) {
		System.out.println("Please enter a username: ");
		String username = scan.nextLine();
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		Buyer newBuyer = new Buyer(username, password, name);
		
		System.out.println("Successfully registered!");
	}

}
