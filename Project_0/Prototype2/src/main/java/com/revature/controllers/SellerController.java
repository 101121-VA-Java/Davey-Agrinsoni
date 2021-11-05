package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Seller;
import com.revature.repositories.SellerPostgres;

public class SellerController {
	
	private static SellerPostgres sp = new SellerPostgres();
	private static Scanner sc;
	
	public void registerSeller(Scanner scan) {
		System.out.println("Please enter a username: ");
		String username = scan.nextLine();
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		Seller newSeller = new Seller(username, password, name);
		
		newSeller = sp.add(newSeller);
		System.out.println("Seccessfully registered!");
	}
	
	public void loginSeller(Scanner scan) {
		System.out.println("Please enter a username: ");
		String username = scan.nextLine();
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		Seller Logger = new Seller();
		Logger = sp.getByUsername(username);
		if(Logger.getUsername().equals(username) && Logger.getPassword().equals(password) && Logger.isSeller() == true) {
			System.out.println("Successfully logged in!");
			}
		else if(Logger.getUsername().equals(username) && Logger.getPassword().equals(password) && Logger.isSeller() == false) {
			System.out.println("Not a Seller log in as a Buyer.");
		}
		else {
			System.out.println("Incorrect Username/Password. Please try again.");
		}
	}

}
