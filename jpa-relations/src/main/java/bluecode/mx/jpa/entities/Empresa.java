package bluecode.mx.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_EMPRESA")
public class Empresa {

	@Id
	@Column(name = "ID_EMPRESA")	
	private Long idEmpresa;
	
	@Column(name = "NOMBRE_EMPRESA")
	private String nombreEmpresa;
	
	
	@OneToMany(mappedBy="empresa", cascade=CascadeType.ALL, fetch =FetchType.EAGER)
	private List<Empleado> empleados;
	
	@OneToMany(mappedBy="empresa", cascade=CascadeType.ALL, fetch =FetchType.EAGER)
	private List<Proyecto> proyectos;

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	@Override
	public String toString() {
		
		return "Empresa [idEmpresa=" + idEmpresa + ", nombreEmpresa=" + nombreEmpresa + "]";
	}
	
	
	
	
}
