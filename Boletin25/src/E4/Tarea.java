package E4;

import java.util.ArrayList;

public class Tarea {
	private String identificador;
	private String titulo;
	private int prioridad;
	private boolean estadoTarea; //1 o 0 para guardar el fichero
	
	private static ArrayList<Tarea> listaTarea=new ArrayList<Tarea>();
		
	public Tarea(String identificador,String titulo,int prioridad,boolean estadoTarea) {
		this.identificador=identificador;
		this.titulo=titulo;
		this.prioridad=prioridad;
		this.estadoTarea=estadoTarea;
		Tarea.listaTarea.add(this);
	}

	public static Tarea leerFicheroTareas(String tarea) {
		
		
		return null;
	}
	
}
