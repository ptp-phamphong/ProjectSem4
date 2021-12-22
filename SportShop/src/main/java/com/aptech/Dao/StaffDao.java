package com.aptech.Dao;

import java.sql.*;
import java.util.ArrayList;

import com.aptech.Model.*;

public class StaffDao {
	private UtilDb utilDb;

	public StaffDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}
	
	public ArrayList<Staff> getAll() {
		ArrayList<Staff> list = new ArrayList<Staff>();

		String query = "SELECT * FROM Staff";
		Statement stm;
		try {
			stm = utilDb.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Staff item = new Staff();
				item.setId(rs.getInt("Id"));
				item.setFullName(rs.getString("FullName"));
				item.setUsername(rs.getString("Username"));
				item.setEmail(rs.getString("Email"));
				item.setPassword(rs.getString("Password"));
				item.setAddress(rs.getString("Address"));
				item.setPhoneNumber(rs.getString("PhoneNumber"));
				item.setGender(rs.getBoolean("Gender"));
				item.setIsAdmin(rs.getBoolean("isAdmin"));
				item.setStatus(rs.getBoolean("Status"));
        		
				list.add(item);
			}
			return list;
		} catch (Exception ex) {
			System.out.print("abc");
		}
		return list;
	}
	
	public Staff getAccountLogin(String username, String password) {
		Staff staff = new Staff();
		String query = "select * from Staff where Username= '?' and Password = '?' and isAdmin=1";
		
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(query);
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				staff.setId(rs.getInt("Id"));
				staff.setGender(rs.getBoolean("Gender"));
				staff.setEmail(rs.getString("Email"));
				staff.setUsername(username);
				staff.setPassword(password);
				staff.setAddress(rs.getString("Address"));
				staff.setFullName(rs.getString("FullName"));
				staff.setPhoneNumber(rs.getString("PhoneNumber"));
				staff.setIsAdmin(rs.getBoolean("isAdmin"));
				staff.setStatus(rs.getBoolean("Status"));
				return staff;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
}
