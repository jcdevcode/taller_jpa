package bluecode.mx.jpa.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TELEFONOS")
public class Telefono implements Serializable{
		
	private static final long serialVersionUID = 22999855480735562L;

	@Id
	@Column(name = "TELEFONO_ID")
	private Long id;
	
	@Column(name = "NUM_TELEFONICO")
	private String numeroTelefonico;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLEADO")
	private Empleado empleado;
	
	
	

	public Telefono() {
		super();
	}

	public Telefono(Long id, String numeroTelefonico) {
		super();
		this.id = id;
		this.numeroTelefonico = numeroTelefonico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", numeroTelefonico=" + numeroTelefonico + ", empleado=" + getEmpleado() + "]";
	}
	
		
	

}
