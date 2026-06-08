package Boletin24_FicherosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ejercicio6_NotasDiccionario {
	
	static String rutaSoluciones="/home/alumno/solucionesE6.txt";
	static String rutaRespuestas="/home/alumno/respuestasE6.txt";
	static String rutaNotasE6="/home/alumno/notasE6.txt";

	public static void main(String[] args) {
		String[] soluciones=lecturaSoluciones();
		HashMap<String, String[]> respuestas=respuestasAlumnos();
		
//		for(Map.Entry<String, String[]> alumnos:respuestas.entrySet()) {
//			System.out.println(alumnos.getKey());
//		}
		
		
	}
	//leer soluciones.txt
	public static String[] lecturaSoluciones() {
		String[] soluciones=new String[10];
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaSoluciones));
			String linea;
			while ((linea = lector.readLine()) != null) {
				soluciones=linea.split(",\\s*");
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		return soluciones;
	}
	
	//leer respuestas y guardarlas en un hashmap <String , Arraylist<String>>
	public static HashMap<String, String[]> respuestasAlumnos(){
		HashMap<String, String[]> respuestaAlumnos=new HashMap<String, String[]>();
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaRespuestas));
			String linea;
			while ((linea = lector.readLine()) != null) {
				//guardamos clave = nombre del alumno
				int posicion=linea.indexOf(":");
				String alumno = linea.substring(0, posicion);
				String[] respuestas=linea.split(linea.substring(posicion,linea.length()-1));
				respuestaAlumnos.put(alumno,respuestas);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		return respuestaAlumnos;
	}
	
	//escribir en notas.txt la media de cada alumno segun sus respuestas
	
	
}
