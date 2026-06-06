package Boletin24_FicherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio1_2_TablasMultiplicar {

	static String ficheroRuta = "/home/alumno/Escritorio/tabla-n.txt";

	public static void main(String[] args) {

		// TODO --- EJERCICIO 1 ---
		Scanner teclado = new Scanner(System.in);
		System.out.println("Numero tabla multiplicar: ");
		int numero = teclado.nextInt();
		escribirTabla(numero);
		leerTablaFichero(numero);
	}

	public static void escribirTabla(int numeroTabla) {
		// Para AÑADIR al final: segundo parámetro true
		String nombreFichero = String.format("tabla-%d.txt", numeroTabla);
		try (FileWriter escritor = new FileWriter("/home/alumno/Escritorio/" + nombreFichero)) {
			for (int i = 1; i <= 10; i++) {
				escritor.write(String.format("%2d x %2d = %3d\n", numeroTabla, i, numeroTabla * i));
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void leerTablaFichero(int numeroTabla) {
		String rutaFichero = "/home/alumno/Escritorio/tabla-" + numeroTabla + ".txt";
		File existenciaFichero = new File(rutaFichero);
		if (existenciaFichero.exists()) {
			try {
				BufferedReader lector = new BufferedReader(new FileReader(rutaFichero));
				String linea;
				// COMPROBACION SI EXISTE UN FICHERO
				while ((linea = lector.readLine()) != null) {
					System.out.println(linea);
				}
				lector.close();
			} catch (Exception e) {
				System.out.println("Error al leer: " + e.getMessage());
			}
		} else {
			System.out.println("El fichero no existe");

		}
	}
}
