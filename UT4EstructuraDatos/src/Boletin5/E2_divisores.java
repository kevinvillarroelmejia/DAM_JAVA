package Boletin5;

import java.util.Scanner;

public class E2_divisores {

	public static void main(String[] args) {

		/*
		 * 2. Hacer un programa en que nos permita calcular todos los divisores comunes a dos
			números
		 * */
		Scanner teclado=new Scanner(System.in);
		System.out.println("Numero uno:  ");
		int numero1=teclado.nextInt();
		
		System.out.println("Numero dos:  ");
		int numero2=teclado.nextInt();
		int nPequeno=Math.min(numero1, numero2);
		
	
		System.out.println("Los numero elgidos son "+numero1+" y "+numero2);
		for(int i=1;i<=nPequeno;i++) {
			if(numero1%i==0 && numero2%i==0) {
				System.out.println(i+" es un numero comun");
			}
		}
	}
}
