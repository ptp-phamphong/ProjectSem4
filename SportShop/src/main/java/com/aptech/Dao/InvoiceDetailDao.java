package com.aptech.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;

import com.aptech.Model.Invoice;
import com.aptech.Model.InvoiceDetail;

public class InvoiceDetailDao {

	private UtilDb utilDb;

	public InvoiceDetailDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}

	public boolean addNew(InvoiceDetail invoiceDetail) {
		String query = "insert into InvoiceDetails (InvoiceId, ProductDetailsId, Quantity, Unit) values (?,?,?,?)";

		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(query);
			pre.setInt(1, invoiceDetail.getInvoice().getId());
			pre.setInt(2, invoiceDetail.getProductDetail().getId());
			pre.setInt(3,invoiceDetail.getQuantity());
			pre.setInt(4, invoiceDetail.getUnit());
			
			int rs = pre.executeUpdate();
			if (rs != 0)
				return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return false;
	}
}
