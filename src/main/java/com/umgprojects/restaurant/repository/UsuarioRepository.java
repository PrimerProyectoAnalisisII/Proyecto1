package com.umgprojects.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umgprojects.restaurant.entity.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
}