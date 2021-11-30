package com.aptech.Dao;

import java.sql.*;
import java.util.ArrayList;

import com.aptech.Model.Product;

public class ProductDao {

	private UtilDb utilDb;

	public ProductDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}

	public ArrayList<Product> getAll() {

		ArrayList<Product> list = new ArrayList<Product>();

        String query = "SELECT * FROM Product";
        Statement stm;
        try {
            stm = utilDb.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
            	Product item = new Product();
            	item.setId(rs.getInt("id"));
            	item.setName(rs.getString("name"));
            
                list.add(item);
            }
            return list;
        } catch (Exception ex) {
        	System.out.print("abc");
        }
        return list;
	}
}
