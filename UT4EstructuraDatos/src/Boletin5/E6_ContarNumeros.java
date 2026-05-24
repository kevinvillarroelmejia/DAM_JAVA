package Boletin5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E6_ContarNumeros {

	public static void main(String[] args) {
		
//		6. EJERCICIO CON FORMATO DE EXAMEN
//		Escribe un programa que nos permita contar el número de veces que se repite cada cifra
//		en un número. Por ejemplo, el número 885210003 tiene tres 0, un 1, un 2, un 5 y dos 8.
//		A continuación tienes un ejemplo de ejecución:
//		Introduce un número: 885210003
//		Tu número tiene:
//		2 números 8
//		1 número 5
//		1 número 3
//		1 número 2
//		3 números 0
//		Fíjate que en la salida no deben de aparecer las cifras que no tenga el número. También
//		que se distingue el caso en que sólo haya una aparición (la palabra número aparece en
//		singular en estos casos)
		
		
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		int numero=teclado.nextInt();
		String numeroTexto=String.valueOf(numero);
		HashMap<String, Integer> cantidadNumeroRepetidos=new HashMap<String, Integer>();
		for(int i=0;i<numeroTexto.length();i++) {
			 String numeroString=String.valueOf(numeroTexto.charAt(i));
			 if(cantidadNumeroRepetidos.containsKey(numeroString)) {
				 cantidadNumeroRepetidos.put(numeroString,cantidadNumeroRepetidos.get(numeroString)+1);
			 }else {
				 cantidadNumeroRepetidos.put(numeroString, 1);
			 }
		}
		for(Map.Entry<String, Integer> numeros:cantidadNumeroRepetidos.entrySet()) {
			if(numeros.getValue()==1) {
				System.out.println(numeros.getValue()+" numero "+numeros.getKey());
			}else {
				System.out.println(numeros.getValue()+" numeros "+numeros.getKey());
			}
			
		}
	}
}
