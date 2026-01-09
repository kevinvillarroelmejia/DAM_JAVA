package poo2;

import java.time.LocalDate;
import java.util.Arrays;

public class Tarea {
	//objeto tarea
	private String titulo;
	private String descripcion;
	private String color;
	private LocalDate fecha;
	private boolean completado=false;//cuando creamos una tarea no va estar hecha POR ESO ES FALSE
	
	//este atributo es comun a todas
	//atributo statico para meter la tarea en esta lista
	private static Tarea[] lista=null;//un array de Tarea //ESTA VACIO
	
	//CONSTRUCTOR
	//this es para quitar la ambiguedad es decir si los atributos que paso al constructor
	//se llaman iguales que los atributos creados al principio de la clase tenemos que llamar
	//al this si se llaman diferente podemos quitar el this y asociarlo
	public Tarea(String tit,String descripcion,String color) {
		titulo=tit; //TODO por ejemplo aqui se llaman diferente y estan asociados
		this.descripcion=descripcion;
		this.descripcion=descripcion;
		this.color=color;
		this.fecha=LocalDate.now();//fecha actual
		
		//metiendo la tarea en la lista
		if(lista==null) {//solo entra aqui cuando lo llama la primera tarea
			//inicializo la lista con un elemento  y copio en el la tarea
			lista=new Tarea[1];
			lista[0]=this;//this seria el objeto llamado por ejemplo t1 y t2
		}else {
			//aumento en una posicion la lista y copio en el la tarea
			//creo una lista copiada de otra mas UN tamaño
			lista=Arrays.copyOf(lista, lista.length+1);
			lista[lista.length-1]=this;//this es el t1 y t2 
		}
	}
	
	//METODO QUE MUESTRE LA TAREA DE MANERA BONITA
	public void mostrarTarea() {
		System.out.println("-----------------------------------------------");
		System.out.println(titulo+" ("+color+")");
		System.out.println(descripcion);
		System.out.println("Fecha :" +fecha+" - Completada: "+completado);
	}
	
	//TODO metodo statico
	//metodo que muestra una LISTA DE TAREAS
	public static void mostrarTareas() {
		for(Tarea tarea:lista) {
			tarea.mostrarTarea();
		}
	}
	
	//METODO QUE MARQUE UNA TAREA COMO COMPLETADO
	public void tareaCompletado() {
		this.completado=true;
	}
	
	//METODO que muestra la lista de tareas que no esten completadas
	public static void mostrarTareasNoCompletadas() {
		for(Tarea tarea:lista) {
			if(!tarea.completado) { //si la tarea esta en false muestra la tarea
			//if(!tarea.isCompletado()) {
			tarea.mostrarTarea();
			}
		}
	}
	//get que devuelve el valor de completado para saber si es false o true
	public boolean isCompletado() {
		return completado;
	}
	
	
	
}