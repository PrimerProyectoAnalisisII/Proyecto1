package com.umgprojects.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umgprojects.restaurant.entity.DetalleFactura;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {

}
