package com.revature.driver;

import com.revature.controllers.FrontController;
import com.revature.controllers.ShopController;

public class Driver {
	
	public static void main(String[] args) {
		FrontController fc = new FrontController();
		ShopController sc = new ShopController();
		fc.run();
		sc.run();
		//Run another controller like the ShopController once the FrontController is done running. and so on and so forth 
	}

}
