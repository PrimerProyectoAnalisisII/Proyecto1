package com.umgprojects.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.restaurant.repository.MenuDetalleRepository;
import com.umgprojects.restaurant.entity.MenuDetalle;

@RestController
public class MenuDetalleController {

	private final MenuDetalleRepository repository;
	
	public MenuDetalleController(MenuDetalleRepository repository) {
		this.repository = repository;
	}
	
	
	@GetMapping("/menu-detalles")
	List<MenuDetalle> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("/menu-detalles")
	MenuDetalle crearMenuDetalle(@RequestBody MenuDetalle nuevoMenuDetalle) {
		return repository.save(nuevoMenuDetalle);
	}
	
	@GetMapping("/menu-detalles/{id}")
	MenuDetalle uno(@PathVariable Integer id) {
		return repository.getOne(id);
	}

	@PutMapping("/menu-detalle/{id}")
	MenuDetalle editarMenuDetalle(@RequestBody MenuDetalle nuevoMenuDetalle, @PathVariable Integer id) {
		MenuDetalle menuDetalle = repository.getOne(id);
		if(menuDetalle != null) {
			menuDetalle.setMenu(nuevoMenuDetalle.getMenu());
			menuDetalle.setProducto(nuevoMenuDetalle.getProducto());
			menuDetalle.setCreateby(nuevoMenuDetalle.getCreateby());
			menuDetalle.setCreatedate(nuevoMenuDetalle.getCreatedate());
			return repository.save(menuDetalle);
		} else {
			nuevoMenuDetalle.setIdmenudetalle(id);
			return repository.save(nuevoMenuDetalle);
		}
	}
}

