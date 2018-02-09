package com.co.stefanini.prueba.gamestore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.co.stefanini.prueba.gamestore.dao.ICustomerDao;
import com.co.stefanini.prueba.gamestore.dao.ICustomerOrderDao;
import com.co.stefanini.prueba.gamestore.db.ConnectionDB;
import com.co.stefanini.prueba.gamestore.model.CustomerOrder;

/**
 * @author Pilar Mass
 *
 */
public class CustomerOrderDao implements ICustomerOrderDao {

	private Connection conn;
	private PreparedStatement preparedStatement;
	private ResultSet rs;
	private ICustomerDao iCustomerDao;

	public CustomerOrderDao() {

		iCustomerDao = new CustomerDao();
		conn = null;
		preparedStatement = null;
		rs = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.co.stefanini.prueba.gamestore.dao.ICustomerOrderDao#getAll()
	 */
	@Override
	public List<CustomerOrder> getAll() throws SQLException {
		final String getAll = "SELECT * FROM customer_orders";
		try {
			conn = ConnectionDB.getConnection();
			preparedStatement = conn.prepareStatement(getAll);
			rs = preparedStatement.executeQuery();

			List<CustomerOrder> customerOrders = new ArrayList<>();

			while (rs.next()) {
				CustomerOrder customerOrder = new CustomerOrder();
				customerOrder.setOrderId(rs.getInt("order_id"));
				customerOrder.setCustomerId(iCustomerDao.getById(rs
						.getInt("customer_id")));
				customerOrder.setDateOfOrder(rs.getDate("date_of_order"));
				customerOrder.setOtherOrderDetail(rs
						.getString("other_order_details"));

				customerOrders.add(customerOrder);
			}

			return customerOrders;
		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.co.stefanini.prueba.gamestore.dao.ICustomerOrderDao#getById(java.
	 * lang.Integer)
	 */
	@Override
	public CustomerOrder getById(Integer id) throws SQLException {
		final String getStatement = "SELECT * FROM customer_orders WHERE order_id= ?";
		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(getStatement);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();

			CustomerOrder customerOrder = new CustomerOrder();
			if (rs.next()) {

				customerOrder.setOrderId(rs.getInt("order_id"));
				customerOrder.setCustomerId(iCustomerDao.getById(rs
						.getInt("customer_id")));
				customerOrder.setDateOfOrder(rs.getDate("date_of_order"));
				customerOrder.setOtherOrderDetail(rs
						.getString("other_order_details"));

			}
			return customerOrder;

		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.co.stefanini.prueba.gamestore.dao.ICustomerOrderDao#insert(com.co
	 * .stefanini.prueba.gamestore.model.CustomerOrder)
	 */
	@Override
	public void insert(CustomerOrder customerOrder) throws SQLException {

		final String insert = "INSERT INTO customer_orders ( order_id, date_of_order, other_order_details, customer_id) VALUES (?, ?, ?, ?)";
		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setInt(1, customerOrder.getOrderId());
			preparedStatement.setDate(2, new java.sql.Date(customerOrder
					.getDateOfOrder().getTime()));
			preparedStatement.setString(3, customerOrder.getOtherOrderDetail());
			preparedStatement.setInt(4, customerOrder.getCustomerId()
					.getCustomerId());

			preparedStatement.execute();

		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.co.stefanini.prueba.gamestore.dao.ICustomerOrderDao#update(com.co
	 * .stefanini.prueba.gamestore.model.CustomerOrder)
	 */
	@Override
	public void update(CustomerOrder customerOrder) throws SQLException {

		final String insert = "UPDATE customer_orders SET date_of_order=?, other_order_details=?, customer_id=? WHERE  order_id=?";
		try {
			conn = ConnectionDB.getConnection();

			preparedStatement = conn.prepareStatement(insert);

			preparedStatement.setDate(1, new java.sql.Date(customerOrder
					.getDateOfOrder().getTime()));
			preparedStatement.setString(2, customerOrder.getOtherOrderDetail());
			preparedStatement.setInt(3, customerOrder.getCustomerId()
					.getCustomerId());
			preparedStatement.setInt(4, customerOrder.getOrderId());

			preparedStatement.execute();

		} finally {
			ConnectionDB.closeConnection(conn, preparedStatement, rs);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.co.stefanini.prueba.gamestore.dao.ICustomerOrderDao#delete(java.lang
	 * .Integer)
	 */
	@Override
	public void delete(Integer id) throws SQLException {
		final String delete = "DELETE FROM customer_orders WHERE order_id=?";
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
