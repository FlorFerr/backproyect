package com.flor.backproyect.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.backproyect.entity.Orden;

public interface OrderRepository extends JpaRepository<Orden, Integer> {

	void deleteByUserId(int userId);
	
}
