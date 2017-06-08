package bluecode.mx.jpa.dto;

public class EmpleadoDto {
	private Long id;
	
	private String nombre;
	
	private String nombreEmpresa;
	
	private String pais;
	
	

	public EmpleadoDto(Long id, String nombre, String nombreEmpresa, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreEmpresa = nombreEmpresa;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "EmpleadoDto [id=" + id + ", nombre=" + nombre + ", nombreEmpresa=" + nombreEmpresa + ", pais=" + pais
				+ "]";
	}
	
	
	
}
