package com.umgprojects.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umgprojects.restaurant.entity.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {

}
