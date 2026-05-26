package Boletin18;

import java.util.HashSet;
import java.util.TreeSet;

public class E1_ConjuntosPrimos {

	public static void main(String[] args) {

		TreeSet<Integer> conjunto1 = new TreeSet<Integer>();
		TreeSet<Integer> conjunto2 = new TreeSet<Integer>();
		// AÑADE NUMEROS PRIMOS
		encontrarNumeroPrimo(conjunto1);
		encontrarNumeroPrimo(conjunto2);

		System.out.println("Conjunto 1 :" + conjunto1);
		System.out.println("Conjunto 2 :" + conjunto2);

		// UNION SE QUEDA CON TODOS DEL OTRO
		TreeSet<Integer> union = new TreeSet<Integer>(conjunto1); // hacemos una copia para no modificar el anterior
		union.addAll(conjunto2);
		System.out.println("Union de conjuntos: " + union);

		TreeSet<Integer> interseccion = new TreeSet<Integer>(conjunto1);
		// INTERSECCION se queda solo con los que están en ambos
		interseccion.retainAll(conjunto2);
		System.out.println("INTERSECCION : " + interseccion);

		TreeSet<Integer> restoNumPrimos = new TreeSet<Integer>();
		numerosPrimosDel1Al100(restoNumPrimos);
		restoNumPrimos.removeAll(conjunto1);
		restoNumPrimos.removeAll(conjunto2);
		System.out.println("Resto numeros primos: " + restoNumPrimos);

	}
	//VERIFICANDO SI EL NUMERO ES PRIMO primo
	public static boolean esPrimo(int numero) {
	    boolean esPrimo = true;
	    if (numero < 2) {
	        esPrimo = false;
	    } else {
	        int raiz = (int) Math.sqrt(numero);
	        for (int i = 2; i <= raiz; i++) {
	            if (numero % i == 0) {
	                esPrimo = false;
	            }
	        }
	    }
	    return esPrimo;
	}

	public static void encontrarNumeroPrimo(TreeSet<Integer> conjuntos) {
		do {
			int aletorio = (int) (Math.random() * 100) + 1;
			if (esPrimo(aletorio)) {
				conjuntos.add(aletorio);
			}
		} while (conjuntos.size() != 10);
	}

	public static void numerosPrimosDel1Al100(TreeSet<Integer> conjuntos) {
        for (int i = 2; i <=100; i++) {
			if(esPrimo(i)) {
				conjuntos.add(i);
			}
        }
	}
}
