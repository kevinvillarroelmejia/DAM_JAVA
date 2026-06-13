package Boletin13_GestionInstituto;

public class Profesor extends Persona {
	private Grupo grupo;
	private Departamento departamento;

	public Profesor(String nombre, String apellido, Grupo grupo, Departamento departamento) {
		super(nombre, apellido);
		this.grupo = grupo;
		this.departamento = departamento;
	}

	public Profesor(String nombre, String apellido, Departamento departamento) {
		super(nombre, apellido);
		this.departamento = departamento;
	}

	// solo pueden ser una de estas 3
	public enum Departamento {
		Informatica, Empresa, Ingles
	}

	@Override
	public String toString() {
		String linea = "";
		linea = "Nombre profesor: " + this.nombre + "\nApellido: " + this.apellido + "\n" + "Grupo: " + this.grupo
				+ "\nDepartamento: " + this.departamento;
		return linea;

	}

}
