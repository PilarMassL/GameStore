package com.co.stefanini.prueba.gamestore.dao;

import java.sql.SQLException;
import java.util.List;

import com.co.stefanini.prueba.gamestore.model.CustomerOrder;

/**
 * @author Pilar Mass Interface de CustomerOrderDao
 *
 */
public interface ICustomerOrderDao {

	/**
	 * Obtener una lista de Customer Order
	 * 
	 * @return
	 */
	public List<CustomerOrder> getAll() throws SQLException;

	/**
	 * Obtener un Customer Order por ID
	 * 
	 * @param id
	 * @return
	 */
	public CustomerOrder getById(Integer id) throws SQLException;

	/**
	 * Insertar Customer Order
	 * 
	 * @param customerOrder
	 */
	public void insert(CustomerOrder customerOrder) throws SQLException;

	/**
	 * Actualizar Customer Order
	 * 
	 * @param customerOrder
	 */
	public void update(CustomerOrder customerOrder) throws SQLException;

	/**
	 * Eliminar customer
	 * 
	 * @param id
	 */
	public void delete(Integer id) throws SQLException;

}
