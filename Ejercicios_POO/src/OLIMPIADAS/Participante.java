package OLIMPIADAS;

public class Participante {
	private String nombre;
	private String nacionalidad;
	
	public Participante(String nombre, String nacionalidad) {
		this.nombre=nombre;
		this.nacionalidad=nacionalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

}
