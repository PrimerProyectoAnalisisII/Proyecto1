package com.umgprojects.restaurant.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = 3631298028864495313L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproducto;
	private String descripcion;
	private Double precioUni;
	private Double precioAd;
	private String createby;
	private Date createdate;
	@OneToMany(mappedBy = "producto", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<MenuDetalle> menudetalle = new HashSet<>();
	@OneToMany(mappedBy = "producto", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<OrdenDetalle> ordendetalle = new HashSet<>();
	
	public Producto() {}

	public Producto(Integer idproducto, String descripcion, Double precioUni, Double precioAd, String createby,
			Date createdate, Set<MenuDetalle> menudetalle, Set<OrdenDetalle> ordendetalle) {
		this.idproducto = idproducto;
		this.descripcion = descripcion;
		this.precioUni = precioUni;
		this.precioAd = precioAd;
		this.createby = createby;
		this.createdate = createdate;
		this.menudetalle = menudetalle;
		this.ordendetalle = ordendetalle;
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUni() {
		return precioUni;
	}

	public void setPrecioUni(Double precioUni) {
		this.precioUni = precioUni;
	}

	public Double getPrecioAd() {
		return precioAd;
	}

	public void setPrecioAd(Double precioAd) {
		this.precioAd = precioAd;
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

	public Set<OrdenDetalle> getOrdendetalle() {
		return ordendetalle;
	}

	public void setOrdendetalle(Set<OrdenDetalle> ordendetalle) {
		this.ordendetalle = ordendetalle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createby == null) ? 0 : createby.hashCode());
		result = prime * result + ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idproducto == null) ? 0 : idproducto.hashCode());
		result = prime * result + ((menudetalle == null) ? 0 : menudetalle.hashCode());
		result = prime * result + ((ordendetalle == null) ? 0 : ordendetalle.hashCode());
		result = prime * result + ((precioAd == null) ? 0 : precioAd.hashCode());
		result = prime * result + ((precioUni == null) ? 0 : precioUni.hashCode());
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
		Producto other = (Producto) obj;
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
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idproducto == null) {
			if (other.idproducto != null)
				return false;
		} else if (!idproducto.equals(other.idproducto))
			return false;
		if (menudetalle == null) {
			if (other.menudetalle != null)
				return false;
		} else if (!menudetalle.equals(other.menudetalle))
			return false;
		if (ordendetalle == null) {
			if (other.ordendetalle != null)
				return false;
		} else if (!ordendetalle.equals(other.ordendetalle))
			return false;
		if (precioAd == null) {
			if (other.precioAd != null)
				return false;
		} else if (!precioAd.equals(other.precioAd))
			return false;
		if (precioUni == null) {
			if (other.precioUni != null)
				return false;
		} else if (!precioUni.equals(other.precioUni))
			return false;
		return true;
	}
	
}