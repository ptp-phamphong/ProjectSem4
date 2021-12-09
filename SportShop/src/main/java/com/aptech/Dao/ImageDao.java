package com.aptech.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.aptech.Model.Image;
import com.aptech.Model.ProductType;

public class ImageDao {

	private UtilDb utilDb;
	
	public ImageDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}
	
	public ArrayList<Image> getByIdProduct(int id){
		ArrayList<Image> list = new ArrayList<Image>();
		
		String query = "SELECT * FROM Image WHERE ProductId = " + id;
		Statement stm;
		try {
			stm = utilDb.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Image item = new Image();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("Name"));
				list.add(item);
			}
			
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		
		return list;
	}
}
