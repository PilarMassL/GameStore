package com.co.stefanini.prueba.gamestore.model;

import java.util.Date;

public class CustomerPurchase {

	/**
	 * Entidad de la tabla customer_purchases
	 * 
	 * @author Pilar Mass
	 * */
	Integer purchaseId;
	Date dateOfPurchase;
	String otherPruchaseDetail;
	Customer customerId;

	public CustomerPurchase() {
		super();
	}

	public CustomerPurchase(Integer purchaseId, Date dateOfPurchase,
			String otherPruchaseDetail, Customer customerId) {
		super();
		this.purchaseId = purchaseId;
		this.dateOfPurchase = dateOfPurchase;
		this.otherPruchaseDetail = otherPruchaseDetail;
		this.customerId = customerId;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getOtherPruchaseDetail() {
		return otherPruchaseDetail;
	}

	public void setOtherPruchaseDetail(String otherPruchaseDetail) {
		this.otherPruchaseDetail = otherPruchaseDetail;
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
				+ ((dateOfPurchase == null) ? 0 : dateOfPurchase.hashCode());
		result = prime
				* result
				+ ((otherPruchaseDetail == null) ? 0 : otherPruchaseDetail
						.hashCode());
		result = prime * result
				+ ((purchaseId == null) ? 0 : purchaseId.hashCode());
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
		CustomerPurchase other = (CustomerPurchase) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (dateOfPurchase == null) {
			if (other.dateOfPurchase != null)
				return false;
		} else if (!dateOfPurchase.equals(other.dateOfPurchase))
			return false;
		if (otherPruchaseDetail == null) {
			if (other.otherPruchaseDetail != null)
				return false;
		} else if (!otherPruchaseDetail.equals(other.otherPruchaseDetail))
			return false;
		if (purchaseId == null) {
			if (other.purchaseId != null)
				return false;
		} else if (!purchaseId.equals(other.purchaseId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerPurchase [purchaseId=" + purchaseId
				+ ", dateOfPurchase=" + dateOfPurchase
				+ ", otherPruchaseDetail=" + otherPruchaseDetail
				+ ", customerId=" + customerId + "]";
	}

}
