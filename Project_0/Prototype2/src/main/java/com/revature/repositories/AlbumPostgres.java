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
import com.revature.util.ConnectionUtil;

public class AlbumPostgres implements AlbumDao{

	@Override
	public Album add(Album a) {
		Album newAlbum = a;
		String sql = "insert into Albums (title, artist, price) values (?, ?, ?) returning id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, a.getTitle());
			ps.setString(2, a.getArtist());
			ps.setDouble(3, a.getPrice());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				newAlbum.setId(rs.getInt("id"));
			}
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return newAlbum;
	}

	@Override
	public List<Album> getAll() {
		String sql = "select * from Albums;";
		List<Album> Albums = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String title = rs.getString("title");
				String artist = rs.getString("artist");
				double price = rs.getDouble("price");
				int id = rs.getInt("id");
				
				Album newAlbum = new Album(title, artist, price, id);
				Albums.add(newAlbum);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return Albums;
	}
	
	public List<Album> getAllSet() {
		String sql = "select distinct on (title) id, title, artist, price from Albums order by title;";
		List<Album> Albums = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String title = rs.getString("title");
				String artist = rs.getString("artist");
				double price = rs.getDouble("price");
				int id = rs.getInt("id");
				
				Album newAlbum = new Album(title, artist, price, id);
				Albums.add(newAlbum);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return Albums;
	}

	@Override
	public Album getByTitle(String title) {
		String sql = "select * from Albums where title = ?;";
		Album album = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, title);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String a_title = rs.getString("title");
				String artist = rs.getString("artist");
				double price = rs.getDouble("price");
				
				album = new Album(a_title, artist, price, id);
				
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return album;
	}
	
	@Override
	public Album getById(int id) {
		String sql = "select * from Albums where id = ?;";
		Album album = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int a_id = rs.getInt("id");
				String title = rs.getString("title");
				String artist = rs.getString("artist");
				double price = rs.getDouble("price");
				
				album = new Album(title, artist, price, a_id);
			}
		}
			catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return album;
	}

	@Override
	public boolean remove(Album a) {
		int rs = -1;
		String sql = "delete from Albums where id = ?;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getId());
			rs = ps.executeUpdate();
		
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		if (rs > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean update(int id, double price) {
		int rs = -1;
		String sql = "update Albums set price = ? where id = ?;";
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, price);
			ps.setInt(2, id);
			
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