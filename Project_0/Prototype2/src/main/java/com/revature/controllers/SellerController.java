package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Buyer;
import com.revature.models.Seller;
import com.revature.repositories.BuyerPostgres;
import com.revature.repositories.SellerPostgres;

public class SellerController {
	
	private static SellerPostgres sp = new SellerPostgres();
	private static BuyerPostgres bp = new BuyerPostgres();
	
	public void registerSeller(Scanner scan) {
		boolean status = true;
		while(status) {
			System.out.println("Please enter a username: ");
			String username = scan.nextLine();
			username = username.replace(" ", "");
			System.out.println("Please enter a password: ");
			String password = scan.nextLine();
			password = password.replace(" ", "");
			System.out.println("Please enter your name: ");
			String name = scan.nextLine();
			name = name.replace(" ", "");
			Seller newSeller = new Seller(username, password, name);
			Buyer newBuyer = new Buyer(username, password, name);
			newSeller = sp.add(newSeller);
			newBuyer = bp.add(newBuyer);
			//make it so when they register as a seller they also get registered as a buyer at the same time
			if(newSeller.getId()!=0 && newBuyer.getId()!=0) {
				System.out.println("Successfully registered!");
				status = false;
			}
			else if(newSeller.getId() == 0 ||newBuyer.getId() == 0) {
				System.out.println("Username already taken. Please input another.");
				
			}
		}
	}
	
	public int loginSeller(Scanner scan) {
		boolean status = true;
		Seller Logger = new Seller();
		while(status) {
			System.out.println("Please enter a username: ");
			String username = scan.nextLine();
			username = username.replace(" ", "");
			System.out.println("Please enter a password: ");
			String password = scan.nextLine();
			password = password.replace(" ", "");
			Logger = sp.getByUsername(username);
			if(Logger.getUsername().equals(username) && Logger.getPassword().equals(password) && Logger.isSeller() == true) {
				System.out.println("Successfully logged in!");
				status = false;
				}
			else if(Logger.getUsername().equals(username) && Logger.getPassword().equals(password) && Logger.isSeller() == false) {
				System.out.println("Not a Seller log in as a Buyer.");
				status = false;
			}
			else {
				System.out.println("Incorrect Username/Password. Please try again.");
			}
		}
		return 0;
		}

}
