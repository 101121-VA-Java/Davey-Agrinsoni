package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Buyer;
import com.revature.repositories.BuyerPostgres;
import com.revature.repositories.SellerPostgres;

public class BuyerController {
	
	private static BuyerPostgres bp = new BuyerPostgres();
	private static SellerPostgres sp = new SellerPostgres();
	
	public void registerBuyer(Scanner scan) {
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
			Buyer newBuyer = new Buyer(username, password, name);
			Buyer newBuyer1 = new Buyer(username, password, name);
			newBuyer = bp.add(newBuyer);
			newBuyer1 = sp.addBuy(newBuyer1);
			if(newBuyer.getId() != 0 && newBuyer1.getId() != 0) {
				System.out.println("Successfully registered!");
				status = false;
			}
			else if(newBuyer.getId() == 0 || newBuyer1.getId() == 0) {
				System.out.println("Username already taken. Please input another.");
			}
		}
	}
	
	public int loginBuyer(Scanner scan) {
		boolean status = true;
		Buyer Logger = new Buyer();
		while(status) {
			System.out.println("Please enter a username: ");
			String username = scan.nextLine();
			username = username.replace(" ", "");
			System.out.println("Please enter a password: ");
			String password = scan.nextLine();
			password = password.replace(" ", "");
			Logger = bp.getByUsername(username);
			if(Logger == null) {
				System.out.println("Incorrect Username/Password. Please try again.");
			}
			else if (Logger.getUsername().equals(username) && Logger.getPassword().equals(password)) {
				System.out.println("Successfully logged in!");
				status = false;
				return Logger.getId();
				
			}
			else {
				System.out.println("Incorrect Username/Password. Please try again.");
			}
		}
		return Logger.getId();
	}
}
