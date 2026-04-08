package Boletin23;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class E10 {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		boolean bandera=false;
		String nombreFichero=null;
		do {
			System.out.println("Escribe el nombre del fichero");
			nombreFichero=teclado.nextLine();
			bandera=existeFichero(nombreFichero);
			if(bandera==false) {
				System.out.println("El fichero no existe");
			}
		}while(bandera==false);
		if(bandera) {
			System.out.println("LISTA SUCIA "+contenidoSucioFichero(nombreFichero));
			System.out.println("LISTA LIMPIA "+contenidoLimpio(nombreFichero));
		}
		
	}
	public static boolean existeFichero(String fichero) {
		File f=new File(fichero);
		return f.isFile();
	}
	
	public static ArrayList<String> contenidoSucioFichero(String fichero){
		ArrayList<String> arrayListContenido=null;
		Path f=Path.of(fichero);
		try {
			arrayListContenido=(ArrayList<String>)Files.readAllLines(f);
		}catch (Exception e) {
			System.out.println("ERROR 1"+e.getMessage());
		}
		return arrayListContenido;
	}
	
	//FILTRO UN ARRAY DE STRING A UNO DE DOUBLES
	public static ArrayList<Double> contenidoLimpio(String fichero){
		ArrayList<String> listaSucia=contenidoSucioFichero(fichero);
		ArrayList<Double> listaLimpia=new ArrayList<Double>();
		double numero=0;
		for(String elemento:listaSucia) {
			if(esConvertibleADouble(elemento)) {
				numero=Double.parseDouble(elemento);
				listaLimpia.add(numero);
			}	
		}
		return listaLimpia;
	}
	//COMPRUEBA SI EL STRING PASADO PUEDE CONVERTIRSE A DOUBLE
	public static boolean esConvertibleADouble(String s) {
	    boolean bandera = false;
	    if (s != null && !s.isBlank()) {//comprueba si un String está vacío o contiene solo espacios en blanco.
	        try {
	            Double.parseDouble(s);
	            bandera = true;
	        } catch (NumberFormatException e) {
	        	bandera = false;
	        }
	    }
	    return bandera;
	}
	
	
	
}
