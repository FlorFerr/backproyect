package com.flor.backproyect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fav")
public class Fav {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_fav")
	private int id;
	
	@Column(name="id_product_fav")
	private int id_product_fav;
	
	@Column(name="name")
	private String name;
	
	@Column(name="category")
	private String category;
	
	
	public Fav() {}

	

	public Fav(int id_product_fav, String name, String category) {
		this.id_product_fav = id_product_fav;
		this.name = name;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public int getId_product_fav() {
		return id_product_fav;
	}



	public void setId_product_fav(int id_product_fav) {
		this.id_product_fav = id_product_fav;
	}



	@Override
	public String toString() {
		return "Fav [id=" + id + ", id_product_fav=" + id_product_fav + ", name=" + name + ", category=" + category
				+ "]";
	}
	
	



	
}
