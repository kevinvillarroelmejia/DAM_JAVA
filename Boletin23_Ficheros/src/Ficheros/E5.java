package Ficheros;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class E5 {

	public static void main(String[] args) {

		System.out.println("Hombres: "+contarHombres());
		System.out.println("Mujeres: "+ contarMujeres());
		System.out.printf("Estatura media: %.2f\n ",estaturaMedia());
	}
	
	public static int contarHombres() {
		ArrayList<String> lineas=null;
		int hombre=0;

		try {
			Path fichero=Path.of("/home/alumno/estadisticas.txt");
			lineas=(ArrayList<String>)Files.readAllLines(fichero);
			for(String linea:lineas) {
				if(linea.equalsIgnoreCase("hombre")) {
					hombre++;
				}
			}
		} catch (Exception e) {
			System.out.println("--ERROR--"+e.getMessage());
		}
//		if(lineas!=null) {
//			System.out.println("Fichero vacio");
//		}
		return hombre;
	}
	public static int contarMujeres() {
		int mujer=0;
		ArrayList<String> lineas=null;
		try {
			Path fichero=Path.of("/home/alumno/estadisticas.txt");
			lineas=(ArrayList<String>)Files.readAllLines(fichero);
			for(String linea:lineas) {
				if(linea.equalsIgnoreCase("mujer")) {
					mujer++;
				}
			}
		} catch (Exception e) {
			System.out.println("--ERROR--"+e.getMessage());
		}
		if(lineas!=null) {
			System.out.println(lineas);
		}
		
		return mujer;
	}
	public static double estaturaMedia() {
		double alturaMedia=0.0;
		ArrayList<String> lineas=null;

		try {
			Path fichero=Path.of("/home/alumno/estadisticas.txt");
			lineas=(ArrayList<String>)Files.readAllLines(fichero);
			for(String linea:lineas) {
				if(!linea.equalsIgnoreCase("hombre")&&!linea.equalsIgnoreCase("mujer")) {
					alturaMedia+=Double.parseDouble(linea);
				}
			}
		} catch (Exception e) {
			System.out.println("--ERROR--"+e.getMessage());
		}
		double media=alturaMedia/(contarHombres()+contarMujeres());
		return media;
	}

}
