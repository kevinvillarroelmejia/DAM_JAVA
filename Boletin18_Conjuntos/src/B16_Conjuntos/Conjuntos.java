package B16_Conjuntos;

import java.util.HashSet;

public class Conjuntos {

	public static void main(String[] args) {

		HashSet<Integer> primerConjunto = new HashSet<Integer>();
		HashSet<Integer> segundoConjunto = new HashSet<Integer>();
		
		Conjuntos.encontrarNumeroPrimo(primerConjunto);

		


	}
	public static void encontrarNumeroPrimo(HashSet<Integer> conjuntos) {
		int contador = 0;
		do {
		    boolean esPrimo = true;
			int aletorio=(int)(Math.random()*100)+1;		

		    if (aletorio < 2) {
		        esPrimo = false;
		    } else {
		        int raiz = (int) Math.sqrt(aletorio);
		        for (int i = 2; i <= raiz; i++) {
		            if (aletorio % i == 0) {
		                esPrimo = false;
		            }
		        }
		    }
		    if (esPrimo) {
		    	conjuntos.add(aletorio);
		        contador++;
		    }
		}while (conjuntos.size()!=10);
		System.out.println(conjuntos);
	}
	public void im
}
