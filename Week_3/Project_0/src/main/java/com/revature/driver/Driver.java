package com.revature.driver;

import com.revature.controllers.FrontController;

public class Driver {
	
	public static void main(String[] args) {
		FrontController fc = new FrontController();
		fc.run();
		//Run another controller like the ShopController once the FrontController is done running. and so on and so forth 
	}

}
