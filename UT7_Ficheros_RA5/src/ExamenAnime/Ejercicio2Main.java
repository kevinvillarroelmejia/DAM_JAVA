package ExamenAnime;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio2Main {
	static String rutaPersonajes = "personajes.txt";
	static String rutaAnimes = "animes.txt";

	static String rutaFicheroDat = "personajes.dat";

	public static void main(String[] args) {
		HashMap<Integer, String> diccionarioAnimes = lecturaAnimes();
//		mostrarSalida(diccionarioAnimes);
		leerFichero();
		ArrayList<Personaje> lista=listaPersonajeCoincidencia(diccionarioAnimes);
	}

	// leemos fichero animes
	public static HashMap<Integer, String> lecturaAnimes() {
		HashMap<Integer, String> dicAnimes = new HashMap<Integer, String>();
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaAnimes));
			String linea;
			while ((linea = lector.readLine()) != null) {
				ArrayList<String> listaPersonajes = new ArrayList<String>();
				int posicionPimerEspacio = linea.indexOf(" ");
				int clave = Integer.parseInt(linea.substring(0, posicionPimerEspacio));
				String titulo = linea.substring(posicionPimerEspacio + 1);
				dicAnimes.put(clave, titulo);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		return dicAnimes;
	}

	public static ArrayList<Personaje> listaPersonajeCoincidencia(HashMap<Integer, String> diccionarioAnime) {
		ArrayList<Personaje> listaPersonajes = new ArrayList<Personaje>();;
		try {
			String linea;
			for (Map.Entry<Integer, String> anime : diccionarioAnime.entrySet()) {
				BufferedReader lector = new BufferedReader(new FileReader(rutaPersonajes));
				while ((linea = lector.readLine()) != null) {
					int clavePersonaje = Integer.parseInt(linea.substring(0, linea.indexOf(" ")));
					if (clavePersonaje == anime.getKey()) {
						Personaje personaje=new Personaje(anime.getValue(), linea);
						listaPersonajes.add(personaje);
					}
				}
			}
			try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(rutaFicheroDat))) {
				for (Personaje personajeAnime: listaPersonajes) {
					binario.writeObject(personajeAnime);
				}
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
			e.printStackTrace();
		}
		return listaPersonajes;
	}

	public static void leerFichero() {
		Personaje personaje = null;
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(rutaFicheroDat))) {
			
			personaje = (Personaje) binario.readObject();
			System.out.println(personaje);

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
