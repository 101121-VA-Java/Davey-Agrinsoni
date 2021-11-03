package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.UserNotFoundException;
import com.revature.exceptions.UsernameAlreadyInUseException;
import com.revature.models.Buyer;
import com.revature.services.BuyerService;

public class BuyerController {
	
	private static BuyerService bs = new BuyerService();
	private static Buyer log;
	private static Scanner sc;
	
	public void registerBuyer(Scanner scan) {
		System.out.println("Please enter a username: ");
		String username = scan.nextLine();
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		Buyer newBuyer = new Buyer(username, password, name);
		
		try {
			newBuyer = bs.addBuyer(newBuyer);
			System.out.println("Successfully registered!");
		}
		catch (UsernameAlreadyInUseException e) {
			System.out.println("Username already taken. Please input another.");
		}
	}
	
	public void loginBuyer(Scanner scan) {
		//TODO logic
		System.out.println("Please enter a username: ");
		String username = scan.nextLine();
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		
		try {
			log = bs.login(username, password);
			System.out.println("Successfully logged in!");
		}
		catch (UserNotFoundException e) {
			System.out.println("Incorrect Username/Password. Please try again.");
		}
	}
	
}