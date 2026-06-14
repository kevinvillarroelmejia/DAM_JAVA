package RA5_FicherosTexto;

import java.io.BufferedReader;
import java.io.FileReader;

public class E2_Biblioteca {

	public static void main(String[] args) {
		String fichero = "biblioteca.csv";
		lectura1(fichero);
	}

	public static void lectura1(String fichero) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(fichero));
			String linea;
			String[] lista = new String[4];
			int novela = 0;
			int terror = 0;
			int cienciaFiccion = 0;
			int historia = 0;
			int fantasia = 0;
			int masAntiguo = Integer.MAX_VALUE;
			;
			int masReciente = 0;
			String[] libroAntiguo = new String[4];
			String[] libroReciente = new String[4];
			while ((linea = lector.readLine()) != null) {
				lista = linea.split(";");
				if (lista[2].equalsIgnoreCase("Novela")) {
					novela++;
				} else if (lista[2].equalsIgnoreCase("Terror")) {
					terror++;
				} else if (lista[2].equalsIgnoreCase("Ciencia ficcion")) {
					cienciaFiccion++;
				} else if (lista[2].equalsIgnoreCase("historia")) {
					historia++;
				} else if (lista[2].equalsIgnoreCase("fantasia")) {
					fantasia++;
				}
				int fechaAntiguo = Integer.parseInt(lista[3]);

				if (masAntiguo > fechaAntiguo) {
					libroAntiguo = lista;
					masAntiguo = fechaAntiguo;
				}
				int fechaReciente = Integer.parseInt(lista[3]);
				if (fechaReciente > masReciente) {
					masReciente = fechaReciente;
					libroReciente = lista;
//					libroReciente = lista.clone();
				}
			}
			System.out.println("-- LIBROS POR GENERO --");
			System.out.println("Novela " + novela);
			System.out.println("Terror " + terror);
			System.out.println("Cienca ficcion " + cienciaFiccion);
			System.out.println("Historia " + historia);
			System.out.println("Fantasia " + fantasia);
			System.out.println();
			System.out.println("Libro mas antiguo: " + libroAntiguo[0] + "(" + libroAntiguo[1] + ")" + libroAntiguo[3]);
			System.out.println(
					"Libros mas reciente: " + libroReciente[0] + "(" + libroReciente[1] + ")" + libroReciente[3]);
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
