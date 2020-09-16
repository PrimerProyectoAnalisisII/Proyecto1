package com.umgprojects.restaurant.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ORDEN")
public class Orden implements Serializable {

	private static final long serialVersionUID = -8501289800151636671L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idorden;
	private String idordennum;
	@ManyToOne
	@JoinColumn(name = "IDMENU", referencedColumnName = "IDMENU")
	private Menu menu;
	private String createby;
	private Date createdate;
	
	@OneToMany(mappedBy = "orden", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<DetalleFactura> detalleFactura = new HashSet<>();
	
	@OneToMany(mappedBy = "orden", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<OrdenDetalle> ordenDetalle = new HashSet<>();

	public Orden() {}
	
	public Orden(Integer idorden, String idordennum, Menu menu, String createby, Date createdate,
			Set<DetalleFactura> detalleFactura, Set<OrdenDetalle> ordenDetalle) {
		this.idorden = idorden;
		this.idordennum = idordennum;
		this.menu = menu;
		this.createby = createby;
		this.createdate = createdate;
		this.detalleFactura = detalleFactura;
		this.ordenDetalle = ordenDetalle;
	}

	public Integer getIdorden() {
		return idorden;
	}

	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}

	public String getIdordennum() {
		return idordennum;
	}

	public void setIdordennum(String idordennum) {
		this.idordennum = idordennum;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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

	public Set<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(Set<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	public Set<OrdenDetalle> getOrdenDetalle() {
		return ordenDetalle;
	}

	public void setOrdenDetalle(Set<OrdenDetalle> ordenDetalle) {
		this.ordenDetalle = ordenDetalle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createby == null) ? 0 : createby.hashCode());
		result = prime * result + ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result + ((detalleFactura == null) ? 0 : detalleFactura.hashCode());
		result = prime * result + ((idorden == null) ? 0 : idorden.hashCode());
		result = prime * result + ((idordennum == null) ? 0 : idordennum.hashCode());
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((ordenDetalle == null) ? 0 : ordenDetalle.hashCode());
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
		Orden other = (Orden) obj;
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
		if (detalleFactura == null) {
			if (other.detalleFactura != null)
				return false;
		} else if (!detalleFactura.equals(other.detalleFactura))
			return false;
		if (idorden == null) {
			if (other.idorden != null)
				return false;
		} else if (!idorden.equals(other.idorden))
			return false;
		if (idordennum == null) {
			if (other.idordennum != null)
				return false;
		} else if (!idordennum.equals(other.idordennum))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (ordenDetalle == null) {
			if (other.ordenDetalle != null)
				return false;
		} else if (!ordenDetalle.equals(other.ordenDetalle))
			return false;
		return true;
	}
	
}
