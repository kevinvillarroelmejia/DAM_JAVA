package ExamenAnime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio2 {

	static String rutaPersonajes = "personajes.txt";
	static String rutaAnimes = "animes.txt";

	public static void main(String[] args) {

		HashMap<Integer, String> diccionarioAnimes = lecturaAnimes();
//		for (Map.Entry<Integer, String> anime : diccionarioAnimes.entrySet()) {
//			System.out.println(anime.getKey()+" "+anime.getValue());
//		}
		mostrarSalida(diccionarioAnimes);
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

	public static void mostrarSalida(HashMap<Integer, String> diccionarioAnime) {
		try {
			String linea;
			int i=0;
			for (Map.Entry<Integer, String> anime : diccionarioAnime.entrySet()) {
				ArrayList<String> listaPersonajes=new ArrayList<String>();
				BufferedReader lector = new BufferedReader(new FileReader(rutaPersonajes));
				while ((linea = lector.readLine()) != null) {
					int clavePersonaje=Integer.parseInt(linea.substring(0,linea.indexOf(" ")));
					if(clavePersonaje==anime.getKey()) {
						listaPersonajes.add(linea);
					}
				}
				System.out.println(anime.getValue());
				for(String personajes:listaPersonajes) {
					System.out.println("- "+personajes);
				}
			}

		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}

}