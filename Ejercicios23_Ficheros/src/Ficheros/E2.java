package Ficheros;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class E2 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		boolean existe = false;// bandera
		String nombreFichero = null;

		while (existe == false) {
			System.out.println("Escribe el nombre del fichero: ");
			nombreFichero = teclado.nextLine();
			existe = existeElFichero(nombreFichero);
			if (existe == false) {
				System.out.printf("El fichero %s no existe\n", nombreFichero);
			}
		}
		ArrayList<String> lineas = devuelveContenido(nombreFichero);
		System.out.println(lineas);
		System.out.printf("Numero de lineas: %d ", contadorLineas(lineas));
		if (lineasEnBlanco(lineas) == 0) {
			System.out.println("No tiene lineas en blanco");
		} else {
			System.out.println("Lineas en blanco " + lineasEnBlanco(lineas));
		}
	}

	public static boolean existeElFichero(String fichero) {
		File f = new File(fichero);
		// return (f.exists()); //devuelve un boolean ya existe un fichero o directorio
		// return (f.isDirectory());//boolea si existe y si es un directorio
		return (f.isFile());// boolean si existe y si es un fichero
	}

	// DEVOLVIENDO EL CONTENIDO
	public static ArrayList<String> devuelveContenido(String fichero) {
		ArrayList<String> lineas = null;
		Path f = Path.of(fichero);// objeto que simboliza el fichero

		try {
			// guarda CADA linea en una celda del ArrayList
			lineas = (ArrayList<String>) Files.readAllLines(f);// leo TODAS LAS LINEAS DEL FICHERO
		} catch (Exception e) {
			System.out.printf("Error con el fichero %s\n", fichero);
			System.out.println(e.getMessage());
		}
		return lineas;
	}

	public static int contadorLineas(ArrayList<String> lineas) {
		return lineas.size();
	}

	public static int lineasEnBlanco(ArrayList<String> lineas) {
		int contador = 0;
		int contadorLetras = 0;
		for (String linea : lineas) {
//			if (linea.equalsIgnoreCase("")) {
//				contadorLetras++;
//			}
			if (linea.equalsIgnoreCase(" ")) {
				contador++;
			}
		}
		return contador;
	}

}
