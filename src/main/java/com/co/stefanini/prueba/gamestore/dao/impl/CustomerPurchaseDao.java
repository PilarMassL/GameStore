package com.co.stefanini.prueba.gamestore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.co.stefanini.prueba.gamestore.dao.ICustomerDao;
import com.co.stefanini.prueba.gamestore.dao.ICustomerPurchaseDao;
import com.co.stefanini.prueba.gamestore.db.ConnectionDB;
import com.co.stefanini.prueba.gamestore.model.CustomerPurchase;

/**
 * @author Pilar Mass
 * 
 *
 */
public class CustomerPurchaseDao implements ICustomerPurchaseDao {

	private Connection conn;
	private PreparedStatement preparedStatement;
	private ResultSet rs;
	private ICustomerDao iCustomerDao;

	public CustomerPurchaseDao() {

		iCustomerDao = new CustomerDao();
		conn = null;
		preparedStatement = null;
		rs = null;
	}

	@Override
	public List<CustomerPurchase> getAll() throws SQLException {
		final String getAll = "SELECT * FROM customer_purchases";
		try {
			conn = ConnectionDB.getConnection();
			preparedStatement = conn.prepareStatement(getAll);
			rs = preparedStatement.executeQuery();

			List<CustomerPurchase> customerPurchases = new ArrayList<>();

			while (rs.next()) {
				CustomerPurchase customerPurchase = new CustomerPurchase();
				customerPurchase.setPurchaseId(rs.getInt("purchase_id"));
				customerPurchase.setCustomerId(iCustomerDao.getById(rs
						.getInt("customer_id")));
				customerPurchase.setDateOfPurchase(rs
						.getDate("date_of_purchase"));
				customerPurchase.setOtherPruchaseDetail(rs
						.getString("other_purchase_details"));

				customerPurchases.add(customerPurchase);
			}

			return customerPurchases;
		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

	@Override
	public CustomerPurchase getById(Integer id) throws SQLException {
		final String getStatement = "SELECT * FROM customer_purchases WHERE purchase_id= ?";
		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(getStatement);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();

			CustomerPurchase customerPurchase = new CustomerPurchase();
			if (rs.next()) {

				customerPurchase.setPurchaseId(rs.getInt("purchase_id"));
				customerPurchase.setCustomerId(iCustomerDao.getById(rs
						.getInt("customer_id")));
				customerPurchase.setDateOfPurchase(rs
						.getDate("date_of_purchase"));
				customerPurchase.setOtherPruchaseDetail(rs
						.getString("other_purchase_details"));

			}
			return customerPurchase;

		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

	@Override
	public void insert(CustomerPurchase customerPurchaser) throws SQLException {
		final String insert = "INSERT INTO customer_purchases ( purchase_id, date_of_purchase, other_purchase_details, customer_id) VALUES (?, ?, ?, ?)";
		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setInt(1, customerPurchaser.getPurchaseId());
			preparedStatement.setDate(2, new java.sql.Date(customerPurchaser
					.getDateOfPurchase().getTime()));
			preparedStatement.setString(3,
					customerPurchaser.getOtherPruchaseDetail());
			preparedStatement.setInt(4, customerPurchaser.getCustomerId()
					.getCustomerId());

			preparedStatement.execute();

		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

	@Override
	public void update(CustomerPurchase customerPurchase) throws SQLException {

		final String insert = "UPDATE customer_purchases SET date_of_order=?, other_order_details=?, customer_id=? WHERE  order_id=?";

		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(insert);

			preparedStatement.setDate(1, new java.sql.Date(customerPurchase
					.getDateOfPurchase().getTime()));
			preparedStatement.setString(2,
					customerPurchase.getOtherPruchaseDetail());
			preparedStatement.setInt(3, customerPurchase.getCustomerId()
					.getCustomerId());
			preparedStatement.setInt(4, customerPurchase.getPurchaseId());

			preparedStatement.execute();

		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

	@Override
	public void delete(Integer id) throws SQLException {

		final String delete = "DELETE FROM customer_purchases WHERE purchase_id=?";
		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(delete);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();

		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

}
