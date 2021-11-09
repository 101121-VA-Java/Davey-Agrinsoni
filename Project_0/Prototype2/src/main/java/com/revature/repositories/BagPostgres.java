package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Album;
import com.revature.models.Bag;
import com.revature.models.Buyer;
import com.revature.util.ConnectionUtil;

public class BagPostgres {
	
	public void add(Album a, Buyer b) {
		String sql = "insert into Bags (buyer_id, title, artist, price, paid) values (?, ?, ?, ?, ?);";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, b.getId());
			ps.setString(2, a.getTitle());
			ps.setString(3, a.getArtist());
			ps.setDouble(4, a.getPrice());
			ps.setBoolean(5, false);
			
			boolean rs = ps.execute();
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Bag> getAll() {
		String sql = "select * from Bags;";
		List<Bag> Bags = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				int buyer_id = rs.getInt("buyer_id");
				String title = rs.getString("title");
				String artist = rs.getString("artist");
				double price = rs.getDouble("price");
				boolean paid = rs.getBoolean("paid");
				int id = rs.getInt("id");
				
				Bag newBag = new Bag(id, buyer_id, title, artist, price, paid);
				Bags.add(newBag);
			}
		}
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return Bags;
	}

	public List<Bag> getByUserId(int id){
		String sql = "select * from Bags where buyer_id = " + id + ";";
		List<Bag> Bags = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				int buyer_id = rs.getInt("buyer_id");
				String title = rs.getString("title");
				String artist = rs.getString("artist");
				double price = rs.getDouble("price");
				boolean paid = rs.getBoolean("paid");
				int b_id = rs.getInt("id");
				
				Bag newBag = new Bag(b_id, buyer_id, title, artist, price, paid);
				Bags.add(newBag);
			}
		}
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return Bags;
	}
	
	public boolean remove(int id) {
		int rs = -1;
		String sql = "delete from Bags where id = ?;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeUpdate();
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		if (rs > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean updatePaid(int id) {
		int rs = -1;
		String sql = "update Bags set paid = true where id = ?;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeUpdate();
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		if (rs > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}