package com.umgprojects.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umgprojects.restaurant.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
