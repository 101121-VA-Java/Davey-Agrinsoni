package com.revature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.repositories.UserPostgres;
import com.revature.util.ConnectionUtil;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class Driver {
	// private static UserPostgres up = new UserPostgres();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();
			}).start();
		
		app.routes(() -> {
			path("users", () -> {
				get(UserController::getUsers);
				path("test", () -> {
					get(UserController::getTest);
				});
				path("{id}", () -> {
					get(UserController::getUserById);
				});
			});
		});
	}

}

//app.get("users", (ctx) ->{
//	List<User> list = up.getAll();
//	ctx.json(list);
//	ctx.status(HttpCode.OK);
//});