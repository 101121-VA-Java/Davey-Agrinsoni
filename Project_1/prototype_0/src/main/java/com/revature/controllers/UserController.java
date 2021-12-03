package com.revature.controllers;

import java.util.List;

import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UserController {
	
	private static UserService us = new UserService();
	private static AuthService as = new AuthService();

	public static void getUsers(Context ctx) {
		String token = ctx.header("Authorization");
		if(!as.checkPermission(token, 1, 2)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		
		String username = ctx.queryParam("username");
		
		if (username != null) {
			User u = us.getUserByUsername(username);
			
			if(u != null) {
				ctx.json(u);
				ctx.status(HttpCode.OK);
			} else {
				ctx.status(HttpCode.NOT_FOUND);
			}
		}else {
			List<User> users = us.getUsers();
			
			ctx.json(users);
			ctx.status(HttpCode.OK);
		}
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
	
	public static void registerUser(Context ctx) {
		User newUsr = null;
		newUsr = us.addUser(ctx.bodyAsClass(User.class));
		
		if (newUsr == null) {
			ctx.status(HttpCode.BAD_REQUEST);
		}else {
			ctx.status(HttpCode.CREATED);
		} 
	}
	
	public static void updateUserInfo(Context ctx) {
		String token = ctx.header("Authorization");
		
		if(!as.checkPermission(token, 1,2,3)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		int id = Integer.parseInt(ctx.pathParam("id"));
		
		User u = ctx.bodyAsClass(User.class);
		
		u.setUserId(id);
		if(us.updateUserInfo(u)) {
			ctx.status(HttpCode.OK);
		}else {
			ctx.status(400);
		}
	}
	
	public static void updateUserInfoAdmin(Context ctx) {
		String token = ctx.header("Authorization");
		
		if(!as.checkPermission(token, 1)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		int id = Integer.parseInt(ctx.pathParam("id"));
		
		User u = ctx.bodyAsClass(User.class);
		
		u.setUserId(id);
		
		if(us.updateUserInfoAdmin(u)) {
			ctx.status(HttpCode.OK);
		}else {
			ctx.status(400);
		}
	}
	
	public static void getTest(Context ctx) {
		ctx.result("Test!");
	}
}
