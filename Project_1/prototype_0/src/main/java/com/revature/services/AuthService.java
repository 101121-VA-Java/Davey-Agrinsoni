package com.revature.services;

import java.util.Arrays;

import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgres;

public class AuthService {
	
	private UserDao ud = new UserPostgres();
	
	public String login(String username, String password) {
		String token = null;
		
		User log = ud.getByUsername(username);
		
		if(log != null && log.getPassword().equals(password)) {
			token = log.getUserId() + ":" + log.getRole().getUserRoleId();
		}
		
		return token;
		
	}
	
	public boolean checkPermission(String token, int... allowedRoles) {
		if(token == null) {
			return false;
		}
		
		String[] info = token.split(":");
		int token_id = Integer.parseInt(info[0]);
		int token_roleid = Integer.parseInt(info[1]);
		
		User log = ud.getById(token_id);
		
		if(log!= null && token_roleid == log.getRole().getUserRoleId() && Arrays.asList(allowedRoles).contains(token_roleid)) {
			return true;
		}
		
		return false;
	}
}
