package com.umgprojects.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umgprojects.restaurant.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
