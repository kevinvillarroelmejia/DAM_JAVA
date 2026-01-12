package TareasConColecciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class TareasTarjetas {
	// objeto tarea
	private String titulo;
	private String descripcion;
	private String color;
	private LocalDate fecha;
	private boolean completado = false;

	private static ArrayList<TareasTarjetas> lista = new ArrayList<TareasTarjetas>();

	public TareasTarjetas(String tit, String descripcion, String color) {
		titulo = tit; // TODO por ejemplo aqui se llaman diferente y estan asociados
		this.descripcion = descripcion;
		this.descripcion = descripcion;
		this.color = color;
		this.fecha = LocalDate.now();

		// añadiendo la tarea a la lista
		lista.add(this);
	}

	// METODO QUE ELIMINA UNA TAREA
	//TODO si eliminamos por objeto y lo elimamos y no esta no da error
	//TODO pero si lo eliminamos por posicion y no esta da FALSE
	public void eliminarTarea() {
		if(lista.remove(this)==false){//this es el objeto desde el que llamamos a esta funcion
			System.err.println("No puedo eliminar la tarea. No existe");
		}
	}

	// METODO QUE MARQUE UNA TAREA COMO COMPLETADO
	public void tareaCompletado() {
		this.completado = true;
	}

	public void mostrarTarea() {
		System.out.println("-----------------------------------------------");
		System.out.println(titulo + " (" + color + ")");
		System.out.println(descripcion);
		System.out.println("Fecha :" + fecha + " - Completada: " + completado);
	}

	// REPASAR QUE ES ESO DE STATIC
	// METODO que muestra la lista de tareas que no esten completadas
	public static void mostrarTareasNoCompletadas() {
		for (TareasTarjetas tarea : lista) {
			if (!tarea.completado) { // si la tarea esta en false muestra la tarea
				// if(!tarea.isCompletado()) {
				tarea.mostrarTarea();
			}
		}
	}

	public static void mostrarTodaLaLista() {
		//
		//Iterator<TareasTarjetas> iterator = lista.iterator();
		//hastNext es la condicion de salida que devuelve el objeto del ArrayList
		//while (iterator.hasNext()) {
		//System.out.println(iterator.next()); //esto es como el contador del for
		//}
		for(TareasTarjetas tarea : lista) {
			tarea.mostrarTarea();
		}
	}

	// get que devuelve el valor de completado para saber si es false o true
	public boolean isCompletado() {
		return completado;
	}
}
