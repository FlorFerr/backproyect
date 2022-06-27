package com.flor.backproyect.entity;

import java.util.Date;

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
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="category")
	private String category;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="fecha")
	private Date fecha;
	
	public Orden () {}

	public Orden(int idOrder, int quantity, String category, int userId, Date fecha) {
		this.idOrder = idOrder;
		this.quantity = quantity;
		this.category = category;
		this.userId = userId;
		this.fecha = fecha;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Orden [id=" + id + ", idOrder=" + idOrder + ", quantity=" + quantity + ", category=" + category
				+ ", userId=" + userId + ", fecha=" + fecha + "]";
	}

}

	
	