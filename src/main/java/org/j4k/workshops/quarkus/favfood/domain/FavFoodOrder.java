package org.j4k.workshops.quarkus.favfood.domain;

import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class FavFoodOrder {

    String orderId;

    String customerName;

    List<FavFoodLineItem> lineItems;

    public FavFoodOrder(){

    }
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((lineItems == null) ? 0 : lineItems.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final FavFoodOrder other = (FavFoodOrder) obj;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (lineItems == null) {
			if (other.lineItems != null)
				return false;
		} else if (!lineItems.equals(other.lineItems))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "FavFoodOrder [customerName=" + customerName + ", lineItems=" + lineItems + ", orderId=" + orderId + "]";
	}



	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}



	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(final String orderId) {
		this.orderId = orderId;
	}



	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}



	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(final String customerName) {
		this.customerName = customerName;
	}



	/**
	 * @return the lineItems
	 */
	public List<FavFoodLineItem> getLineItems() {
		return lineItems;
	}



	/**
	 * @param lineItems the lineItems to set
	 */
	public void setLineItems(final List<FavFoodLineItem> lineItems) {
		this.lineItems = lineItems;
	}
}
