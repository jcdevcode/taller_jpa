package mx.bluecode.model.enums;

/**
 * Modela el tipo de alimentación de un animal.
 * @author devcode
 *
 */
public enum TipoAlimentacion {
	 HERVIVORO("SE ALIMENTA DE HIERBAS"), CARNIVORO("SE ALIMENTA DE CARNE"), OMNIVORO("SE ALIMENTA DE HIERBAS Y CARNE");
	
	private TipoAlimentacion(String description) {
		this.description = description;
	}
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
