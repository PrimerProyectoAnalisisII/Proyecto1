package com.umgprojects.restaurant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.restaurant.repository.UsuarioRepository;
import com.umgprojects.restaurant.entity.*;

import java.util.List;

@RestController
public class UsuarioController {

	private final UsuarioRepository repository;
	
	public UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/usuarios")
	List<Usuario> all() {
		return repository.findAll();
	}
	
	@PostMapping("/usuarios")
	Usuario nuevoUsuario(@RequestBody Usuario nuevoUsuario) {
		return repository.save(nuevoUsuario);
	}
	
	@GetMapping("/usuarios/{id}")
	Usuario uno(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/usuarios/{id}")
	Usuario editarUsuario(@RequestBody Usuario nuevoUsuario, @PathVariable Integer id) {
		Usuario usuario = repository.getOne(id);
		if(usuario != null) {
			usuario.setNombre(nuevoUsuario.getNombre());
			usuario.setApellido(nuevoUsuario.getApellido());
			usuario.setDpi(nuevoUsuario.getDpi());
			usuario.setEstado(nuevoUsuario.getEstado());
			usuario.setCreateby(nuevoUsuario.getCreateby());
			usuario.setCreatedate(nuevoUsuario.getCreatedate());
			return repository.save(usuario);
		} else {
			nuevoUsuario.setIdusuario(id);
			return repository.save(nuevoUsuario);
			
		}
		
	}
	
	
}
