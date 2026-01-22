package B16_Conjuntos;
import java.util.Arrays;
import java.util.HashSet;
public class ConjuntosPrimos {
	public static void main(String[] args) {
		HashSet<Integer> primerConjunto = new HashSet<Integer>();
		HashSet<Integer> segundoConjunto = new HashSet<Integer>();

		HashSet<Integer> union = new HashSet<Integer>();
		HashSet<Integer> interseccion = new HashSet<Integer>();

		ConjuntosPrimos.encontrarNumeroPrimo(primerConjunto);
		ConjuntosPrimos.encontrarNumeroPrimo(segundoConjunto);

		// Conjuntos.formatoString(primerConjunto);
		// Conjuntos.formatoString(segundoConjunto);
		
		System.out.println("Conjunto 1= " + primerConjunto);
		System.out.println("Conjunto 2= " + segundoConjunto);
		ConjuntosPrimos.unirHashSet(primerConjunto, segundoConjunto);
		ConjuntosPrimos.retainALL(primerConjunto, segundoConjunto);
		
		
		/*TODO -------------------------------------------------*/
		HashSet<Integer> conjunto1=devuelveConjuntosPrimos();
		HashSet<Integer> conjunto2=devuelveConjuntosPrimos();
		HashSet<Integer> union1=new HashSet<Integer>(conjunto1);
		HashSet<Integer> interseccion1=new HashSet<Integer>(conjunto1);
		union1.addAll(conjunto2);
		ordenarConjunto(union1);
		interseccion.retainAll(conjunto2);
		ordenarConjunto(interseccion1);

	}
	//TODO FUNCIONES DEL PROFE
	public static boolean esPrimo(int n) {
		boolean primo =true;
		int raiz=(int)Math.sqrt(n)+1;
		if(n%2!=0) {
			
		}
		
		return primo;
	}
	public static HashSet<Integer> devuelveConjuntosPrimos() {
		HashSet<Integer> conjunto= new HashSet<Integer>();
		while(conjunto.size()!=10) {
			int numero=(int)(Math.random()*100)+1;
			if(esPrimo(numero)) {
				conjunto.add(numero);
			}
		}
		return conjunto;
	}
	public static void  ordenarConjunto(HashSet<Integer> conjunto) {
		int[] vector=new int[conjunto.size()];
		int i=0;
		for(int n:conjunto) {
			vector[i]=n;
			i++;
		}
		Arrays.sort(vector);//importar
		for(int n:vector) {
			System.out.println(n+", ");
		}
	}

	//TODO MIS FUNCIONES
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
	public static void sinComillas(HashSet<Integer> primo) {
		int i=0;
		for(Integer n:primo) {
			if(i==primo.size()-1) {
				System.out.println(n);
			}else {
				System.out.println(n+",");
			}
			i++;
		}
	}
	
}
