package bluecode.mx.jpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_TELEFONO")
public class Telefono{
	
	@Id
	@Column(name = "ID_TELEFONO")
	private Long idTelefono;
	
	@Column(name = "NUM_TELEFONICO")
	private String numeroTelefonico;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ID_EMPLEADO")
	private Empleado propietario;
	
	
	public Long getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	

	public Empleado getPropietario() {
		return propietario;
	}

	public void setPropietario(Empleado propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "Telefono [idTelefono=" + idTelefono + ", numeroTelefonico=" + numeroTelefonico + "]";
	}
	
	
	
}
