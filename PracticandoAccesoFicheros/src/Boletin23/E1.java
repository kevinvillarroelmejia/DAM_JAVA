package Boletin23;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E1 {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		boolean bandera=false;
		String nombreFichero=null;
		do {
			System.out.println("Escribe el nombre del fichero");
			nombreFichero=teclado.nextLine();
			bandera=existeElFichero(nombreFichero);
			if(bandera==false) {
				System.out.println("El fichero no existe");
			}
		}while(bandera==false);
		ArrayList<String> lineas=contenidoFichero(nombreFichero);
		int contador=0;
		for(String linea:lineas) {
			contador=contadorPalabras(linea);
		}
		System.out.println("EL fichero "+nombreFichero+" Tiene "+contador);
	}

	// TODO metodo que comprueba que el fichero existe
	public static boolean existeElFichero(String fichero) {
		File f = new File(fichero);// existe el fichero??
		// return (f.exists()); //devuelve un boolean ya existe un fichero o directorio
		// return (f.isDirectory());//boolea si existe y si es un directorio
		return (f.isFile());// boolean si existe y si es un fichero
	}
	
	public static ArrayList<String> contenidoFichero(String fichero){
		ArrayList<String> lineas=null;
		Path f=Path.of(fichero);//apuntando al fichero
		try {
			lineas=(ArrayList<String>)Files.readAllLines(f);
		}catch (Exception e) {
			System.out.println("ERROR CON EL FICHERO"+e.getMessage());
		}
		return lineas;//devuelve un Arraylist con cada linea en una celda
	}
	
	public static int contadorPalabras(String linea) {
		int contador=0;
		ArrayList<String> palabras=new ArrayList<String>(List.of(linea.split("\\s+")));
		contador=palabras.size();
		return contador;
	}
	
}
