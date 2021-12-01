package com.revature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
import com.revature.controllers.UserController;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.ReimbursementPostgres;
import com.revature.repositories.UserPostgres;
import com.revature.util.ConnectionUtil;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class Driver {
	// private static UserPostgres up = new UserPostgres();
//	private static ReimbursementPostgres rp = new ReimbursementPostgres();

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
				// use brackets to indicate path param name
				path("{id}", () -> {
					get(ReimbController::getReimbById);
					put(ReimbController::updateReimb);
//					delete(ReimbController::deleteReimbById);

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
//	public static void main(String[] args) {
//		List<Reimbursement> Remis = rp.getAll();
//
//		for (Reimbursement r : Remis) {
//			System.out.println(r.getReimbId() + " Amount: " + r.getAmount() + " Submitted: " + r.getTimeSubmitted()
//					+ " Resolved: " + r.getTimeResolved() + " Descrip: " + r.getDescription() + " Author: "
//					+ r.getReimbAuthor().getUsername() + " Resolver: " + r.getReimbResolver().getUsername()
//					+ " Status Id: " + r.getStatusId().getStatusId() + " Status: " + r.getStatusId().getStatus()
//					+ " Type Id: " + r.getTypeId().getTypeId() + " Type: " + r.getTypeId().getType());
//		}
//
//	}
}