package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Album;
import com.revature.repositories.AlbumPostgres;

public class ShopController {
	
	private static AlbumPostgres ap = new AlbumPostgres();
//	private static Scanner sc;
	
//	public ShopController() {
//		sc = new Scanner(System.in);
//	}
	
	public void run(Scanner sc) {
		boolean run = true;
		String input = new String();
		while(run) {
			System.out.println("Please select an option: ");
			System.out.println("1: View inventory");
			System.out.println("2: View purchases");
			System.out.println("3: Exit");
			sc.nextLine();
//			while(sc.hasNextLine()) {
//				System.out.println("Howdy");
//				input = sc.nextLine();
//				//System.out.println();
//			}
			
			input = sc.nextLine();
			switch(input) {
			case "1":
				//TODO Logic
				System.out.println("Here are our current wares.");
				List<Album> albums = ap.getAll();
				for (Album a : albums) {
					System.out.println(a);
				}
				
				break;
			case "2":
				//TODO Logic
				System.out.println("Under Construction");
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
