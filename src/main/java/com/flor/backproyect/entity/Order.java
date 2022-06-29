package com.flor.backproyect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="category")
	private String category;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="n_order")
	private long numOrder;

	public Order() {}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getNumOrder() {
		return numOrder;
	}

	public void setNumOrder(long numOrder) {
		this.numOrder = numOrder;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", category=" + category
				+ ", userId=" + userId + ", numOrder=" + numOrder + "]";
	}
}

	
	