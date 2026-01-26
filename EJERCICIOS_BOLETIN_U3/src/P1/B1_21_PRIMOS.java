package P1;

import java.util.Scanner;

public class B1_21_PRIMOS {

	public static void main(String[] args) {
		
		//===============EJERCICIO 21==============================
		//Escribir un programa que pida por teclado un número al usuario y calcule si es primo o no
		//numero primo es SOLo divisible entre 1 y el mismo numero y ningun otro
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		int num = teclado.nextInt(); // leemos el número del usuario
		teclado.close();
		boolean esPrimo = true; // bandera que indica si el número es primo o no
		// Los números menores o iguales a 1 no son primos
		if (num <= 1) {
			esPrimo = false;
		} else {
			// Recorremos desde 2 hasta la raíz cuadrada del número
			// Si encontramos un divisor, ya no es primo
			for (int i = 2; i <= Math.sqrt(num) && esPrimo; i++) {
				if (num % i == 0) { // si el resto es 0, significa que es divisible
					esPrimo = false; // marcamos que no es primo
				}
			}
		}
		// Mostramos el resultado final
		if (esPrimo) {
			System.out.println(num + " es primo");
		} else {
			System.out.println(num + " no es primo");
		}

	}
}
