package com.co.stefanini.prueba.gamestore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.co.stefanini.prueba.gamestore.dao.ICustomerDao;
import com.co.stefanini.prueba.gamestore.db.ConnectionDB;
import com.co.stefanini.prueba.gamestore.model.Customer;

/**
 * @author Pilar Mass DAO de la entidad Customer
 *
 */

public class CustomerDao implements ICustomerDao {

	private Connection conn;
	private PreparedStatement preparedStatement;
	private ResultSet rs;

	public CustomerDao() {

		conn = null;
		preparedStatement = null;
		rs = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.co.stefanini.prueba.gamestore.dao.ICustomerDao#getAll()
	 */
	@Override
	public List<Customer> getAll() throws SQLException {
		final String getAllStatement = "SELECT * FROM customer";
		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(getAllStatement);
			rs = preparedStatement.executeQuery();

			List<Customer> customers = new ArrayList<>();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerAddress(rs.getString("customer_address"));
				customer.setCustomerCode(rs.getString("customer_code"));
				customer.setCustomerOtherDetail(rs
						.getString("customer_other_details"));
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setCustomerName(rs.getString("customer_name"));

				customers.add(customer);
			}

			return customers;
		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.co.stefanini.prueba.gamestore.dao.ICustomerDao#getById(java.lang.
	 * Integer)
	 */
	@Override
	public Customer getById(Integer id) throws SQLException {
		final String getStatement = "SELECT * FROM customer WHERE customer_id= ?";
		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(getStatement);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();

			Customer customer = new Customer();
			if (rs.next()) {
				customer = new Customer();
				customer.setCustomerAddress(rs.getString("customer_address"));
				customer.setCustomerCode(rs.getString("customer_code"));
				customer.setCustomerOtherDetail(rs
						.getString("customer_other_details"));
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setCustomerName(rs.getString("customer_name"));
			}
			return customer;

		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.co.stefanini.prueba.gamestore.dao.ICustomerDao#insert(com.co.stefanini
	 * .prueba.gamestore.model.Customer)
	 */
	@Override
	public void insert(Customer customer) throws SQLException {
		final String insert = "INSERT INTO customer(customer_id, customer_code, customer_name, customer_address, customer_other_details) VALUES (?, ?, ?, ?, ?)";
		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerCode());
			preparedStatement.setString(3, customer.getCustomerName());
			preparedStatement.setString(4, customer.getCustomerAddress());
			preparedStatement.setString(5, customer.getCustomerOtherDetail());

			preparedStatement.execute();

		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.co.stefanini.prueba.gamestore.dao.ICustomerDao#update(com.co.stefanini
	 * .prueba.gamestore.model.Customer)
	 */
	@Override
	public void update(Customer customer) throws SQLException {

		final String update = "UPDATE customer SET customer_code=?, customer_name=?, customer_address=?, customer_other_details=? WHERE customer_id=?";

		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(update);

			preparedStatement.setString(1, customer.getCustomerCode());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getCustomerAddress());
			preparedStatement.setString(4, customer.getCustomerOtherDetail());
			preparedStatement.setInt(5, customer.getCustomerId());

			preparedStatement.execute();

		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.co.stefanini.prueba.gamestore.dao.ICustomerDao#delete(java.lang.Integer
	 * )
	 */
	@Override
	public void delete(Integer id) throws SQLException {

		final String delete = "DELETE FROM customer WHERE customer_id=? ";

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
