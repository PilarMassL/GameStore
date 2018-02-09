package com.co.stefanini.prueba.gamestore.dao;

import java.sql.SQLException;
import java.util.List;

import com.co.stefanini.prueba.gamestore.model.CustomerPurchase;

/**
 * @author Pilar Mass Interface de CustomerPurchaseDao
 *
 */
public interface ICustomerPurchaseDao {

	/**
	 * Obtener una lista de Customer Purchase
	 * 
	 * @return
	 */
	public List<CustomerPurchase> getAll() throws SQLException;

	/**
	 * Obtener un Customer Purchase por ID
	 * 
	 * @param id
	 * @return
	 */
	public CustomerPurchase getById(Integer id) throws SQLException;

	/**
	 * Insertar CustomerPurchase
	 * 
	 * @param customerPurchase
	 */
	public void insert(CustomerPurchase customerPurchaser) throws SQLException;

	/**
	 * Actualizar CustomerPurchase
	 * 
	 * @param customerPurchase
	 */
	public void update(CustomerPurchase customerPurchase) throws SQLException;

	/**
	 * Eliminar CustomerPurchase
	 * 
	 * @param id
	 */
	public void delete(Integer id) throws SQLException;

}
