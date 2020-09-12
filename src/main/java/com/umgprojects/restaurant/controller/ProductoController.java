package com.umgprojects.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.restaurant.repository.ProductoRepository;
import com.umgprojects.restaurant.entity.*;

@RestController
public class ProductoController {

	private final ProductoRepository repository;
	
	public ProductoController(ProductoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/productos")
	List<Producto> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("/productos")
	Producto nuevoProducto(@RequestBody Producto nuevoProducto) {
		return repository.save(nuevoProducto);
	}
	
	@GetMapping("/productos/{id}")
	Producto uno(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/productos/{id}")
	Producto editarProducto(@RequestBody Producto nuevoProducto, @PathVariable Integer id) {
		Producto producto = repository.getOne(id);
		if(producto != null) {
			producto.setDescripcion(nuevoProducto.getDescripcion());
			producto.setPrecioUni(nuevoProducto.getPrecioUni());
			producto.setPrecioAd(nuevoProducto.getPrecioAd());
			producto.setCreateby(nuevoProducto.getCreateby());
			producto.setCreatedate(nuevoProducto.getCreatedate());
			return repository.save(producto);
		} else {
			nuevoProducto.setIdproducto(id);
			return repository.save(nuevoProducto);
		}
	}
	
	
}
