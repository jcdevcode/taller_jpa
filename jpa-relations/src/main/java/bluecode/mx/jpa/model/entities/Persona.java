package bluecode.mx.jpa.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import bluecode.mx.jpa.model.enums.TypoGenero;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Persona implements Serializable{

	private static final long serialVersionUID = -3091149765775140810L;
	
	@Id	
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOMBRE_COMPLETO", nullable=false)
	private String nombre;
	
	@Column(name="FECHA_NAC", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "GENERO", nullable=false)
	private TypoGenero genero;

	
	
	
	public Persona() {
		super();
	}

	public Persona(Long id, String nombre, Date fechaNacimiento, TypoGenero genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public TypoGenero getGenero() {
		return genero;
	}

	public void setGenero(TypoGenero genero) {
		this.genero = genero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
