package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Album;
import com.revature.repositories.AlbumPostgres;
import com.revature.repositories.BagPostgres;

public class InventoryController {
	private static AlbumPostgres ap = new AlbumPostgres();
	private static BagPostgres bagp = new BagPostgres();
	Scanner sc = new Scanner(System.in);

	public void addToShop() {
		System.out.println("Please enter the title: ");
		String title = sc.nextLine();
		System.out.println("Please enter the artist: ");
		String artist = sc.nextLine();
		System.out.println("Please enter the price: ");
		double price = sc.nextDouble();
		System.out.println("How many would you like to add?");
		int stock = sc.nextInt();
		Album newAlbum = new Album(title, artist, price);
		for(int i = 0; i < stock; i++) {
			ap.add(newAlbum);
		}
		System.out.println(title + "added to the shop.");
	}
	
	public void removeFromShop() {
		System.out.println("Input the item ID of the item you want to remove: ");
		System.out.println("Or Input 0 to exit");
		int id = sc.nextInt();
		if (id > 0) {
			Album newAlbum = new Album();
			newAlbum = ap.getById(id);
			if(ap.getById(id) != null) {
				ap.remove(newAlbum);
				System.out.println(newAlbum + " removed");
			}
			else {
				System.out.println("Invalid input");
			}
		}
		else if(id == 0) {
			System.out.println("Exiting");
		}
		else {
			System.out.println("Invalid input");
		}
	}
	
	public void editPrice() {
		System.out.println("Input the id of the album you want to change the price of");
		System.out.println("Or Input 0 to exit");
		int id = sc.nextInt();
		if (id > 0) {
			System.out.println("Input the new price: ");
			double price = sc.nextDouble();

			if(ap.getById(id) != null) {
				ap.update(id, price);
				System.out.println(ap.getById(id) + " price updated");
			}
			else {
				System.out.println("Invalid input");
			}
		}
		else if (id == 0){
			System.out.println("Exiting");
		}
		else {
			System.out.println("Invalid input");
		}
		
		
	}
	
	public void removeOrder() {
		System.out.println("Input the id of the order you would like to remove");
		System.out.println("Or Input 0 to exit");
		int id = sc.nextInt();
		if (id > 0) {
			if(bagp.checkPaid(id) == false) {
				if(bagp.getById(id)!= null) {
					bagp.remove(id);
					System.out.println("Order removed");
				}
				else {
					System.out.println("Invalid input");
				}
			}
			else {
				System.out.println("Can't remove orders that have been paid");
			}
			
		}
		else if (id == 0) {
			System.out.println("Exiting");
		}
		else {
			System.out.println("Invalid input");
		}
		
	}
	
	public void editOrderPrice() {
		System.out.println("Input the id of the order you would like to update the price");
		System.out.println("Or Input 0 to exit");
		int id = sc.nextInt();
		if (id > 0) {
			if (bagp.checkPaid(id) == false) {
				System.out.println("Input the new price: ");
				double price = sc.nextDouble();
				if(bagp.getById(id)!= null) {
					bagp.updatePrice(price, id);
					System.out.println("Updated price");
				}
				else {
					System.out.println("Invalid input");
				}
			}
			else {
				System.out.println("Can't adjust the price on completed orders");
			}
		}
		else if (id == 0) {
			System.out.println("Exiting");
		}
		else {
			System.out.println("Invalid input");
		}
	}
}
