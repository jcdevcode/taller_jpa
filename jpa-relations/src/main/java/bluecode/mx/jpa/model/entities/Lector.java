package bluecode.mx.jpa.model.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bluecode.mx.jpa.model.enums.TypoGenero;

/**
 * Modela a un lector
 * @author devcode
 *
 */

@Entity
@Table(name = "TBL_LECTOR")
public class Lector extends Persona{

	private static final long serialVersionUID = -3412014174122766776L;
		
	@Column(name = "NUMERO_SOCIO", nullable = false , length = 10, unique = true)
	private String numeroSocio;
	
	//@OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST})
	@OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.REMOVE})
	//@OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST}, orphanRemoval = true)
	@JoinColumn(name = "ID_DIRECCION")
	private Direccion direccion;
	
	public Lector() {
		super();
	}


	public Lector(Long id, String nombre, Date fechaNacimiento, TypoGenero genero, String numeroSocio) {
		super(id, nombre, fechaNacimiento, genero);
		this.numeroSocio = numeroSocio;
	}

	public String getNumeroSocio() {
		return numeroSocio;
	}

	public void setNumeroSocio(String numeroSocio) {
		this.numeroSocio = numeroSocio;
	}

	
	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Lector: "
				+ "[ id = " + getId()
				+ ", Nombre = " + getNombre()
				+ ", Fecha de Nacimiento = " + getFechaNacimiento()
				+ ", Género = " + getGenero()  
				+ ", Número de socio = " + getNumeroSocio()
				+ "]";
	}
	
	
	

}
