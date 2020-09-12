package com.umgprojects.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.restaurant.entity.Orden;
import com.umgprojects.restaurant.repository.OrdenRepository;

@RestController
public class OrdenController {
	
	private final OrdenRepository repository;
	
	public OrdenController(OrdenRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/ordenes")
	List<Orden> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("/ordenes")
	Orden crearOrden(@RequestBody Orden orden) {
		return repository.save(orden);
	}
	
	@GetMapping("/ordenes/{id}")
	Orden unaOrden(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/ordenes/{id}")
	Orden editarOrden(@RequestBody Orden nuevaOrden, @PathVariable Integer id) {
		Orden orden = repository.getOne(id);
		if(orden != null) {
			orden.setIdordennum(nuevaOrden.getIdordennum());
			orden.setMenu(nuevaOrden.getMenu());
			orden.setCreateby(nuevaOrden.getCreateby());
			orden.setCreatedate(nuevaOrden.getCreatedate());
			return repository.save(orden);
		} else {
			nuevaOrden.setIdorden(id);
			return repository.save(nuevaOrden);
		}
	}
	
}
