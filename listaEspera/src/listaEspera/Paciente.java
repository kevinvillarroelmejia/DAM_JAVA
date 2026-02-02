package listaEspera;

import java.util.HashMap;
import java.util.Map;

public class Paciente extends Persona{
	
	
	//Diccionario de lista de citas
	private HashMap<Especialidad, Medico> listaMedicos=new HashMap<Especialidad, Medico>();
	private Medico medico;
	public Paciente(String nombre) {
		super(nombre);
	}
	public void pideCita(Especialidad espe) {
		listaMedicos.put(espe,medico);
	}
	
	public void listaCitas() {
		for(Map.Entry<Especialidad, Medico>indice:listaMedicos.entrySet()) {
			//corregir esto no podemos imprimir un objeto como Especialidad o Medico
			System.out.println("Especialidad: ",indice.getKey() +"Medico: ",indice.getValue());
		}
	}
	
	//los pacientes no pueden tener mas de una cita al mismo tiempo
}
