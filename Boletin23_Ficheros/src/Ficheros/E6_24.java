package Ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class E6_24 {

	public static void main(String[] args) {
		String fsoluciones = "/home/alumno/soluciones.txt";
		String frespuestas = "/home/alumno/respuestas.txt";
		String fNotas="/home/alumno/notas.txt";
		int numPreguntas=10;
		String soluciones[]= new String[numPreguntas];
		
		//ArrayList<String> soluciones = null;

		// El valor de este HashMap sera un ArrayList de String
		HashMap<String, String[]> respuestas = null;

		soluciones = leeSoluciones(fsoluciones);
		respuestas = leeRespuestas(frespuestas);
		grabarNotas(fNotas,soluciones,respuestas);

	}
	public static String[] leeSoluciones(String fichero) {
		Path ruta=Path.of(fichero);
		String linea="";
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
			String linea="";
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
		//System.out.println(diccionario);
		return diccionario;
	}

	public static void grabarNotas(String fichero ,String[] soluciones, HashMap<String, String[]> respuestas) {
	//RECORRER EL DICCIONARIO 
		//CON ESTO RECORRE EL DICCIONARIO ELEMENTO A ELEMENTO
		
		try(PrintWriter pluma=new PrintWriter(fichero)){
			for(Map.Entry<String, String[]>respuesta:respuestas.entrySet())	{
				System.out.println(respuesta.getKey()+": ");
				System.out.println(calcularNota(soluciones,respuesta.getValue()));
				pluma.printf("%s: %.1f", respuesta.getKey(),calcularNota(soluciones, respuesta.getValue()));
				pluma.println();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	private static double calcularNota(String[] soluciones, String[] respuesta) {
		double nota=0;
		for(int i =0;i<soluciones.length;i++) {
			if(soluciones[i].charAt(0)==respuesta[i].charAt(0)) {
				nota+=1;
			}else {
				nota-=3;
			}
		}
		return nota;
	}


}
