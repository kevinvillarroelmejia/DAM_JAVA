package P1;

import java.util.Scanner;

public class B1_5_ScannerPar_Impar {

	public static void main(String[] args) {

		// ===============EJERCICIO 5==============================
		// Escribir un programa que pida por teclado un número al usuario y diga si es
		// par o impar

		Scanner parImpar = new Scanner(System.in);
		System.out.print("Pasa un numero y te dire es PAR O IMPAR: ");
		int num;
		num = parImpar.nextInt();
		if (num % 2 == 0) {
			System.out.println("Tu numero " + num + " es par"); // PREGUNTA??? en este
//		 print en ves de meter la variable num meti el objeto parImpar por que da ese
//		 error
		} else {
			System.out.println("No es par :(");
		}

	}
}
