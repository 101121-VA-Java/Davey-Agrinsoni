package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
import com.revature.controllers.UserController;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();
			config.defaultContentType = "application/json";
		});
		app.start();

		app.before(ctx -> {
			ctx.header("Access-Control-Allow-Headers", "Authorization");
			ctx.header("Access-Control-Expose-Headers", "Authorization");
		});

		app.routes(() -> {
			path("users", () -> {
				get(UserController::getUsers);
				post(UserController::registerUser);

				path("{id}", () -> {
					get(UserController::getUserById);
					put(UserController::updateUserInfo);
					path("admin", () -> {
						put(UserController::updateUserInfoAdmin);
					});
				});
			});
			path("reimbursements", () -> {
				post(ReimbController::addReimb);
				get(ReimbController::getReimbs);

				path("{id}", () -> {
					get(ReimbController::getReimbById);
					put(ReimbController::updateReimb);
					
				});
				path("author", () -> {
					path("{id}", () -> {
						get(ReimbController::getReimbByAuthorId);
						put(ReimbController::updateReimb);
					});
				});
				path("status", () -> {
					path("{id}", () -> {
						get(ReimbController::getReimbByStatusId);
						put(ReimbController::updateReimb);
					});
				});
			});
			path("auth", () -> {
				post(AuthController::login);
			});
		});
	}

}