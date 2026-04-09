package examen;

import java.io.Serializable;
import java.util.ArrayList;

public class Personaje implements Serializable{
	private String titulo;
	private String nombrePersonaje;
	
	private static ArrayList<Personaje> listaTareas = new ArrayList<Personaje>();

	public Personaje(String titulo,String nombrePersonaje) {
		this.titulo=titulo;
		this.nombrePersonaje=nombrePersonaje;
		listaTareas.add(this);
	}
	
}
