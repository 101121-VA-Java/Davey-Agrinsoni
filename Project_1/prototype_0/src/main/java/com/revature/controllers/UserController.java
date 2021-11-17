package com.revature.controllers;

import java.util.List;

import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UserController {
	
	private static UserService us = new UserService();

	public static void getUsers(Context ctx) {
		List<User> users = us.getUsers();
		
		ctx.json(users);
		ctx.status(HttpCode.OK);
	}
	
	public static void getUserById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		
		User u = us.getUserById(id);
		
		if(u != null) {
			ctx.json(u);
			ctx.status(HttpCode.OK);
		}
		else {
			ctx.status(HttpCode.NOT_FOUND);
		}
	}
	
	public static void getTest(Context ctx) {
		ctx.result("Test!");
	}
}
