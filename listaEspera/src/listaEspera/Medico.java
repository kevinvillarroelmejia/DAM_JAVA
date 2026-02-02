package listaEspera;

import java.util.ArrayList;

public class Medico extends Persona {
	//los medicos tendran una especialidad

	private Especialidad especialidad;
	private static ArrayList<Paciente> listaPacientes;

	public Medico(String nombre,Especialidad especialidad) {
		super(nombre);
		this.especialidad=especialidad;
	}
	
}
