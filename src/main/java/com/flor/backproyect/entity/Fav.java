package com.flor.backproyect.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favorites")
public class Fav {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_fav")
	private int idFav;
	
	@Column(name="category")
	private String category;
			
	@Column(name="user_id")
	private int userId;
	
	public Fav() {}

	public Fav(int idFav, String category, int userId) {
		super();
		this.idFav = idFav;
		this.category = category;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFav() {
		return idFav;
	}

	public void setIdFav(int idFav) {
		this.idFav = idFav;
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
		return "Fav [id=" + id + ", idFav=" + idFav + ", category=" + category + ", userId=" + userId + "]";
	}	
}
