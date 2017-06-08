package bluecode.mx.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_EMPLEADOS")
public class Empleado{

	@Id
	@Column(name = "ID_EMPLEADO")
	private Long idEmpleado;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_DIRECCION")
	private Direccion direccion;
	
	@OneToMany(mappedBy="propietario", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Telefono> telefonos;

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		name = "ASOC_EMP_PROYECT",
		joinColumns={@JoinColumn(name="ID_EMPLEADO")},
		inverseJoinColumns={@JoinColumn(name="ID_PROYECTO")}
	)
	private List<Proyecto> proyectos;
	
	@ManyToOne(cascade=CascadeType.ALL, optional = true)
    @JoinColumn(name="ID_EMPRESA")
	private Empresa empresa;

	public Long getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	
	
	public List<Proyecto> getProyectos() {
		return proyectos;
	}


	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	

	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + "]";
	}
	
	
	
}
