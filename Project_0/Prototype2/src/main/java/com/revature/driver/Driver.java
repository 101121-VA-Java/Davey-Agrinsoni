package com.revature.driver;

import java.util.Scanner;

import com.revature.controllers.BackroomController;
import com.revature.controllers.FrontController;
import com.revature.controllers.ShopController;

public class Driver {
	
	public static void main(String[] args) {
		FrontController fc = new FrontController();
		ShopController shc = new ShopController();
		BackroomController back = new BackroomController();

		Scanner sc = new Scanner(System.in);
		int id = -1;
		boolean status = true;

		while(status) {
			id = fc.run(sc);
			if (id == -2) {
				status =false;
			}
			else if (id > 0) {
				shc.run(sc, id);
			}
			else if(id == 0) {
				back.run(sc);
			}
		}
		sc.close();
	}

}