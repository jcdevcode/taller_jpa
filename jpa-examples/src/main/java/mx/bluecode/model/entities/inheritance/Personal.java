package mx.bluecode.model.entities.inheritance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import mx.bluecode.model.enums.AreaLaboral;

@Entity
@Table(name = "TBL_PERSONAL")

// 1: SINGLE_TABLE
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPO_PERSONAL")

// 2: JOINED
//@Inheritance(strategy=InheritanceType.JOINED)

// 3: TABLE_PER_CLASS
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)


public class Personal implements Serializable{
	
	private static final long serialVersionUID = 1164634350747117993L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	@Column(name="NOMBRE_COMPLETO", nullable = false)
	private String nombreCompleto;
	
	@Column(name="AREA_LABORAL", nullable = false)
	@Enumerated(EnumType.STRING)
	private AreaLaboral areaLaboral;

	
	
	public Personal() {
		super();
	}

	public Personal(String nombreCompleto, AreaLaboral areaLaboral) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.areaLaboral = areaLaboral;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public AreaLaboral getAreaLaboral() {
		return areaLaboral;
	}

	public void setAreaLaboral(AreaLaboral areaLaboral) {
		this.areaLaboral = areaLaboral;
	}

	@Override
	public String toString() {
		return "Personal [id=" + id + ", nombreCompleto=" + nombreCompleto + ", areaLaboral=" + areaLaboral + "]";
	}
	
	
	
}
