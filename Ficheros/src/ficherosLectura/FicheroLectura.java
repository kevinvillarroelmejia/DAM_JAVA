package ficherosLectura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FicheroLectura {

	public static void main(String[] args) {
		// ===FICHERO TEXTO===

		// ===FICHERO BINARIO===
		/* Recurimos a uno binario cuando el usuario no pueda acceder a el */
		// Para darle persistencia a los objetos
		// ARCHIVOS NO MODIFICABLES

		// ~~~~~RECORIENDO FICHEROS~~~~~
		// TODO 5 METODOS DIFERETES PARA LEER UN FICHERO

		// UN SALTO LE LINEA SE REPRESENTA CON UN \n

		// OBLIGATORIO USAR EXCEPCIONES
		// OBLIGATORIO CERRAR SIEMPRE EL FICHERO

		// metodo1();
		//metodo2();
		//metodo3();
		//metodo4();
	}



	public static void metodo1() {
		// SIEMPRE TENEMOS QUE TRABAJAR CON EXCEPSIONES
		try {
			// LEER EL FICHERO
			FileReader fichero = new FileReader("/home/alumno/Escritorio/quijote.txt");// ES EL PROFIO FICHERO
			// Tambien lo podemos usar asi
			// BufferedReader lector = new BufferedReader(new
			// FileReader("/home/alumno/Escritorio/quijote.txt"));

			// El propio cursor para leer el fichero
			BufferedReader lector = new BufferedReader(fichero);// LO TENEMOS QUE CERRAR

			String linea;

			while ((linea = lector.readLine()) != null) {// COMPROBAMOS SI LECTOR ES DIFERENTE A NULL
				System.out.println(linea);
			}

			lector.close();// Cerramos y liberamos los recursos
		} catch (Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage());
		}
	}
	//LEYENDO LINEA A LINEA
	public static void metodo2() {
		try {
			File fichero = new File("/home/alumno/Escritorio/quijote.txt");
			Scanner lector = new Scanner(fichero);
//			String linea=lector.nextLine();
//			System.out.println(linea);
			String linea;
			// IMPRIMIR FICHERO ENTERO
			while (lector.hasNextLine()) {// COMPRUEBA SI EXISTE UNA SIGUIENTE LINEA
				linea = lector.nextLine();
				System.out.println(linea);
			}
			lector.close();// Cerramos y liberamos los recursos
		} catch (Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage());
		}
	}

	private static void metodo3() {
		ArrayList<String >lineas=null;
		try {
			Path fichero=Path.of("/home/alumno/Escritorio/quijote.txt");//objeto que simboliza el fichero
			//guarda CADA linea en una celda del ArrayList
			lineas=(ArrayList<String>)Files.readAllLines(fichero);//leo TODAS LAS LINEAS DEL FICHERO
		} catch (Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage());
		}
		for(String linea:lineas) {
			System.out.println(linea);
		}
	}
	
	private static void metodo4() {
		/* EN ESTE METODO SI QUE SALEN LOS \n*/
		Path fichero=Path.of("/home/alumno/Escritorio/quijote.txt");//lo mismo que el anterior
		String contenido=null;
		try {
			contenido=Files.readString(fichero);
		} catch (Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage());
		}
		System.out.println(contenido);
	}
}


/*
 * RECORIDO ==1== do { linea=lector.readLine();//lee la primero linea //cuando
 * acaba de leer TODO el fichero devuelve null if(linea!=null) {
 * System.out.println(linea); } }while(linea!=null);
 */
/*
 * RECORIDO ==2== while(linea!=null) { System.out.println(linea);
 * linea=lector.readLine(); }
 */
//DE TODOS LO RECORIDOS ESTE ES EL PEOR
