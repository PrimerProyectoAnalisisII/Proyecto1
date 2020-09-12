package com.umgprojects.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.restaurant.entity.Cliente;
import com.umgprojects.restaurant.repository.ClienteRepository;

@RestController
public class ClienteController {

	private final ClienteRepository repository; 
	
	public ClienteController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/clientes")
	List<Cliente> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("/clientes")
	Cliente crearCliente(@RequestBody Cliente nuevoCliente) {
		return repository.save(nuevoCliente);
	}
	
	@GetMapping("/clientes/{id}")
	Cliente unoCliente(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/clientes/{id}")
	Cliente editarCliente(@RequestBody Cliente nuevoCliente, @PathVariable Integer id) {
		Cliente cliente = repository.getOne(id);
		if(cliente != null) {
			cliente.setNombre(nuevoCliente.getNombre());
			cliente.setApellido(nuevoCliente.getApellido());
			cliente.setNit(nuevoCliente.getNit());
			cliente.setDpi(nuevoCliente.getDpi());
			cliente.setCreateby(nuevoCliente.getCreateby());
			cliente.setCreatedate(nuevoCliente.getCreatedate());
			return repository.save(cliente);
		} else {
			nuevoCliente.setIdcliente(id);
			return repository.save(nuevoCliente);
		}
	}
	
}
