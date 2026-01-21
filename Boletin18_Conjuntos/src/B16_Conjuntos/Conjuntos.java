package B16_Conjuntos;
import java.util.HashSet;
public class Conjuntos {
	public static void main(String[] args) {
		HashSet<Integer> primerConjunto = new HashSet<Integer>();
		HashSet<Integer> segundoConjunto = new HashSet<Integer>();

		HashSet<Integer> union = new HashSet<Integer>();
		HashSet<Integer> interseccion = new HashSet<Integer>();

		Conjuntos.encontrarNumeroPrimo(primerConjunto);
		Conjuntos.encontrarNumeroPrimo(segundoConjunto);

		// Conjuntos.formatoString(primerConjunto);
		// Conjuntos.formatoString(segundoConjunto);
		
		System.out.println("Conjunto 1= " + primerConjunto);
		System.out.println("Conjunto 2= " + segundoConjunto);
		Conjuntos.unirHashSet(primerConjunto, segundoConjunto);
		Conjuntos.retainALL(primerConjunto, segundoConjunto);
	}

	public static void encontrarNumeroPrimo(HashSet<Integer> conjuntos) {
		int contador = 0;
		do {
			boolean esPrimo = true;
			int aletorio = (int) (Math.random() * 100) + 1;

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
		} while (conjuntos.size() != 10);
	}
	public static void unirHashSet(HashSet<Integer> conjuntos1, HashSet<Integer> conjuntos2) {
		//UNION
		conjuntos1.addAll(conjuntos2);
		System.out.println("Union: " + conjuntos1);
	}
	public static void retainALL(HashSet<Integer> conjuntos1, HashSet<Integer> conjuntos2) {
		//INTERSECCION
		conjuntos1.retainAll(conjuntos2);
				System.out.println("Interseccion: " + conjuntos1);
	}
}
