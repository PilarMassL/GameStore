package com.co.stefanini.prueba.gamestore.dao;

import java.sql.SQLException;
import java.util.List;

import com.co.stefanini.prueba.gamestore.model.Customer;

/**
 * @author Pilar Mass Interface de CustomerDao
 *
 */
public interface ICustomerDao {

	/**
	 * Obtener una lista de Customer
	 * 
	 * @return
	 */
	public List<Customer> getAll() throws SQLException;

	/**
	 * Obtener un Customer por ID
	 * 
	 * @param id
	 * @return
	 */
	public Customer getById(Integer id) throws SQLException;

	/**
	 * Insertar Customer
	 * 
	 * @param customer
	 */
	public void insert(Customer customer) throws SQLException;

	/**
	 * Actualizar Customer
	 * 
	 * @param customer
	 */
	public void update(Customer customer) throws SQLException;

	/**
	 * Eliminar customer
	 * 
	 * @param id
	 */
	public void delete(Integer id) throws SQLException;

}
