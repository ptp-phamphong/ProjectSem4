package com.aptech.Dao;

import java.sql.*;

import com.aptech.Model.*;

public class StaffDao {
	private UtilDb utilDb;

	public StaffDao() {
		utilDb = new UtilDb();
		utilDb.connect();
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
