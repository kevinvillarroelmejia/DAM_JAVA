package Boletin7;

import java.util.Scanner;

public class E6_posicionMayorMenor {

	public static void main(String[] args) {
//		6. Modifica el ejercicio anterior para que, nos muestre en que posición del array se
//		encuentran el máximo y el mínimo. Si están repetidos y aparecen en mas de una
//		posición debería de indicarlas todas

		Scanner teclado = new Scanner(System.in);
		System.out.println("Tamaño Array");
		int tamano = teclado.nextInt();
		int[] listaNumeros = new int[tamano];
		int mayor = 0;
		int menor = Integer.MAX_VALUE;
		int total = 0;
		
		int posicionMenor=0;
		int posicionMayor=0;
		for (int i = 0; i < tamano; i++) {
			int azar = (int) (Math.random() * (1000 - 10 + 1) + 10);
			listaNumeros[i] = azar;
			if (azar > mayor) {
				mayor = azar;
				posicionMayor=i;
			}
			if(azar<menor) {
				menor=azar;
				posicionMenor=i;
			}
			total = total + azar;
		}
		double media=(double)total/listaNumeros.length;
		for(int numero:listaNumeros) {
			System.out.println(numero);
		}
		System.out.printf("El mayor es: %d en la posicion: %d\nEl menor es:%d en la posicion %d \nY la media Aritmetica es: %.2f",mayor,posicionMayor,menor,posicionMenor,media);
	}
}
