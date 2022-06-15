package com.flor.backproyect.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.backproyect.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
