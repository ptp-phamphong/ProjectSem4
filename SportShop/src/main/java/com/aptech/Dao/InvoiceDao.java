package com.aptech.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.aptech.Model.Customer;
import com.aptech.Model.Invoice;
import com.aptech.Model.ProductType;

public class InvoiceDao {
	private UtilDb utilDb;

	public InvoiceDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}

	public boolean addNew(Invoice invoice) {
		String query = "insert into Invoice (CustomerId, StaffId, CreateDate, TotalPrice) values (?,?,?,?)";

		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(query);
			pre.setInt(1, invoice.getCustomer().getId());
			pre.setString(2, null);
			pre.setDate(3, (Date) invoice.getCreateDate());
			pre.setInt(4, invoice.getTotalPrice());

			int rs = pre.executeUpdate();
			if (rs != 0)
				return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return false;
	}

	public Invoice getLast() {
		String query = "SELECT TOP 1 * FROM Invoice ORDER BY id DESC ";
		Statement stm;
		try {
			stm = utilDb.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				Invoice item = new Invoice();
				item.setId(rs.getInt("id"));
				item.setCreateDate(rs.getDate("CreateDate"));
				item.setTotalPrice(rs.getInt("TotalPrice"));
				
				
				item.setStaff(null);
				CustomerDao customerDao = new CustomerDao();
				item.setCustomer(customerDao.getAccount(rs.getInt("CustomerId")));
				return item;
			}

		} catch (Exception ex) {
		}

		return null;
	}

}
