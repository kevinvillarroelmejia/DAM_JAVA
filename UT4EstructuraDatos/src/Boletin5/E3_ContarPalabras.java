package Boletin5;

import java.util.ArrayList;
import java.util.Scanner;

public class E3_ContarPalabras {

	public static void main(String[] args) {
		
		
//		3. Escribir un programa que cuenta las palabras que tiene una frase introducida
//		previamente por teclado. Las palabras pueden estar separadas por más de un espacio
//		pero siempre debe de haber al menos uno. No tenemos en cuenta los signos de
//		puntuación como separadores.
		Scanner teclado=new Scanner(System.in);
		String frase=teclado.nextLine();		
		System.out.println("Haz escrito "+contadorPalabrasMejorado(frase)+" palabras");

		
	}
	public static int contadorPalabrasMejorado(String frase) {
		//separa por uno o más espacios
		//quita espacios al inicio y final
		String[] palabras=frase.trim().split("\\s+");
		return palabras.length;
	}
	
	public static int contarPalabras(String frase) {
		ArrayList<String> listaPalabras=new ArrayList<String>();
		String palabra = "";
		//recorro
		for(int i=0;i<frase.length();i++) {
			//si es diferente a un guardo letra a letra en la variable
			if(frase.charAt(i)!=' ') {
				palabra=palabra+frase.charAt(i);
			}else {
				//si es igual a un espacio guardo la palabra entera y reasigno la variable
				listaPalabras.add(palabra);
				palabra="";
			}
		}
		//esto es para la ultima palabra si es palabra no es ta vacia lo añade
		if (!palabra.isEmpty()) {
		    listaPalabras.add(palabra);
		}
		return listaPalabras.size();
	}
	
	
	
}
