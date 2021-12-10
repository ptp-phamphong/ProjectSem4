package com.aptech.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.aptech.Model.Image;
import com.aptech.Model.ProductDetail;

public class ProductDetailDao {

	private UtilDb utilDb;
	
	
	public ProductDetailDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}
	
	
	public ArrayList<ProductDetail> getByIdProduct(int id){
		ArrayList<ProductDetail> list = new ArrayList<ProductDetail>();
		
		String query = "SELECT * FROM ProductDetails WHERE ProductId = " + id;
		Statement stm;
		try {
			stm = utilDb.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				ProductDetail item = new ProductDetail();
				item.setId(rs.getInt("id"));
				item.setInventory(rs.getInt(("Inventory")));
				item.setPrice(rs.getInt(("Price")));
				
				//Lấy khóa ngoại
				ProductDao productDao = new ProductDao();
				item.setProduct(productDao.getByProductID(rs.getInt("ProductId")));
				item.setSize(null);
				
				
				
				list.add(item);
			}
			
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		
		return list;
	}
}
