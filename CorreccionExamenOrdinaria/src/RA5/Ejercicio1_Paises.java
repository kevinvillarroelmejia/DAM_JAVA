package RA5;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ejercicio1_Paises {

	static String fichero="/home/alumno/Escritorio/paises.csv";
	public static void main(String[] args) {
		lectura1();
	}
	public static void lectura1() {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(fichero));
			String linea;
			String[] lineaLista=null;
			String paises="";
			String capitales="";
			lector.readLine();
			while ((linea = lector.readLine()) != null) {
				lineaLista=linea.split(",");
					paises=paises+lineaLista[0]+",";
			}
			System.out.println("Nombre: "+paises);
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
}
