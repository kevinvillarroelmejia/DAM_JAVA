package Escritura;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class E4 {

	public static void main(String[] args) {
		
	

	}

	public static void darLaVuelta(String origen, String destino) {

		ArrayList<String> listaOrigen = null;
		ArrayList<String> listaDestino = null;

		// leo el fichero origen como una lista
		listaOrigen.leerFichero(origen);

		// invierto el contenido de cada una de las lineas de la lista
		for (String linea : listaOrigen) {
			invertirContenido(linea);
			//meto la linea invertida en la lista destino en la primera posicion
			listaDestino.add(0,linea);
		}
		// escribo en el fichero destino
		escribirFichero(destino, listaDestino);
	}
	
	public static ArrayList<String> leerFichero(String fichero){
		ArrayList<String> lista=null;
		Path objetoFichero=Path.of(fichero);
		String contenido=null;
		try {
			lista=(ArrayList<String>)Files.readAllLines(objetoFichero);//leo TODAS LAS LINEAS DEL FICHERO
		} catch (Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage());
		}
		return lista;
	}
	public static String invertirContenido(String linea) {
		String invertida="";
		for(int i=0;i<linea.length();i++) {
			invertida=linea.charAt(i)+invertida;//invirtiendo la linea
		}
		return invertida;
	}
	
	public static void escribirFichero(String fichero, ArrayList<String> lista) {
		Path ruta=Path.of(fichero);
		try {
			Files.write(ruta, lista);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	
}
