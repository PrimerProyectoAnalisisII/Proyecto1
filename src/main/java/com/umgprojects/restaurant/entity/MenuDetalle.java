package com.umgprojects.restaurant.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "MENU_DETALLE")
public class MenuDetalle implements Serializable{


	private static final long serialVersionUID = -5951304562723546510L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmenudetalle;
	@ManyToOne
	@JoinColumn(name = "IDMENU")
	private Menu menu;
	@ManyToOne
	@JoinColumn(name = "IDPRODUCTO")
	private Producto producto;
	private String createby;
	private Date createdate;
	
	public MenuDetalle() {}
	
	public MenuDetalle(Integer idmenudetalle, Menu menu, Producto producto, String createby, Date createdate) {
		this.idmenudetalle = idmenudetalle;
		this.menu = menu;
		this.producto = producto;
		this.createby = createby;
		this.createdate = createdate;
	}

	public Integer getIdmenudetalle() {
		return idmenudetalle;
	}

	public void setIdmenudetalle(Integer idmenudetalle) {
		this.idmenudetalle = idmenudetalle;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createby == null) ? 0 : createby.hashCode());
		result = prime * result + ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result + ((idmenudetalle == null) ? 0 : idmenudetalle.hashCode());
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		MenuDetalle other = (MenuDetalle) obj;
		if (createby == null) {
			if (other.createby != null)
				return false;
		} else if (!createby.equals(other.createby))
			return false;
		if (createdate == null) {
			if (other.createdate != null)
				return false;
		} else if (!createdate.equals(other.createdate))
			return false;
		if (idmenudetalle == null) {
			if (other.idmenudetalle != null)
				return false;
		} else if (!idmenudetalle.equals(other.idmenudetalle))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
	
}
