package com.co.stefanini.prueba.gamestore.model;

import java.util.Date;

public class CustomerOrder {
	/**
	 * Entidad de la tabla customer_orders
	 * 
	 * @author Pilar Mass
	 * */
	Integer orderId;
	Date dateOfOrder;
	String otherOrderDetail;
	Customer customerId;

	public CustomerOrder() {
		super();
	}

	public CustomerOrder(Integer orderId, Date dateOfOrder,
			String otherOrderDetail, Customer customerId) {
		super();
		this.orderId = orderId;
		this.dateOfOrder = dateOfOrder;
		this.otherOrderDetail = otherOrderDetail;
		this.customerId = customerId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getOtherOrderDetail() {
		return otherOrderDetail;
	}

	public void setOtherOrderDetail(String otherOrderDetail) {
		this.otherOrderDetail = otherOrderDetail;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((dateOfOrder == null) ? 0 : dateOfOrder.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime
				* result
				+ ((otherOrderDetail == null) ? 0 : otherOrderDetail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerOrder other = (CustomerOrder) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (dateOfOrder == null) {
			if (other.dateOfOrder != null)
				return false;
		} else if (!dateOfOrder.equals(other.dateOfOrder))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (otherOrderDetail == null) {
			if (other.otherOrderDetail != null)
				return false;
		} else if (!otherOrderDetail.equals(other.otherOrderDetail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerOrder [orderId=" + orderId + ", dateOfOrder="
				+ dateOfOrder + ", otherOrderDetail=" + otherOrderDetail
				+ ", customerId=" + customerId + "]";
	}

}
