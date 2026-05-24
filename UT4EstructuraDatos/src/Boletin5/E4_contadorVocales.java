package Boletin5;

import java.util.HashSet;
import java.util.Scanner;

public class E4_contadorVocales {

	public static void main(String[] args) {

		// ================ejercicio
		// 4====================================================
		// Escribir un programa que nos pida una cadena por teclado y luego cuente
		// cuantas
		// palabras hay en ella con cuatro o más vocales diferentes. Por ejemplo, si
		// introducimos
		// la frase “Crisis constitucional por culpa del murcielago guineoecuatorial”
		// Nos debería
		// de decir que 3. Tendrías que tener en cuenta que las vocales pueden ir en
		// mayúsculas
		// o no y son la misma letra. Presupón que ninguna vocal va acentuada de ninguna
		// forma
		Scanner teclado = new Scanner(System.in);
		String frase = teclado.nextLine();
		String[] palabras = frase.trim().split("\\s+");
		int contadorPalabras = 0;

		// recorremos el array de solo palabras
		for (String palabra : palabras) {
			// Character == char
			HashSet<Character> vocales = new HashSet<>();
			for (int i = 0; i < palabra.length(); i++) {
				char letra = Character.toLowerCase(palabra.charAt(i));
				// si la palabra es igual a una vocal
				if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
					// lo añadimos al HashSet de tipo char
					vocales.add(letra);
				}
			}
			// si el HashSet es de tamaño 4... y se vuelve a crear un HashSet nuevo con
			// comparando la siguiente palabra
			if (vocales.size() >= 4) {
				contadorPalabras++;
			}

			System.out.println(contadorPalabras);
		}
	}
}
