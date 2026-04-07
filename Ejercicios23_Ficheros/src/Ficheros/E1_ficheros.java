package Ficheros;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E1_ficheros {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		
		
		boolean existe=false;//bandera
		String nombreFichero=null;
		
		while(existe==false) {
			System.out.println("Escribe el nombre del fichero: ");
			nombreFichero=teclado.nextLine();
			existe=existeElFichero(nombreFichero);
			if(existe==false) {
				System.out.printf("El fichero %s no existe\n",nombreFichero);
			}
		}
		ArrayList<String> lineas=devuelveContenido(nombreFichero);
		if(lineas!=null	) {
			System.out.println(lineas);
			System.out.println("Escribe la palaba buscar: ");
			String palabra=teclado.nextLine();
			
			System.out.printf("El fichero tiene %d lineas \n",lineas.size());
			int contador=0;
			for(String linea:lineas) {
				contador+=cuentaPalabras(linea ,palabra);
			}
			System.out.printf("La palabra %s aparece %d veces ",palabra,contador);
		}else {
			System.out.println("El fichero esta vacio o ha ocurrido un error al leerlo");
		}
		
		//PRIMERO PEDIMOS POR TECLADO EL NOMBRE DEL FICHERO
		
		//HACEMOS UN METODO QUE NOS DIGA SI EL FICHERO EXISTE O NO 
		//sI NO EXITE ,VOLVEMOS A PEDIR  NOMBRE DE FICHERO
		
		//UNA VEZ QUQE TENEMOS UN FICHERO VALIDO, HACEMOS OTRA FUNCION
		//QUE NOS DEVUELVA UN ARRAYLIST CON SU CONTENIDO
		
		//PEDIMOS UNA PALABRA AL USUARIO
		//HACEMOS UNA FUNCION QUE NOS DEVUELVA CUENTAS VECES APARECE UNA PALABRA EN UN LINEA DE TEXTO
		
		//Y LA EJECUTAMOS PARA CADA LINEA DEL ARRAYLIST
		
		//NO OLVIDAR IR ACUMULNADO RESULTADOS EN UN CONTADOR
		
	}
	
	//comprobar si el fichero existe
	public static boolean existeElFichero(String fichero) {
		File f=new File(fichero);
		//return (f.exists()); //devuelve un boolean ya existe un fichero o directorio
		//return (f.isDirectory());//boolea si existe y si es un directorio
		return (f.isFile());//boolean si existe y si es un fichero	
	}
	
	
	//DEVOLVIENDO EL CONTENIDO
	public static ArrayList<String> devuelveContenido(String fichero){
		ArrayList<String >lineas=null;
		Path f=Path.of(fichero);//objeto que simboliza el fichero

		try {
			//guarda CADA linea en una celda del ArrayList
			lineas=(ArrayList<String>)Files.readAllLines(f);//leo TODAS LAS LINEAS DEL FICHERO
		} catch (Exception e) {
			System.out.printf("Error con el fichero %s\n",fichero);
			System.out.println(e.getMessage());
		}
		return lineas;
	}
	public static int cuentaPalabras(String linea,String palabra) {
		int contadorPalabra=0;
		String[] palabras=linea.split("\\s+");// separador uno o más espacios en blanco.
		for(String p:palabras) {
			if(p.equalsIgnoreCase(palabra)) {
				contadorPalabra++;
			}
		}
		return contadorPalabra;
	}
	
	public static void metodo3() {
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
}
