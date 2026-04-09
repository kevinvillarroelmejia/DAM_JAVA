package examen;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		String fichero ="/home/alumno/personajes.dat";
		
		Personaje zoro=new Personaje("One piece", " Roronoa zoro");
		Personaje kamado=new Personaje("Demon Slayer", "Tanjiro Kamado");
		Personaje uzumaki=new Personaje("Naruto", "Naruto Uzumaki");
		Personaje takakura=new Personaje("Dan da dan", "ken tatakakura");
		
		ArrayList<Personaje> listaPersonajes=new ArrayList<Personaje>();
		escribirFicheroBinario(listaPersonajes, fichero);
		
	}
	public static void escribirFicheroBinario(ArrayList<Personaje> listaPersonajes ,String fichero) {
		try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(fichero))) {
			binario.writeObject(listaPersonajes);
		}catch (Exception e) {
			System.out.println("Error 2 - "+e.getMessage() );
		}

	}

}
