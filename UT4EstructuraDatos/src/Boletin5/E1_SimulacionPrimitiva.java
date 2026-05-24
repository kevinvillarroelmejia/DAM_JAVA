package Boletin5;

import java.util.ArrayList;

public class E1_SimulacionPrimitiva {

	public static void main(String[] args) {
		
		/*
		 * 1. Escribir un programa que genere seis números aleatorios entre el 1 y el 49 sin que
			ninguno de ellos esté repetido (simulando una lotería primitiva).
		 * 
		 * */
		
		ArrayList<Integer> privimiva=new ArrayList<Integer>();
		do {
			int numeroAzar=numeroAleatorio();
			if(!privimiva.contains(numeroAzar)) {
				privimiva.add(numeroAzar);
			}
		}while(privimiva.size()!=48);
		for(int numero:privimiva) {
			System.out.println(numero);
		}
	}
	public static int numeroAleatorio() {
		int azar=(int)(Math.random()*49)+1;
		return azar;
	}
	
	
	
}
