package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class ReimbursementPostgres implements ReimbDao{

	@Override
	public Reimbursement add(Reimbursement o) {
		Reimbursement newReib = o;
		String sql = "insert into ERS_REIMBURSEMENTS (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REMI_TYPE_ID) values (?, ?, ?, ?, ?, ?, ?, ?) returning REIMB_ID;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, o.getAmount());
			ps.setTimestamp(2, o.getTimeSubmitted());
			ps.setTimestamp(3, o.getTimeResolved());
			ps.setString(4, o.getDescription());
			ps.setInt(5, o.getReimbAuthor().getUserId());
			ps.setInt(6, o.getReimbResolver().getUserId());
			ps.setInt(7, o.getStatusId().getStatusId());
			ps.setInt(8, o.getTypeId().getTypeId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				newReib.setReimbId(rs.getInt("REIMB_ID"));
			}
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return newReib;
	}

	@Override
	public List<Reimbursement> getAll() {
		String sql = "select * from ERS_REIMBURSEMENTS;";
		List<Reimbursement> Reimbs = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submitted = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String descrip = rs.getString("REIMB_DESCRIPTION");
				int author = rs.getInt("REIMB_AUTHOR");
				int resolver = rs.getInt("REIMB_RESOLVER");
				int statusId = rs.getInt("REIMB_STATUS_ID");
				int typeId = rs.getInt("REMI_TYPE_ID");
				
				
//				Reimbursement newReib = new Reimbursement(id, amount, submitted, resolved, descrip, new User(author), new User(resolver), new Status(statusId), new Type(typeId));

			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} 
		return Reimbs;
	}

	@Override
	public Reimbursement getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Reimbursement o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reimbursement o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reimbursement> getAllByUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkApproved(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateApproval(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
