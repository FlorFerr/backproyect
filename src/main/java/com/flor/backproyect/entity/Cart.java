package com.flor.backproyect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_cart")
	private int idCart;
	
	@Column(name="category")
	private String category;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="user_id")
	private int userId;
	
	public Cart() {}

	public Cart(int idCart, String category, int quantity, int userId) {
		super();
		this.idCart = idCart;
		this.category = category;
		this.quantity = quantity;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", idCart=" + idCart + ", category=" + category + ", quantity=" + quantity
				+ ", userId=" + userId + "]";
	}
}
