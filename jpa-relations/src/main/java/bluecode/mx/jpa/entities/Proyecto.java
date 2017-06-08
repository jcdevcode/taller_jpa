package bluecode.mx.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROYECTO")
public class Proyecto {
	
	@Id
	@Column(name = "ID_PROYECTO")
	private Long idProyecto;
	
	@Column(name = "NOMBRE_PROYECTO")
	private String nombreProyecto;
	
	@ManyToMany(mappedBy="proyectos",cascade=CascadeType.ALL)
	private List<Empleado> empleados;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ID_EMPRESA")
	private Empresa empresa;

	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", nombreProyecto=" + nombreProyecto + "]";
	}
	
	
}
