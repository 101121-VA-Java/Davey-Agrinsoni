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
	int output = -1;
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
				boolean status1 = true;
				while (status1) {
				System.out.println("\nWould you like to register a Buyer or Seller?");
				String in1 = sc.nextLine().toLowerCase();
				
				switch (in1) {
				case "buyer":
					bc.registerBuyer(sc);
					status1 = false;
					break;
				case "seller":
					ec.registerSeller(sc);
					status1 = false;
					break;
				default:
					System.out.println("\nInvalid input");
					
				}
				}
				break;
				
			case "2":
				boolean status = true;
				while (status) {
					System.out.println("\nAre you buying or selling?");
					String in2 = sc.nextLine().toLowerCase();
					switch (in2) {
					case "buying":
						output = bc.loginBuyer(sc);
						status = false;
						return output;
						//break;
					case "selling":
						output = ec.loginSeller(sc);
						status = false;
						return output;
						//break;
					default:
						System.out.println("\nInvalid input");
					break;
					}
					
				}
			case "3":
				run = false;
				output =-2;
				return output;
				//break;
				
			default:
				System.out.println("\nInvalid input");
			}
		}
		return output;
//		sc.close();
	}
	
}