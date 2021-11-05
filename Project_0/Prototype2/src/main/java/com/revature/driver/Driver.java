package com.revature.driver;

import java.util.List;

import com.revature.controllers.FrontController;
import com.revature.controllers.ShopController;
import com.revature.models.Buyer;
import com.revature.repositories.BuyerDao;
import com.revature.repositories.BuyerPostgres;

public class Driver {
	
	public static void main(String[] args) {
		BuyerDao bd = new BuyerPostgres();
		FrontController fc = new FrontController();
		ShopController sc = new ShopController();
		fc.run();
		sc.run();
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