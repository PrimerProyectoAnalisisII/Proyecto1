package com.umgprojects.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.restaurant.repository.OrdenDetalleRepository;
import com.umgprojects.restaurant.entity.OrdenDetalle;

@RestController
public class OrdenDetalleController {

	private final OrdenDetalleRepository repository;
	
	public OrdenDetalleController(OrdenDetalleRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/orden-detalles")
	List<OrdenDetalle> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("/orden-detalles")
	OrdenDetalle crearOrdenDet(@RequestBody OrdenDetalle nuevaOrdenDetalle) {
		return repository.save(nuevaOrdenDetalle);
	}
	
	@GetMapping("/orden-detalles/{id}")
	OrdenDetalle unaOrdenDetalle(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/orden-detalles/{id}")
	OrdenDetalle editarOrdenDetalle(@RequestBody OrdenDetalle nuevaOrdenDet,@PathVariable Integer id) {
		OrdenDetalle ordenDetalle = repository.getOne(id);
		if(ordenDetalle != null) {
			ordenDetalle.setOrden(nuevaOrdenDet.getOrden());
			ordenDetalle.setProducto(nuevaOrdenDet.getProducto());
			ordenDetalle.setCreateby(nuevaOrdenDet.getCreateby());
			ordenDetalle.setCreatedate(nuevaOrdenDet.getCreatedate());
			return repository.save(ordenDetalle);
		} else {
			nuevaOrdenDet.setIdordendetalle(id);
			return repository.save(nuevaOrdenDet);
		}
		
	} 
	
}
