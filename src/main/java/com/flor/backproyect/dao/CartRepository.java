package com.flor.backproyect.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.backproyect.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
