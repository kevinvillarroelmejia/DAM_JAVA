package colecciones;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class collections {

	public static void main(String[] args) {
		// es otra coleccion
		/*
		 * sirve para utilizar metodos que arrayList no tiene sobretodo de ordenacion
		 * cambio de orden
		 * 
		 */

		ArrayList<Integer> numero = new ArrayList<>();
		ArrayList<String> alumnos = new ArrayList<String>();

		Collections.addAll(numero, 44, 56, 1, 2, 55, 7, 3, 3, 44, 2, 89, 2, 120, 45);
		Collections.addAll(alumnos, "Lucian", "Marcos", "Sara", "Alejandro");
		System.out.println(numero);
		System.out.println(alumnos);

		// PARA ORDENAR
		Collections.sort(numero);
		Collections.sort(alumnos);
		System.out.println(numero);
		System.out.println(alumnos);

		// ORDEN TOTALMENTE ALETORIO
		Collections.shuffle(numero);
		Collections.shuffle(alumnos);
		System.out.println(numero);
		System.out.println(alumnos);

		// Darle la vuelta a la lista
		Collections.reverse(alumnos);
		Collections.reverse(numero);
		System.out.println(numero);
		System.out.println(alumnos);

		// Este si se puede meter en un syso el max y alumno de la lista
		System.out.println(Collections.max(alumnos) + " - " + Collections.min(numero));

		// Numero de veces que sale un elemento en la lista
		System.out.println(Collections.frequency(numero, 3));

		// Buscar de la ubicacion de un elemento de una forma MUY rapida
		// SOLO FUNCIONA SI LA COLECCION ESTA ORDENADO
		ArrayList<Integer> numeroOrdenados = new ArrayList<Integer>();
		Collections.addAll(numeroOrdenados, 44, 56, 1, 2, 55, 7, 5, 443, 3, 44, 2, 89, 2, 120, 45);
		Collections.sort(numeroOrdenados);
		// SOLO FUNCIONA SI LA COLECCION ESTA ORDENADO
		System.out.println("Posicion: "+Collections.binarySearch(numeroOrdenados, 2));
		
		
		
		
	}
}
