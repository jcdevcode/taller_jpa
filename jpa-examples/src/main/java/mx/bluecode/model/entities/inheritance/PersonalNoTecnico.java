package mx.bluecode.model.entities.inheritance;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import mx.bluecode.model.enums.AreaLaboral;

@Entity
// 1
@DiscriminatorValue("PERSONAL NO TECNICO")

// 2
//@Table(name="TBL_PERSONAL_NO_TECNICO")
//@PrimaryKeyJoinColumn(referencedColumnName="ID")


// 3
//@Table(name="TBL_PERSONAL_NO_TECNICO")

public class PersonalNoTecnico extends Personal implements Serializable{

	private static final long serialVersionUID = 5983998326470919299L;
	
	private boolean manejaEquipoComputo;
	
	

	public PersonalNoTecnico() {
		super();
	}

	public PersonalNoTecnico(String nombreCompleto, AreaLaboral areaLaboral) {
		super(nombreCompleto, areaLaboral);
		// TODO Auto-generated constructor stub
	}

	public PersonalNoTecnico(String nombreCompleto, AreaLaboral areaLaboral, boolean manejaEquipoComputo) {
		super(nombreCompleto, areaLaboral);
		this.manejaEquipoComputo = manejaEquipoComputo;
	}

	public boolean isManejaEquipoComputo() {
		return manejaEquipoComputo;
	}

	public void setManejaEquipoComputo(boolean manejaEquipoComputo) {
		this.manejaEquipoComputo = manejaEquipoComputo;
	}

	@Override
	public String toString() {
		return "PersonalNoTecnico [id=" + getId() 
				+ ", nombreCompleto=" + getNombreCompleto() 
				+ ", areaLaboral=" + getAreaLaboral()								
				+ ", manejaEquipoComputo=" + manejaEquipoComputo + "]";
	}
	
	
	
	
	
}
