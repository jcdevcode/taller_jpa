package mx.bluecode.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.bluecode.model.enums.TipoAlimentacion;

@Entity
@Table(name="TBL_ANIMALES")
public class Animal implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7494896968825330283L;

	@Id
	@Column(name = "ID_ANIMAL")
	private Long id;
	
	@Column(name = "NOMBRE_ANIMAL", length = 25, nullable = false)
	private String nombre;
	
	@Column(name = "TIPO_ANIMAL", length = 100, nullable = false)
	private String tipo;
	
	@Column(name = "TIPO_ALIMENTACION", nullable = true)
	@Enumerated(value=EnumType.ORDINAL)
	//@Enumerated(value=EnumType.ORDINAL)
	private TipoAlimentacion tipoAlimentacion;
	
	
	
	

	public Animal() {
		super();
	}

	public Animal(Long id, String nombre, String tipo, TipoAlimentacion tipoAlimentacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.tipoAlimentacion = tipoAlimentacion;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public TipoAlimentacion getTipoAlimentacion() {
		return tipoAlimentacion;
	}

	public void setTipoAlimentacion(TipoAlimentacion tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", tipoAlimentacion=" + tipoAlimentacion
				+ "]";
	}
	
	
	
	
}
