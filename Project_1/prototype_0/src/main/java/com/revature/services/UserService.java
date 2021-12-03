package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.models.Role;
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
	
	public User getUserByUsername(String username) {
		User u = ud.getByUsername(username);
		if(u != null) {
			u.setPassword(null);
		}
		return u;
	}
	
	public User addUser(User u) {
		System.out.println(u);
		u.setRole(new Role(3, "Employee"));
		return ud.add(u);
	}
	
	public boolean updateUserInfo(User u) {
		User update = ud.getById(u.getUserId());
		
		if(u.getFirstName() != null && !u.getFirstName().equals(update.getFirstName())) {
			update.setFirstName(u.getFirstName());
		}
		
		if(u.getLastName() != null && !u.getLastName().equals(update.getLastName())) {
			update.setLastName(u.getLastName());
		}
		
		if(u.getUsername() != null && !u.getUsername().equals(update.getUsername())) {
			update.setUsername(u.getUsername());
		}
		
		if(u.getPassword() != null && !u.getPassword().equals(update.getPassword())) {
			update.setPassword(u.getPassword());
		}
		
		if(u.getEmail() != null && !u.getEmail().equals(update.getEmail())) {
			update.setEmail(u.getEmail());
		}
		
		return ud.update(update);
	}
	
	public boolean updateUserInfoAdmin(User u) {
		User update = ud.getById(u.getUserId());
		
		if(u.getRole() != null && !u.getRole().equals(update.getRole())) {
			update.setRole(u.getRole());
		}
		
		return ud.update(update);
	}
}
