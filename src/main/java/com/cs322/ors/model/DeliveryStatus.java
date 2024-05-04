package com.cs322.ors.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DeliveryStatus {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne (optional = false)  //each order can have a unique delivery status
	private Order order;			// only order of type 1 should be up for delivery
	
	private boolean isDelivered;
	private boolean isRecieved;
	
	
	public DeliveryStatus() {
		
	}
	
	public DeliveryStatus(Order order) {
		super();
		this.order = order;
		this.isDelivered = false;
		this.isRecieved = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public boolean isRecieved() {
		return isRecieved;
	}

	public void setRecieved(boolean isRecieved) {
		this.isRecieved = isRecieved;
	}
	
	
	
	
}
