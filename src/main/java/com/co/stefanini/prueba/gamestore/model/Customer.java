package com.co.stefanini.prueba.gamestore.model;

public class Customer {

	/**
	 * Entidad de la tabla customer
	 * 
	 * @author Pilar Mass
	 * */

	Integer customerId;
	String customerCode;
	String customerName;
	String customerAddress;
	String customerOtherDetail;

	public Customer() {
		super();

	}

	public Customer(Integer customerId, String customerCode,
			String customerName, String customerAddress,
			String customerOtherDetail) {
		super();
		this.customerId = customerId;
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerOtherDetail = customerOtherDetail;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerOtherDetail() {
		return customerOtherDetail;
	}

	public void setCustomerOtherDetail(String customerOtherDetail) {
		this.customerOtherDetail = customerOtherDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result
				+ ((customerCode == null) ? 0 : customerCode.hashCode());
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime
				* result
				+ ((customerOtherDetail == null) ? 0 : customerOtherDetail
						.hashCode());
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
		Customer other = (Customer) obj;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerCode == null) {
			if (other.customerCode != null)
				return false;
		} else if (!customerCode.equals(other.customerCode))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerOtherDetail == null) {
			if (other.customerOtherDetail != null)
				return false;
		} else if (!customerOtherDetail.equals(other.customerOtherDetail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerCode="
				+ customerCode + ", customerName=" + customerName
				+ ", customerAddress=" + customerAddress
				+ ", customerOtherDetail=" + customerOtherDetail + "]";
	}

}
