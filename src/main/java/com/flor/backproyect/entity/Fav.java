package com.flor.backproyect.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fav")
public class Fav {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_fav")
	private int id;
	
	@Column(name="id_product_fav")
	private int idProductFav;
	
	@Column(name="name")
	private String name;
	
	@Column(name="category")
	private String category;
			
	@Column(name="user_id")
	private int userId;
	
	public Fav() {}

	public Fav(int idProductFav, String name, String category, int userId) {
		this.idProductFav = idProductFav;
		this.name = name;
		this.category = category;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProductFav() {
		return idProductFav;
	}

	public void setIdProductFav(int idProductFav) {
		this.idProductFav = idProductFav;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Fav [id=" + id + ", idProductFav=" + idProductFav + ", name=" + name + ", category=" + category
				+ ", userId=" + userId + "]";
	}	

	

	

	


	





	
}
