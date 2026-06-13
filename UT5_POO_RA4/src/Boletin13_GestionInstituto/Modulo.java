package Boletin13_GestionInstituto;

public class Modulo {
	private String nombre;
	private int añoModulo;
	private int horasLectivas;
	private boolean moduloOptativo;
	
	public Modulo(String nombre,int añoModulo,int horasLectivas,boolean moduloOptativo) {
		this.nombre=nombre;
		this.añoModulo=añoModulo;
		this.horasLectivas=horasLectivas;
		this.moduloOptativo=moduloOptativo;
	}
	public String toString() {
		String linea="";
		linea="Modulo: "+this.nombre+"\nHoras Lectivas: "+this.horasLectivas;
		return linea;
	}
}
