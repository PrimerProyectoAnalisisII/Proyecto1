package com.umgprojects.restaurant.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "DETALLE_FACTURA")
public class DetalleFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddetallefactura;
	@ManyToOne
	@JoinColumn(name = "IDFACTURA")
	private Factura factura;
	@ManyToOne
	@JoinColumn(name = "IDORDEN")
	private Orden orden;
	private String createby;
	private Date createdate;
	
	public DetalleFactura() {}
	
	public DetalleFactura(Integer iddetallefactura, Factura factura, Orden orden, String createby, Date createdate) {
		this.iddetallefactura = iddetallefactura;
		this.factura = factura;
		this.orden = orden;
		this.createby = createby;
		this.createdate = createdate;
	}

	public Integer getIddetallefactura() {
		return iddetallefactura;
	}

	public void setIddetallefactura(Integer iddetallefactura) {
		this.iddetallefactura = iddetallefactura;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
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
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((iddetallefactura == null) ? 0 : iddetallefactura.hashCode());
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
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
		DetalleFactura other = (DetalleFactura) obj;
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
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (iddetallefactura == null) {
			if (other.iddetallefactura != null)
				return false;
		} else if (!iddetallefactura.equals(other.iddetallefactura))
			return false;
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
			return false;
		return true;
	}
	
}
