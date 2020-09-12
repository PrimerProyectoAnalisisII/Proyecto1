package com.umgprojects.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umgprojects.restaurant.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
