package com.revature;

import java.util.Scanner;
import java.util.Random;

public class ScannerDriver {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//ScannerDriver.loginScreen();
		ScannerDriver.menu();
		// Please close your resources people
		sc.close();
		
		/*
		 * Create a menu that gives a user multiple options:
		 * 		- 1: get a random number
		 * 		- 2: Using StringBuffer, reverse a word of the user's choice
		 * 		- 3: exit the program
		 * This menu should repeat until the user decides to exit.
		 */
	}
	
	public static void loginScreen() {
		String uname = "admin";
		String pass = "pass";
		
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		if(uname.equals(username) && pass.equals(password)) {
			System.out.println("You're logged in.");
		} else {
			System.out.println("Not quite.");
		}
	}
	
	public static void menu() {
		System.out.println("Choose a number between 1 - 3");
		System.out.println("1 for a Random Number Generator");
		System.out.println("2 to Reverse an inputted string");
		System.out.println("3 to close the Program");
		int num = sc.nextInt();
		sc.nextLine();
		while(num != 4){
			if(num == 1) {
				Random rand = new Random();
				int randint = rand.nextInt(100);
				System.out.println(randint);
				menu();
				break;
			}
			if(num == 2) {
				System.out.println("Please enter a word");
				String s = sc.nextLine();
				//sc.nextLine();
				StringBuilder sb = new StringBuilder(s);
				System.out.println(sb.reverse());
				menu();
				break;
			}
			else {
				System.out.println("Goodbye");
				break;
			}
			
		}
	}
}
