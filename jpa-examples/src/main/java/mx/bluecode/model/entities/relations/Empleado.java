package mx.bluecode.model.entities.relations;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_EMPLEADO")
public class Empleado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2799036994589844534L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_EMPLEADO")
	private Long id;
	
	@Column(name="NOMBRE_EMPLEADO")
	private String nombreEmpleado;
	
	@Column(name="CODIGO_EMP_UNICO", unique=true)
	private String codigoEmpladoUnico;
	
	@OneToOne(cascade ={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
//	@OneToOne
	@JoinColumn(name="ID_DIRECCION")
	private Direccion direccion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getCodigoEmpladoUnico() {
		return codigoEmpladoUnico;
	}

	public void setCodigoEmpladoUnico(String codigoEmpladoUnico) {
		this.codigoEmpladoUnico = codigoEmpladoUnico;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombreEmpleado=" + nombreEmpleado + ", codigoEmpladoUnico="
				+ codigoEmpladoUnico + ", direccion=" + direccion + "]";
	}

	
	
	

}
