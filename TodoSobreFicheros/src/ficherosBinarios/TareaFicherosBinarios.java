package ficherosBinarios;

import java.io.Serializable;
import java.util.ArrayList;

import ficherosBinarios.TareaFicherosBinarios;

//TENEMOS QUE SERIALIZAR LA CLASE 
//CON ESTO INDICAMOS QUE ESTE OBJETO SE PUEDE CREAR UN BOJETO EN DISCO
//SI UNA CLASE TIENE HERENCIA EL Serializable SE PONE EN LA PADRE
public class  TareaFicherosBinarios  implements Serializable{
	private String identificador;
	private String titulo;
	private transient int prioridad; //si un atributo tiene transient no se graba en disco por seguridad
	private boolean estadoTarea; 

	//LOS DATOS ESTATICOS NO SE GRABAN EN DISCO
	private static ArrayList<TareaFicherosBinarios> listaTarea = new ArrayList<TareaFicherosBinarios>();

	// EJERCICIO 4 BOLETIN 25 - RECUPERAR TAREAS CON ESE FORMATO
	public TareaFicherosBinarios(String identificador, String titulo, int prioridad, boolean estadoTarea) {
		this.identificador = identificador;
		this.titulo = titulo;
		this.prioridad = prioridad;
		this.estadoTarea = estadoTarea;
		TareaFicherosBinarios.listaTarea.add(this);
	}
	public static void mostrarTareas() {
		for(TareaFicherosBinarios tarea:listaTarea) {
			tarea.mostrarTarea();
		}
	}
	public void mostrarTarea() {
		String completada = "";
		if (this.estadoTarea == true) {
			completada = "X";
		}
		System.out.printf("%s [%s] %s (Prioridad: %d)\n", completada, this.identificador, this.titulo, this.prioridad);
	}
}

