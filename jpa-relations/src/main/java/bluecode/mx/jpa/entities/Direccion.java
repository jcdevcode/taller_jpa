package bluecode.mx.jpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_DIRECCION")
public class Direccion {

	@Id
	@Column(name = "ID_DIRECCION")
	private Long idDireccion;
	
	@Column(name = "PAIS")
	private String pais;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="direccion", fetch = FetchType.LAZY)
	private Empleado empleado;

	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", pais=" + pais + ", ciudad=" + ciudad + "]";
	}
	
	
}
