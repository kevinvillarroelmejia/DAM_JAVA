package Boletin8;

import java.util.Scanner;

public class E7_NumeroArmstrong {

	public static void main(String[] args) {
		
//		7. EJERCICIO CON FORMATO DE EXAMEN
//		Un número es Armstrong cuando la suma de cada uno de los números que lo componen
//		elevado al número de dígitos de dicho número de dicho número da como resultado el propio
//		número.
//		Realiza un programa que, dado un número introducido por teclado, averigüe si es un número
//		Armstrong o Narcisista.
//		Ejemplo de un número de 3 dígitos: 153 ya que 13+53+33 = 1+125+27 = 153.
//		Todos los números de una cifra son narcisistas. De tres cifras tienes, además del anterior, el
//		370, el 371 y el 407 y de mas de tres cifras puedes probar con el 1634. No existen números
//		narcisistas de dos cifras.
//		Ejemplo de funcionamiento:
//		Introduce un número: 371
//		El número 371 es narcisista
//		No hace falta comprobaciones acerca de la entrada que siempre será un número entero.
		
		Scanner teclado=new Scanner(System.in);
		System.out.print("Introduce un numero: ");
		int numero=teclado.nextInt();
		if(numeroArmstrong(numero)) {
			System.out.println("El numero "+numero+" es Armstrong");
		}else {
			System.out.println("El numero "+numero+" es narcicista");
		}
		
	}
	public static boolean numeroArmstrong(int numero) {
		String numeroTexto=String.valueOf(numero);
		boolean bandera=false;
		int exponente=numeroTexto.length();
		int resultado=0;
		for(int i=0;i<numeroTexto.length();i++) {
			String e=String.valueOf(numeroTexto.charAt(i));
			int digito=Integer.valueOf(e);
			resultado=resultado+(int)Math.pow(digito, exponente);
		}
		if(resultado==numero) {
			bandera=true;
		}
		return bandera;
	}
}
