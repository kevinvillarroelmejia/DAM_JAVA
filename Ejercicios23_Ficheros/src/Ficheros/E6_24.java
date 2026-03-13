package Ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class E6_24 {

	public static void main(String[] args) {
		String fsoluciones = "soluciones.txt";
		String frespuestas = "respuestas.txt";
		String fNotas="notas.txt";
		int numPreguntas=10;
		String soluciones[]= new String[numPreguntas];
		
		//ArrayList<String> soluciones = null;

		// El valor de este HashMap sera un ArrayList de String
		HashMap<String, String[]> respuestas = null;

		soluciones = leeSoluciones(fsoluciones);
//		respuestas = leeRespuestas(frespuestas);
		grabarNotas(fNotas,soluciones,respuestas);

	}
	public static String[] leeSoluciones(String fichero) {
		Path ruta=Path.of(fichero);
		String linea=null;
		try {
			linea=Files.readString(ruta);
		}catch (Exception e) {
			e.getMessage();
		}
		String[] soluciones=linea.split(", ");
		for(String letra:soluciones) {
			System.out.println(letra);
		}
		return soluciones;
	}

	public static HashMap<String, String[]> leeRespuestas(String fichero){
		HashMap<String, String[]> diccionario=new HashMap<String, String[]>();
		try (BufferedReader lector=new BufferedReader(new FileReader(fichero))){
			String linea;
			while((linea=lector.readLine())!=null) {//si la siguiente linea es esta vacia SALE
				int posicion=linea.indexOf(':');
				String alumno=linea.substring(0,posicion);
				String respuesta=linea.substring(posicion+2);
				
				System.out.println(alumno);
				System.out.println(respuesta);
				
				diccionario.put(alumno, respuesta.split(", "));
			}
		}catch (Exception e) {
			System.out.println("ERROR-"+e.getMessage());
		}
		System.out.println(diccionario);
		return diccionario;
	}

	public static void grabarNotas(String fichero ,String[] soluciones, HashMap<String, String[]> fnotas) {
	
	}

}
