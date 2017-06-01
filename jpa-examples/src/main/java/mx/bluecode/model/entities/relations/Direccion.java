package mx.bluecode.model.entities.relations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_DIRECCION")
public class Direccion implements Serializable{

	private static final long serialVersionUID = -7255493094738271831L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_DIRECCION")
	private Long id;
	
	@Column(name = "CALLE")
	private String calle;
	
	@Column(name = "CODIGO_POSTAL")
	private Long codigoPostal;
	
	@Column(name = "NUMERO_INTERIOR")
	private String numInterior;
	
	@Column(name = "NUMERO_EXTERIOR")
	private String numExterior;
	
	public Direccion(){
		super();
	}

	public Direccion(String calle, Long codigoPostal, String numInterior, String numExterior) {
		super();
		this.calle = calle;
		this.codigoPostal = codigoPostal;
		this.numInterior = numInterior;
		this.numExterior = numExterior;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Long getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Long codigoPostal) {
		this.codigoPostal = codigoPostal;
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

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", codigoPostal=" + codigoPostal + ", numInterior="
				+ numInterior + ", numExterior=" + numExterior + "]";
	}
	
	
	
	
	
}
