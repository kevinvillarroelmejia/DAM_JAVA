package Boletin24_FicherosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejercicio3_Fibonacci {

	public static void main(String[] args) {
		String rutaFichero = "D:\\IES FRANCISCO DE GOYA\\DAM\\PROGRAMACION\\fibonacci.txt";
		ficheroFibonacci(rutaFichero, 3);
		leerFibonacci(rutaFichero);
	}

	public static void ficheroFibonacci(String rutaFichero, int cantidadNumeros) {
		try (FileWriter escritor = new FileWriter(rutaFichero)) {
			int num0 = 0;
			int num1 = 1;
			if (cantidadNumeros < 2) {
				System.out.println("Error la cantidad tiene que ser mayor a 2");
			} else {
				for (int i = 0; i < cantidadNumeros; i++) {
					if (i < cantidadNumeros - 1) {
						escritor.write(num0 + ", ");
					} else {
						escritor.write("" + num0);
					}
					int nuevo = num1 + num0;
					num0 = num1;
					num1 = nuevo;
				}
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void leerFibonacci(String rutaFichero) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaFichero));
			String linea;
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
}
