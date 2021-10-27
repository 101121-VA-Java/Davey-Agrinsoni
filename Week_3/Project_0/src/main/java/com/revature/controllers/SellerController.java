package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Seller;

public class SellerController {
	
	public void registerSeller(Scanner scan) {
		System.out.println("Please enter a username: ");
		String username = scan.nextLine();
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		Seller newBuyer = new Seller(username, password, name, true);
		
		System.out.println("Successfully registered!");
	}
}
