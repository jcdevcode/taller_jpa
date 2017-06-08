package bluecode.mx.jpa.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_DIRECCION")
public class Direccion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6923307300542566539L;

	@Id
	@Column(name = "ID_DIRECCION")
	private Long idDireccion;
	
	@Column(nullable = false)
	private String calle;
	
	@Column(name = "NUM_INTERIOR")
	private String numInterior;
	
	@Column(name = "NUM_EXTERIOR", nullable = false)
	private String numExterior;	
	
	@Column(name = "CODIGO_POSTAL", nullable = false, length = 5)
	private Long codigoPostal;
	
	@Column(length = 100)
	private String localidad;
	
	@Column(length = 50)
	private String estado;
	
	@OneToOne(mappedBy = "direccion")
	private Lector lector;

	public Direccion() {
		super();
	}
	
	

	public Direccion(Long idDireccion, String calle, String numInterior, String numExterior, Long codigoPostal,
			String localidad, String estado) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.numInterior = numInterior;
		this.numExterior = numExterior;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.estado = estado;
	}



	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumInterior() {
		return numInterior;
	}

	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}

	public String getNumExterior() {
		return numExterior;
	}

	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}

	public Long getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	


	public Lector getLector() {
		return lector;
	}



	public void setLector(Lector lector) {
		this.lector = lector;
	}



	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calle=" + calle + ", numInterior=" + numInterior
				+ ", numExterior=" + numExterior + ", codigoPostal=" + codigoPostal + ", localidad=" + localidad
				+ ", estado=" + estado + "]";
	}
	
	
	
}
