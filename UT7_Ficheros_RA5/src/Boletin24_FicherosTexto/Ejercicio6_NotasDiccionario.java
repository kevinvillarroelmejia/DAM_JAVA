package Boletin24_FicherosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ejercicio6_NotasDiccionario {

	static String rutaSoluciones = "solucionesE6.txt";
	static String rutaRespuestas = "respuestasE6.txt";
	static String rutaNotasE6 = "notasE6.txt";

	public static void main(String[] args) {
		String[] soluciones = lecturaSoluciones();
		HashMap<String, String[]> respuestas = respuestasAlumnos();
		escribirNotas(soluciones, respuestas);
		leerFicheroNotas();
	}

	// leer soluciones.txt
	public static String[] lecturaSoluciones() {
		String[] soluciones = new String[10];
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaSoluciones));
			String linea;
			while ((linea = lector.readLine()) != null) {
				soluciones = linea.split(",\\s*");
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		return soluciones;
	}

	// leer respuestas y guardarlas en un hashmap <String , Arraylist<String>>
	public static HashMap<String, String[]> respuestasAlumnos() {
		HashMap<String, String[]> respuestaAlumnos = new HashMap<String, String[]>();
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaRespuestas));
			String linea;
			while ((linea = lector.readLine()) != null) {
				// guardamos clave = nombre del alumno
				int posicion = linea.indexOf(":");
				String alumno = linea.substring(0, posicion);

				String respuestasTexto = linea.substring(posicion + 2); // salta ": "
				String[] respuestas = respuestasTexto.split(",\\s*");

				respuestaAlumnos.put(alumno, respuestas);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		return respuestaAlumnos;
	}

	// escribir en notas.txt la media de cada alumno segun sus respuestas
	public static void escribirNotas(String[] soluciones, HashMap<String, String[]> respuestasAlumno) {
		String[] respuestas = null;
		try (FileWriter escritor = new FileWriter(rutaNotasE6)) {
			for (Map.Entry<String, String[]> alumno : respuestasAlumno.entrySet()) {
				respuestas = alumno.getValue();
				double nota = 0;
				String nombre = alumno.getKey();
				for (int i = 0; i < soluciones.length; i++) {
					if (soluciones[i].equalsIgnoreCase(respuestas[i])) {
						nota++;
					} else {
						nota = nota - 0.3;
					}
				}
				escritor.write(nombre + ":" + nota + "\n");
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void leerFicheroNotas() {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaNotasE6));
			String linea;
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea );
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
}
