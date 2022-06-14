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
	@Column(name="idProductOrder")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="category")
	private String category;
	
	
	public Orden () {}


	public Orden(int id, String name, int amount, String category) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.category = category;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
		return "Orden [id=" + id + ", name=" + name + ", amount=" + amount + ", category=" + category + "]";
	}

	
}
