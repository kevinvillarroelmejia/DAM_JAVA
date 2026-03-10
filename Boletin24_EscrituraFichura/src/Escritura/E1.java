package Escritura;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class E1 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un numero entre el 1 y 10");
		int numero = teclado.nextInt();
		boolean bandera = false;
		do {
			if (numero > 0 && numero <= 10) {
				bandera = true;
			} else {
				System.out.println("NUMERO FUERA DE RANGO");
				System.out.println("Vuelve a introducir un numero");
				numero = teclado.nextInt();
			}
		} while (bandera == false);
		try (PrintWriter pluma = new PrintWriter(new FileWriter("/home/alumno/Escritorio/tablas.txt"))) {
			for (int i = 1; i <= 10; i++) {
				pluma.printf("%d x %2d = %3d\n", numero, i, numero * i); //con formato alineando las columnas %2d dos numeros a la izquierda
				//%3d 3 numeros a la izquierda
			}
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
		}

//		boolean bandera=false;
//
//		while(bandera==false) {
//			if (numero<0||numero>=10)	{
//				System.out.println("ERROR fuera del rango");
//			}else {
//				System.out.println("Numero admitido");
//				bandera=true;
//			}
//			System.out.println("Vuelve a introducir un numero valido");
//			numero=teclado.nextInt();
//		}
	}

	public static void escribir3() {
		try (PrintWriter pluma = new PrintWriter(
				new FileWriter("/home/alumno/Escritorio/ficheroEscritura.txt", true))) {
			pluma.print("Primera linea.");
			pluma.println("Sigo en la segunda linea y salto"); // lo unico que hace es que este tiene un salto de linea
			pluma.println("Segunda linea ");
			String nombre = "Ana";
			String apellido = "Campos Moro";
			int edad = 27;
			double sueldo = 1200;
			pluma.printf("NOMBRE: %s ,%s. EDAD: %d. SUELDO: %.2f", nombre, apellido, edad, sueldo);
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
		}
	}
}
