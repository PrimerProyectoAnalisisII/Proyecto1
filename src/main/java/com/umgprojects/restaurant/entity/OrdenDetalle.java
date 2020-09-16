package com.umgprojects.restaurant.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "ORDEN_DETALLE")
public class OrdenDetalle implements Serializable {

	private static final long serialVersionUID = 4418646646244021646L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idordendetalle;
	@ManyToOne
	@JoinColumn(name = "IDORDEN", referencedColumnName = "IDORDEN")
	private Orden orden;
	@ManyToOne
	@JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
	private Producto producto;
	private String createby;
	private Date createdate;
	
	public OrdenDetalle() {}
	
	public OrdenDetalle(Integer idordendetalle, Orden orden, Producto producto, String createby, Date createdate) {
		this.idordendetalle = idordendetalle;
		this.orden = orden;
		this.producto = producto;
		this.createby = createby;
		this.createdate = createdate;
	}

	public Integer getIdordendetalle() {
		return idordendetalle;
	}

	public void setIdordendetalle(Integer idordendetalle) {
		this.idordendetalle = idordendetalle;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
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
		result = prime * result + ((idordendetalle == null) ? 0 : idordendetalle.hashCode());
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
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
		OrdenDetalle other = (OrdenDetalle) obj;
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
		if (idordendetalle == null) {
			if (other.idordendetalle != null)
				return false;
		} else if (!idordendetalle.equals(other.idordendetalle))
			return false;
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
	
}
