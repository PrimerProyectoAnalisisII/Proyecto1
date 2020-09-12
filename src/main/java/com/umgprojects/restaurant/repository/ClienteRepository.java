package com.umgprojects.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umgprojects.restaurant.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
