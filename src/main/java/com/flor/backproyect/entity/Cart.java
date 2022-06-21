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
	
	@Column(name="name")
	private String name;
	
	@Column(name="category")
	private String category;
	
	@Column(name="amount")
	private int amount;
	
	public Cart() {}

	public Cart(int idCart, String name, String category, int amount) {
		this.idCart = idCart;
		this.name = name;
		this.category = category;
		this.amount = amount;
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

	public void setId_cart(int idCart) {
		this.idCart = idCart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", idCart=" + idCart + ", name=" + name + ", category=" + category + ", amount="
				+ amount + "]";
	}

	

}
