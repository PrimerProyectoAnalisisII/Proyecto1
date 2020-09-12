package com.umgprojects.restaurant.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="MENU")
public class Menu implements Serializable {
	

	private static final long serialVersionUID = 7105865382818488849L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmenu;
	private String nombreMenu;
	private Double precio;
	private String createby;
	private Date createdate;
	@OneToMany(mappedBy = "menu")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Set<MenuDetalle> menudetalle = new HashSet<>();
	@OneToMany(mappedBy = "menu")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Set<Orden> orden = new HashSet<>();
	
	public Menu() {}
	
	public Menu(Integer idmenu, String nombreMenu, Double precio, String createby, Date createdate,
			Set<MenuDetalle> menudetalle, Set<Orden> orden) {
		this.idmenu = idmenu;
		this.nombreMenu = nombreMenu;
		this.precio = precio;
		this.createby = createby;
		this.createdate = createdate;
		this.menudetalle = menudetalle;
		this.orden = orden;
	}

	public Integer getIdmenu() {
		return idmenu;
	}

	public void setIdmenu(Integer idmenu) {
		this.idmenu = idmenu;
	}

	public String getNombreMenu() {
		return nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Set<MenuDetalle> getMenudetalle() {
		return menudetalle;
	}

	public void setMenudetalle(Set<MenuDetalle> menudetalle) {
		this.menudetalle = menudetalle;
	}

	public Set<Orden> getOrden() {
		return orden;
	}

	public void setOrden(Set<Orden> orden) {
		this.orden = orden;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result + ((createby == null) ? 0 : createby.hashCode());
		result = prime * result + ((idmenu == null) ? 0 : idmenu.hashCode());
		result = prime * result + ((menudetalle == null) ? 0 : menudetalle.hashCode());
		result = prime * result + ((nombreMenu == null) ? 0 : nombreMenu.hashCode());
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (createdate == null) {
			if (other.createdate != null)
				return false;
		} else if (!createdate.equals(other.createdate))
			return false;
		if (createby == null) {
			if (other.createby != null)
				return false;
		} else if (!createby.equals(other.createby))
			return false;
		if (idmenu == null) {
			if (other.idmenu != null)
				return false;
		} else if (!idmenu.equals(other.idmenu))
			return false;
		if (menudetalle == null) {
			if (other.menudetalle != null)
				return false;
		} else if (!menudetalle.equals(other.menudetalle))
			return false;
		if (nombreMenu == null) {
			if (other.nombreMenu != null)
				return false;
		} else if (!nombreMenu.equals(other.nombreMenu))
			return false;
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}
	
	
}
