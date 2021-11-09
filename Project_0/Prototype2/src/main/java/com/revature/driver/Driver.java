package com.revature.driver;

import java.util.List;
import java.util.Scanner;

import com.revature.controllers.FrontController;
import com.revature.controllers.ShopController;
import com.revature.models.Buyer;
import com.revature.repositories.BagPostgres;
import com.revature.repositories.BuyerDao;
import com.revature.repositories.BuyerPostgres;

public class Driver {
	
	public static void main(String[] args) {
		BuyerDao bd = new BuyerPostgres();
		FrontController fc = new FrontController();
		ShopController shc = new ShopController();
		BagPostgres bagp = new BagPostgres();
		Scanner sc = new Scanner(System.in);
		int id;
		//boolean status = true;
		//Need to make somekind of conditional to only move on when correct responses are added.
		

			
			id = fc.run(sc);
			shc.run(sc, id);

		sc.close();
		
		
//		Run another controller like the ShopController once the FrontController is done running. and so on and so forth 


//		List<Buyer> buys = bd.getAll();
//		for (Buyer b : buys) {
//			System.out.println(b);
//		}
		
//		Buyer newBuyer = new Buyer("Agrin", "poiuyerq", "Davey");
//		Buyer newBuyer1 = new Buyer("VentHero", "qaerthqat", "DeOndre");
		
//		System.out.println("Added " + bd.add(newBuyer) + " to the database.");
//		System.out.println("Added " + bd.add(newBuyer1) + " to the database.");
//		System.out.println(newBuyer);
//		System.out.println(newBuyer1);
//		System.out.println(bd.getByUsername("Jimmy"));
	}

}


////Need to make somekind of conditional to only move on when correct responses are added IN THE MENU
//Make sure it only logs in when a real username / password is added.