package com.revature.controllers;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.services.AuthService;
import com.revature.services.ReimbService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ReimbController {

	private static ReimbService rs = new ReimbService();
	private static AuthService as = new AuthService();

	public static void getReimbs(Context ctx) {
			String token = ctx.header("Authorization");
		
			if (!as.checkPermission(token, 1,2)) {
				ctx.status(HttpCode.UNAUTHORIZED);
				return;
			}
		List<Reimbursement> r = rs.getReimbs();
		ctx.json(r);
		ctx.status(HttpCode.OK);
	}
	
	public static void getReimbById(Context ctx) {

		String token = ctx.header("Authorization");

		if (!as.checkPermission(token, 1,2)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}

		int rId = Integer.parseInt(ctx.pathParam("id"));
		Reimbursement r = rs.getReimbById(rId);
		if (r != null) {
			ctx.json(r);
			ctx.status(HttpCode.OK);
		} else {

			ctx.status(HttpCode.NOT_FOUND);
		}
	}
	
	public static void getReimbByStatusId(Context ctx) {
		String token = ctx.header("Authorization");

		if (!as.checkPermission(token, 1,2)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}

		int id = Integer.parseInt(ctx.pathParam("id"));
		List<Reimbursement> r = rs.getReimbByStatusId(id);
		if (r != null) {
			ctx.json(r);
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(HttpCode.NOT_FOUND);
		}
	}
	public static void addReimb(Context ctx) {
		String token = ctx.header("Authorization");
		Reimbursement newReimb = null;
		newReimb = rs.addReimb(token, ctx.bodyAsClass(Reimbursement.class));
		
		if (newReimb == null) {
			ctx.status(HttpCode.BAD_REQUEST);
		} else {
			ctx.status(HttpCode.CREATED);
		}
	}
	
	public static void updateReimb(Context ctx) {
		String token = ctx.header("Authorization");

		if (!as.checkPermission(token, 1, 2)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		int id = Integer.parseInt(ctx.pathParam("id"));

		Reimbursement r = ctx.bodyAsClass(Reimbursement.class);

		r.setReimbId(id);

		if (rs.updateReimb(r)) {
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(400);
		}
	}
	
	public static void getReimbByAuthorId(Context ctx) {
		String token = ctx.header("Authorization");

		if (!as.checkPermission(token, 1,2)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}

		int id = Integer.parseInt(ctx.pathParam("id"));
		List<Reimbursement> r = rs.getReimbByUserId(id);
		if (r != null) {
			ctx.json(r);
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(HttpCode.NOT_FOUND);
		}
	}
}
