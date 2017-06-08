package bluecode.mx.jpa.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECCIONES")
public class Direccion implements Serializable{
	
	
	private static final long serialVersionUID = 5766731620127632155L;

	@Id
	@Column(name = "DIRECCION_ID")
	private Long Id;
	
	@Column(name = "UBICACION")
	private String ubicacion;
	
	@Column(name = "CODIGO_POSTAL")
	private int codigoPostal;
	
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	@Override
	public String toString() {
		return "Direccion [Id=" + Id + ", ubicacion=" + ubicacion + ", codigoPostal=" + codigoPostal + "]";
	}
	
	
	
	
}
