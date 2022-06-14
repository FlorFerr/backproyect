package com.flor.backproyect.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pass")
	private String pass;


	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private List<Fav> favs;
	
	

	public User () {}

	
	public User(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public List<Fav> getFavs() {
		return favs;
	}


	public void setFavs(List<Fav> favs) {
		this.favs = favs;
	}
	
	public void addFavs(Fav theFav) {
		if(favs == null) {
			favs = new ArrayList<>();
		}
		favs.add(theFav);
	}

	
}
