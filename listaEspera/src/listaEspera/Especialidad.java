package listaEspera;

import java.util.HashMap;

public class Especialidad {
	private HashMap<Especialidad, Medico> listaMedicos=new HashMap<Especialidad, Medico>();
	private String nombre;
	private Medico medico;
	public Especialidad(String nombre) {
		this.nombre=nombre;
		listaMedicos.put(this,medico);
	}
	
}
