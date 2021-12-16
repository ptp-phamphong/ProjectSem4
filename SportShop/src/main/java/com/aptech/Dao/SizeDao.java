package com.aptech.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.aptech.Model.*;

public class SizeDao {
	private UtilDb utilDb;

	public SizeDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}

	public ArrayList<Size> getAll() {
		ArrayList<Size> list = new ArrayList<Size>();
		String sql = "Select * from Size";
		Statement stm;
		try {
			stm = utilDb.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Size item = new Size();
				item.setId(rs.getInt("Id"));
				item.setName(rs.getString("Name"));
				list.add(item);
			}
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		return list;
	}
	
	public ArrayList<Size> getById(int id) {
		ArrayList<Size> list = new ArrayList<Size>();
		String sql = "Select * from Size where Id="+id;
		Statement stm;
		try {
			stm = utilDb.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Size item = new Size();
				item.setId(rs.getInt("Id"));
				item.setName(rs.getString("Name"));
				list.add(item);
			}
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		return list;
	}
}
