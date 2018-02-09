package com.co.stefanini.prueba.gamestore.main;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.co.stefanini.prueba.gamestore.dao.ICustomerDao;
import com.co.stefanini.prueba.gamestore.dao.ICustomerOrderDao;
import com.co.stefanini.prueba.gamestore.dao.ICustomerPurchaseDao;
import com.co.stefanini.prueba.gamestore.dao.impl.CustomerDao;
import com.co.stefanini.prueba.gamestore.dao.impl.CustomerOrderDao;
import com.co.stefanini.prueba.gamestore.dao.impl.CustomerPurchaseDao;
import com.co.stefanini.prueba.gamestore.model.Customer;
import com.co.stefanini.prueba.gamestore.model.CustomerOrder;
import com.co.stefanini.prueba.gamestore.model.CustomerPurchase;

public class Main {

	public static void main(String[] args) {

		try {

			ICustomerDao iCustomerDao = new CustomerDao();
			ICustomerOrderDao iCustomerOrderDao = new CustomerOrderDao();
			ICustomerPurchaseDao iCustomerPurchaseDao = new CustomerPurchaseDao();

			Customer customer = new Customer();
			customer.setCustomerId(1);
			customer.setCustomerCode("C1");
			customer.setCustomerName("Pilar ");
			customer.setCustomerAddress("Cra 34 este no 55 norte, bogota");
			customer.setCustomerOtherDetail("detalles");

			iCustomerDao.insert(customer);

			CustomerOrder order = new CustomerOrder();
			order.setOrderId(1);
			order.setDateOfOrder(new Date());
			order.setOtherOrderDetail("detalles de la orden");
			order.setCustomerId(customer);

			iCustomerOrderDao.insert(order);

			CustomerPurchase purchase = new CustomerPurchase();
			purchase.setCustomerId(customer);
			purchase.setDateOfPurchase(new Date());
			purchase.setOtherPruchaseDetail("detalles de purchase");
			purchase.setPurchaseId(1);

			iCustomerPurchaseDao.insert(purchase);

			// consultas
			List<Customer> customers = iCustomerDao.getAll();
			System.out.println(customers);

			List<CustomerOrder> orders = iCustomerOrderDao.getAll();
			System.out.println(orders);

			List<CustomerPurchase> purchases = iCustomerPurchaseDao.getAll();
			System.out.println(purchases);

			// eliminacion
			iCustomerPurchaseDao.delete(1);
			iCustomerOrderDao.delete(1);
			iCustomerDao.delete(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
