package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Buyer;
import com.revature.util.ConnectionUtil;

public class BuyerPostgres implements BuyerDao{

	@Override
	public Buyer add(Buyer o) {
		Buyer newGuy = o;
		String sql = "insert into Buyers (b_username, b_password, b_name) values (?, ?, ?) returning id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, o.getUsername());
			ps.setString(2, o.getPassword());
			ps.setString(3, o.getName());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				newGuy.setId(rs.getInt("id"));
			}
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return newGuy;
	}

	@Override
	public List<Buyer> getAll() {
		String sql = "select * from Buyers;";
		List<Buyer> Buyers = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String b_username = rs.getString("b_username");
				String b_password = rs.getString("b_password");
				String b_name = rs.getString("b_name");
				int id = rs.getInt("id");
				
				Buyer newBuy = new Buyer(b_username, b_password, b_name, id);
				Buyers.add(newBuy);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} 
		return Buyers;
	}

	@Override
	public Buyer getByUsername(String username) {
		String sql = "select * from Buyers where b_username = ? ";
		Buyer buy = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String b_username = rs.getString("b_username");
				String b_password = rs.getString("b_password");
				String b_name = rs.getString("b_name");
				
				buy = new Buyer(b_username, b_password, b_name, id);
				
			}
		}
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return buy;
	}

	@Override
	public boolean remove(Buyer o) {
		int rs = -1;
		String sql = "delete from Buyers where id = ?;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
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