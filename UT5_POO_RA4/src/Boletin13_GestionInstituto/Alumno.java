package Boletin13_GestionInstituto;

public class Alumno extends Persona {
	private int edad;
	private Ciclo ciclo;
	private boolean mayorEdad;
	private Grupo grupo;

	public Alumno(String nombre, String apellido, int edad, Ciclo ciclo, Grupo grupo) {
	    super(nombre, apellido);
	    this.edad = edad;
	    this.ciclo = ciclo;
	    this.grupo = grupo;
	    //asigna true o false y es mayor de edad
	    this.mayorEdad = edad >= 18;
	}

	@Override
	public String toString() {
		String linea = "";
		linea = "Nombre alumno: " + this.nombre + "\n" + "Edad: " + this.edad+"\n" + "Ciclo: " + this.ciclo+"\n"+
		"Grupo: "+this.grupo;
		return linea;
	}
}
