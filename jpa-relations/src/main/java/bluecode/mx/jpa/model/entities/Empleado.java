package bluecode.mx.jpa.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADOS")
public class Empleado implements Serializable{

	
	private static final long serialVersionUID = 7817281971074081911L;

	@Id
	@Column(name = "ID_EMPLEADO")
	private Long id;
	
	@Column(name = "NOMBRE_EMPLEADO")
	private String nombre;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="DIRECCION_ID")
	private Direccion direccion;
	
	@OneToMany(
	        mappedBy = "empleado", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<Telefono> telefonos;

	
	
	
	public Empleado() {
		super();
	}
	
	

	public Empleado(Long id, String nombre, Direccion direccion, List<Telefono> telefonos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefonos = telefonos;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefonos=" + telefonos
				+ "]";
	}

//	@Override
//	public String toString() {
//		return "Empleado [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
//	}
	
	
	
	
}
