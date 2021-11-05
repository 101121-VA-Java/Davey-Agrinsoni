package com.revature.controllers;

import java.util.Scanner;

public class ShopController {
	
	private static Scanner sc;
	
	public void run() {
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option: ");
			System.out.println("1: View inventory");
			System.out.println("2: View purchases");
			System.out.println("3: Exit");
			
			String input = sc.nextLine();
			
			switch(input) {
			case "1":
				//TODO Logic
				break;
			case "2":
				//TODO Logic
				break;
			case "3":
				run = false;
				break;
			default:
				System.out.println("Invalid input");
			}
		}
		sc.close();
	}

}
