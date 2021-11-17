package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgres;

public class UserService {
	private UserDao ud = new UserPostgres();

	public List<User> getUsers() {
		List<User> users = ud.getAll().stream().map(o -> {
			o.setPassword(null);
			return o;
		}).collect(Collectors.toList());
		return users;
	}

	public User getUserById(int id) {
		User u = ud.getById(id);
		if (u != null) {
			u.setPassword(null);
		}
		return u;
	}
}
