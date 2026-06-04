package ordinaria9;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio1_RA6 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Texto a analizar: ");
		String frase = teclado.nextLine();
		String[] listaFrase = listaPalabras(frase); // array de palabras
		TreeMap<String, Integer> diccionarioPalabras = new TreeMap<String, Integer>();
		for (String palabras : listaFrase) {
			if (diccionarioPalabras.containsKey(palabras)) {
				diccionarioPalabras.put(palabras, diccionarioPalabras.get(palabras) + 1);
			} else {
				diccionarioPalabras.put(palabras, 1);
			}
		}
		System.out.println();
		System.out.println("Total de palabras: " + listaFrase.length);
		System.out.println();
		System.out.println("Palabas repetidas mas de una vez: ");
		for (Map.Entry<String, Integer> palabras : diccionarioPalabras.entrySet()) {
//			System.out.println(palabras.getKey() + ":" + palabras.getValue());
			if(palabras.getValue()>1) {
				System.out.println(palabras.getKey().toUpperCase()+" : "+palabras.getValue()+" veces");
			}
		}
		double totalLongitudMedia=0;
		for(String palabra:listaFrase) {
			totalLongitudMedia=totalLongitudMedia+palabra.length();
		}
		totalLongitudMedia=(totalLongitudMedia/listaFrase.length);
		System.out.printf("Longitud media de las palabras del texto: %.2f\n",totalLongitudMedia);
		System.out.println();
		
		
		
	}

	public static String[] listaPalabras(String frase) {
		String[] palabras = frase.trim().split("\\s+");
		return palabras;
	}

	/*
	 * for(Map.Entry<Integer, Integer> numeros:numeroAletorios.entrySet()) {
	 * System.out.println("La clave "+numeros.getKey()+" valor "+numeros.getValue())
	 * ; if(numeros.getValue()>masRepetido) {
	 * masRepetido=numeros.getValue();//recogiendo el valor mas grande
	 * claveMasRepetido=numeros.getKey();//junto con su clave } }
	 * 
	 */
}
