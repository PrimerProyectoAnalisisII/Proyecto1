package com.umgprojects.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.restaurant.entity.DetalleFactura;
import com.umgprojects.restaurant.repository.DetalleFacturaRepository;

@RestController
public class DetalleFacturaController {

	private final DetalleFacturaRepository repository;
	
	public DetalleFacturaController(DetalleFacturaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/detalle-factura")
	List<DetalleFactura> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("/detalle-factura")
	DetalleFactura crearDetalleFactura(@RequestBody DetalleFactura detalleFactura) {
		return repository.save(detalleFactura);
	}
	
	@GetMapping("/detalle-factura/{id}")
	DetalleFactura unoDetalleFactura(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/detalle-factura/{id}")
	DetalleFactura editarDetalleFactura(@RequestBody DetalleFactura nuevoDetFactura, @PathVariable Integer id) {
		DetalleFactura detFactura = repository.getOne(id);
		if(detFactura != null) {
			detFactura.setFactura(nuevoDetFactura.getFactura());
			detFactura.setOrden(nuevoDetFactura.getOrden());
			detFactura.setCreateby(nuevoDetFactura.getCreateby());
			detFactura.setCreatedate(nuevoDetFactura.getCreatedate());
			return repository.save(detFactura);
		} else {
			nuevoDetFactura.setIddetallefactura(id);
			return repository.save(nuevoDetFactura);
		}
	}
	
}