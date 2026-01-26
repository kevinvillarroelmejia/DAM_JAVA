package P1;

import java.util.Scanner;

public class B1_14_NumAletorioEntreDosRangos {

	public static void main(String[] args) {

		// ===============EJERCICIO 14==============================
		// Escribir un programa que nos pida dos números por teclado y genere un número
		// aleatorio
		// comprendido entre ambos. Por el momento no te preocupes de que el primer
		// número
		// siempre debería de ser menor que el segundo, simplemente no los metas en un
		// orden
		// incorrecto.
		Scanner entrada = new Scanner(System.in);
		System.out.print("Primer numero --> ");
		int numero1 = entrada.nextInt();
		System.out.print("Segundo numero --> ");
		int numero2 = entrada.nextInt();
		// siempre el mas grande - el mas pequeño +1 y le sumas el mas pequeño
		int aleatorio = (int) (Math.random() * (numero2 - numero1 + 1) + numero1); // generacion de un numero entre dos																	// numeros
		System.out.println("EL NUMERO ALETARIO ENTRE" + numero1 + " y " + numero2 + " ES " + aleatorio);

	}

}
