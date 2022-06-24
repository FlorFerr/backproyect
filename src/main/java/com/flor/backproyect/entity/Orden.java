package com.flor.backproyect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orden")
public class Orden {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_order")
	private int idOrder;
	
	@Column(name="name")
	private String name;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="category")
	private String category;
	
	@Column(name="user_id")
	private int userId;
	
	
	public Orden () {}


	


	public Orden(int idOrder, String name, int amount, String category, int userId) {
		this.idOrder = idOrder;
		this.name = name;
		this.amount = amount;
		this.category = category;
		this.userId = userId;
	}





	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdOrder() {
		return idOrder;
	}


	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Orden [id=" + id + ", idOrder=" + idOrder + ", name=" + name + ", amount=" + amount + ", category="
				+ category + ", userId=" + userId + "]";
	}


	
	
	
	
}

	
	