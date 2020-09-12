package com.umgprojects.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.restaurant.entity.Factura;
import com.umgprojects.restaurant.repository.FacturaRepository;

@RestController
public class FacturaController {

	private final FacturaRepository repository;
	
	public FacturaController(FacturaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/facturas")
	List<Factura> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("/facturas")
	Factura crearFactura(@RequestBody Factura factura) {
		return repository.save(factura);
	}
	
	@GetMapping("/facturas/{id}")
	Factura unaFactura(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/facturas/{id}")
	Factura editarFactura(@RequestBody Factura nuevaFactura, @PathVariable Integer id) {
		Factura factura = repository.getOne(id);
		
		if(factura != null) {
			factura.setCliente(nuevaFactura.getCliente());
			factura.setUsuario(nuevaFactura.getUsuario());
			factura.setFecha(nuevaFactura.getFecha());
			factura.setTotal(nuevaFactura.getTotal());
			factura.setCreateby(nuevaFactura.getCreateby());
			factura.setCreatedate(nuevaFactura.getCreatedate());
			repository.save(factura);
		} else {
			nuevaFactura.setIdfactura(id);
			repository.save(nuevaFactura);
		}
		return factura;	
	}
	
}
