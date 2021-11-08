package com.revature.controllers;

import java.util.Scanner;

public class FrontController {
	
//	private Scanner sc;
	private BuyerController bc;
	private SellerController ec;
	
	public FrontController() {
//		sc = new Scanner(System.in);
		bc = new BuyerController();
		ec = new SellerController();
	}
	int output = 0;
	public int run(Scanner sc) {
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option: ");
			System.out.println("1: Register");
			System.out.println("2: Login");
			System.out.println("3: Exit");
			
			String input = sc.nextLine();
			
			switch(input) {
			case "1": 
				System.out.println("Would you like to register a Buyer or Seller?");
				String in1 = sc.nextLine().toLowerCase();
				
				switch (in1) {
				case "buyer":
					bc.registerBuyer(sc);
					break;
				case "seller":
					ec.registerSeller(sc);
					break;
				default:
					System.out.println("Invalid input");
					
				}
				break;
			
			case "2":
				System.out.println("Are you buying or selling?");
				String in2 = sc.nextLine().toLowerCase();
				switch (in2) {
				case "buying":
					output = bc.loginBuyer(sc);
					break;
				case "selling":
					ec.loginSeller(sc);
					break;
				default:
					System.out.println("Invalid input");
				break;
				}
			
			case "3":
				run = false;
				break;
				
			default:
				System.out.println("Invalid input");
			}
		}
		return output;
//		sc.close();
	}
	
}