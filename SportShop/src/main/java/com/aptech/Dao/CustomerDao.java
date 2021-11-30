package com.aptech.Dao;

import java.sql.*;

import com.aptech.Model.Customer;

public class CustomerDao {
	private UtilDb utilDb;

	public CustomerDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}

	public Customer getAccountLogin(String email, String password) {
		Customer customer = new Customer();
		String query = "select * from customer where Email= ? and Password =?";
		
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(query);
			pre.setString(1, email);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				customer.setId(rs.getInt("Id"));
				customer.setEmail(email);
				customer.setPassword(password);
				customer.setAddress(rs.getString("Address"));
				customer.setFullName(rs.getString("FullName"));
				customer.setPhoneNumber(rs.getString("PhoneNumber"));
				return customer;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}

}