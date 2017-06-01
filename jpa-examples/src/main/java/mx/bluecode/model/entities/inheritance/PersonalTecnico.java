package mx.bluecode.model.entities.inheritance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import mx.bluecode.model.enums.AreaLaboral;

@Entity
// 1
@DiscriminatorValue("PERSONAL TECNICO")

// 2
//@Table(name="TBL_PERSONAL_TECNICO")
//@PrimaryKeyJoinColumn(referencedColumnName="ID")

//3
//@Table(name="TBL_PERSONAL_TECNICO")
public class PersonalTecnico extends Personal implements Serializable{
	
	private static final long serialVersionUID = -200319054274350999L;
	
	@Column(name = "AREA_EXPERTIS")
	private String areaExpertis;
	
	@Column(name = "NIVEL_EXPERTIS")
	private String nivelExpertis;
		

	public PersonalTecnico() {
		super();
	}

	public PersonalTecnico(String nombreCompleto, AreaLaboral areaLaboral) {
		super(nombreCompleto, areaLaboral);
		// TODO Auto-generated constructor stub
	}

	public PersonalTecnico(String nombreCompleto, AreaLaboral areaLaboral, String areaExpertis, String nivelExpertis) {
		super(nombreCompleto, areaLaboral);
		this.areaExpertis = areaExpertis;
		this.nivelExpertis = nivelExpertis;
	}

	public String getAreaExpertis() {
		return areaExpertis;
	}

	public void setAreaExpertis(String areaExpertis) {
		this.areaExpertis = areaExpertis;
	}

	public String getNivelExpertis() {
		return nivelExpertis;
	}

	public void setNivelExpertis(String nivelExpertis) {
		this.nivelExpertis = nivelExpertis;
	}

	@Override
	public String toString() {
		
		return "PersonalTecnico [id=" + getId() 
				+ ", nombreCompleto=" + getNombreCompleto() 
				+ ", areaLaboral=" + getAreaLaboral() 
				+ ", areaExpertis=" + areaExpertis
				+ ", nivelExpertis=" + nivelExpertis 
				+ "]";
	}
	
	
	
	
}
