package com.flor.backproyect.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.backproyect.entity.Cart;
import com.flor.backproyect.entity.Orden;

public interface OrderRepository extends JpaRepository<Orden, Integer> {

	

	

}
