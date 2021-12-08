package com.aptech.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.aptech.Model.Product;
import com.aptech.Model.ProductType;
import com.aptech.Model.SportType;

public class CategoryDao {

	private UtilDb utilDb;

	public CategoryDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}
	
	public ProductType getProductTypeByID(int id) {
		String query = "SELECT * FROM ProductType WHERE Id =" + id;
		Statement stm;
		try {
			stm = utilDb.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				ProductType item = new ProductType();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("Name"));
				item.setStatus(false);
				return item;
			}
			
		} catch (Exception ex) {
		}
		return null;
	}
	
	public SportType getSportTypeByID(int id) {
		String query = "SELECT * FROM SportType WHERE Id =" + id;
		Statement stm;
		try {
			stm = utilDb.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				SportType item = new SportType();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("Name"));
				item.setStatus(false);
				return item;
			}
		} catch (Exception ex) {
		}
		return null;
	}
}
