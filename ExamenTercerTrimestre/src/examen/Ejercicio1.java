package examen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Ejercicio1 {
	public final static String ficheroAnime = "/home/alumno/Escritorio/animes.txt";
	public final static String ficheroPersonajes = "/home/alumno/Escritorio/personajes.txt";

	public static void main(String[] args) {
//		System.out.println(leerFichero(ficheroAnime));
		
		AnimesConelMismoID(22, ficheroPersonajes);
	}

	// FUNCION LEE UN FICHERO Y DEVUELVE UN DICCIONARIO CON UN IDENTIFICADOR(NUM
	// ANIME) Y SU VALOR(TITULO ANIME)
	public static HashMap<Integer, String> leerFichero(String fichero) {
		HashMap<Integer, String> diccionario = new HashMap<>();
		try (BufferedReader lector = new BufferedReader(new FileReader(fichero))) {
			String linea;
			while ((linea = lector.readLine()) != null) {
				int posicion = linea.indexOf(" ");
				String identificadorTexto = linea.substring(0, posicion);
				String titulo = linea.substring(posicion + 1);
				int numeroID = Integer.parseInt(identificadorTexto);
				diccionario.put(numeroID, titulo);
			}
		} catch (Exception e) {
			// El fichero no existe o no se puede acceder
			System.out.println("Fichero inexistente o imposible acceder a él");
			return null;
		}
		return diccionario;
	}

	public static void AnimesConelMismoID(int ID, String fichero) {
		ArrayList<String> listaDePersonajes = new ArrayList<String>();
		int numeroID=0;
		HashMap<Integer, String> diccionarioAnimes = leerFichero(ficheroAnime);
		try (BufferedReader lector = new BufferedReader(new FileReader(fichero))) {
			String linea;
			for (int id : diccionarioAnimes.keySet()) {// keySet devuelve solo las claves del diccionario
				// COMPARAR EL ID
				
				while ((linea = lector.readLine()) != null) {
					int posicion = linea.indexOf(" ");
					String identificadorTexto = linea.substring(0, posicion);
					String titulo = linea.substring(posicion + 1);
					numeroID = Integer.parseInt(identificadorTexto);
					if (ID == numeroID) {
						listaDePersonajes.add(linea);
					}
				}
			}
			for(String personaje:listaDePersonajes){
				String p=personaje.substring(2,personaje.length());
				System.out.println("- "+p);
			}
			//Se que tengo que mostrar el valor del diccionario
			
//			if(ID == numeroID) {
//				System.out.println(listaDeAnimes);
//			}
		} catch (Exception e) {
			System.out.println("ERROR 1" + e.getMessage());
		}
		
	}
}
