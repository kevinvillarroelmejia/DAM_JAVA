package Boletin13_GestionInstituto;

import java.util.ArrayList;

public class Grupo {
	
	private String nombre;
	private Ciclo ciclo;
	private String curso;
	private Profesor tutor;
	private int numeroAlumnos;
	private ArrayList<Alumno> listaAlumnoGrupo=new ArrayList<Alumno>();
	
	public Grupo(String nombre,Ciclo ciclo, Profesor profesor, int numeroAlumnos,String curso) {
		this.nombre=nombre;
		this.ciclo=ciclo;
		this.curso=curso;
		this.tutor=profesor;
		this.numeroAlumnos=numeroAlumnos;
	}
	
	public void ayadirAlumno(Alumno alumno) {
		listaAlumnoGrupo.add(alumno);
	}
	public void eliminarAlumno(Alumno alumno) {
		listaAlumnoGrupo.remove(alumno);
	}
	
	@Override
	public String toString() {
		String linea="Nombre grupo: "+this.nombre+"\nPRofesor:"+this.tutor+"\n";
		for(Modulo modulo:this.ciclo.modulosImpartidos) {
			linea=linea+modulo+"\n";
		}
		return linea;
	}
	
}
