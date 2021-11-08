package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Seller;
import com.revature.util.ConnectionUtil;

public class SellerPostgres implements SellerDao{

	@Override
	public Seller add(Seller o) {
		Seller newGuy = o;
		String sql = "insert into Sellers (s_username, s_password, s_name, s_seller) values (?, ?, ?, ?) returning id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, o.getUsername());
			ps.setString(2, o.getPassword());
			ps.setString(3, o.getName());
			ps.setBoolean(4, o.isSeller());
			
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
	public List<Seller> getAll() {
		String sql = "select * from Sellers;";
		List<Seller> Sellers = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String s_username = rs.getString("s_username");
				String s_password = rs.getString("s_password");
				String s_name = rs.getString("s_name");
				boolean s_seller = rs.getBoolean("s_seller");
				int id = rs.getInt("id");
				
				Seller newSell = new Seller(s_username, s_password, s_name, id, s_seller);
				Sellers.add(newSell);
			}
		}catch (IOException | SQLException e) {
			e.printStackTrace();
		} 
		return Sellers;
	}

	@Override
	public Seller getByUsername(String username) {
		String sql = "select * from Sellers where s_username = ? ";
		Seller sell = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String s_username = rs.getString("s_username");
				String s_password = rs.getString("s_password");
				String s_name = rs.getString("s_name");
				boolean s_seller = rs.getBoolean("s_seller");
				
				sell = new Seller(s_username, s_password, s_name, id, s_seller);
			}
		}
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return sell;
	}

	@Override
	public boolean remove(Seller o) {
		int rs = -1;
		String sql = "delete from Sellers where id = ?;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, o.getId());
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