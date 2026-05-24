package Boletin7;

import java.util.Scanner;

public class E1_Calculadora {

	public static void main(String[] args) {

//		1. Vamos a hacer una pequeña calculadora. Solicita dos números al usuario y luego que
//		escriba la operación que quiere hacer (S para suma, R para resta, M para multiplicar y D
//		para dividir). Realiza la operación con un switch
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce numero 1:");
		int numero1 = teclado.nextInt();
		System.out.println("Introduce numero 2:");
		int numero2 = teclado.nextInt();

		teclado.nextLine();
		System.out.println("Que operacion quieres hacer: \n" 
		+ "S -> sumar\n" 
		+ "R -> restar\n" 
		+ "M -> multiplicar\n"
		+ "D -> dividir ");
		String operacion = teclado.nextLine().toUpperCase();
		int resultado = 0;
		switch (operacion) {
		case "S":
			resultado = numero1 + numero2;
			break;
		case "R":
			resultado = numero1 - numero2;
			break;
		case "M":
			resultado = numero1 * numero2;
			break;
		case "D":
			resultado = numero1 / numero2;
			break;
		}
		
		System.out.println("El resultado es "+resultado);
		
		

	}
}
