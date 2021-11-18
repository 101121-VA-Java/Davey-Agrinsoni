package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements UserDao{

	@Override
	public User add(User o) {
		User newGuy = o;
		String sql = "insert into ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) values (?, ?, ?, ?, ?, ?) returning ERS_USERS_ID;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, o.getUsername());
			ps.setString(2, o.getPassword());
			ps.setString(3, o.getFirstName());
			ps.setString(4, o.getLastName());
			ps.setString(5, o.getEmail());
			ps.setInt(6, o.getRole().getUserRoleId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				newGuy.setUserId(rs.getInt("ERS_USERS_ID"));
			}
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return newGuy;

	}

	@Override
	public List<User> getAll() {
		String sql = "select * from ers_users full join ers_user_roles on user_role_id = ers_user_roles.ers_user_role_id;";
		List<User> Users = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ERS_USERS_ID");
				String username = rs.getString("ERS_USERNAME");
				String password = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				int roleId = rs.getInt("USER_ROLE_ID");
				String role = rs.getString("USER_ROLE");
				
				
				User newUser = new User(id, username, password, firstName, lastName, email, new Role(roleId, role));
				Users.add(newUser);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} 
		return Users;
	}

	@Override
	public User getById(int id) {
		String sql = "select * from ers_users full join ers_user_roles on user_role_id = ers_user_roles.ers_user_role_id where ers_users_id = ?;";
		User use = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int userId = rs.getInt("ERS_USERS_ID");
				String username = rs.getString("ERS_USERNAME");
				String password = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				int roleId = rs.getInt("USER_ROLE_ID");
				String role = rs.getString("USER_ROLE");
				
				use = new User(userId, username, password, firstName, lastName, email, new Role(roleId, role));
				
			}
		} 
		catch (IOException | SQLException e) {
			e.printStackTrace();
		} 
		return use;
	}
	
	@Override
	public User getByUsername(String username) {
		String sql = "select * from ers_users full join ers_user_roles on user_role_id = ers_user_roles.ers_user_role_id where ERS_USERNAME = ?;";
		User use = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int userId = rs.getInt("ERS_USERS_ID");
				String u_username = rs.getString("ERS_USERNAME");
				String password = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				int roleId = rs.getInt("USER_ROLE_ID");
				String role = rs.getString("USER_ROLE");
				
				use = new User(userId, u_username, password, firstName, lastName, email, new Role(roleId, role));
				
			}
		} 
		catch (IOException | SQLException e) {
			e.printStackTrace();
		} 
		return use;
	}

	@Override
	public boolean remove(User o) {
		int rs = -1;
		String sql = "delete from ERS_USERS where USER_ROLE_ID = ?;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, o.getUserId());
			rs = ps.executeUpdate();
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		if (rs > 0) {
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean update(User o) {
		int rs = -1;
		String sql = "update ERS_USERS set roleId where USER_ROLE_ID = ?;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, o.getUserId());
			rs = ps.executeUpdate();
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		if (rs > 0) {
			return true;
		}
		else{
			return false;
		}
	}
}