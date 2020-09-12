package com.umgprojects.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.restaurant.entity.Menu;
import com.umgprojects.restaurant.repository.MenuRepository;

@RestController
public class MenuController {

	private final MenuRepository repository;
	
	public MenuController(MenuRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/menus")
	List<Menu> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("/menus")
	Menu nuevoMenu(@RequestBody Menu nuevoMenu) {
		return repository.save(nuevoMenu);
	}
	
	@GetMapping("/menus/{id}")
	Menu uno(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/menus/{id}")
	Menu editarMenu(@RequestBody Menu nuevoMenu, @PathVariable Integer id) {
		Menu menu = repository.getOne(id);
		if(menu != null) {
			menu.setNombreMenu(nuevoMenu.getNombreMenu());
			menu.setPrecio(nuevoMenu.getPrecio());
			menu.setCreateby(nuevoMenu.getCreateby());
			menu.setCreatedate(menu.getCreatedate());
			return repository.save(menu);
		} else {
			nuevoMenu.setIdmenu(id);
			return repository.save(nuevoMenu);
		}
	}
	
}
