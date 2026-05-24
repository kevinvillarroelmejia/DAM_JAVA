package Boletin5;

import java.util.Map;
import java.util.TreeMap;

public class E5_numeroMasRepetido {

	public static void main(String[] args) {
		
//		5. Escribe un programa que genere 100 números aleatorios comprendidos entre el 1 y 50
//		(ambos inclusive) y, posteriormente, obtenga el mayor, el menor y el que mas veces se
//		repite (y nos diga cuantas veces lo hace)
		
//		hacerlo con hashMap donde la clave es el numero azar y el valor es el numero de veces que sale
		
		TreeMap<Integer, Integer> numeroAletorios=new TreeMap<Integer, Integer>();
		for(int i=0;i<100;i++)	{
			int azar=(int)(Math.random()*50)+1;
			if(numeroAletorios.containsKey(azar)) {
				numeroAletorios.put(azar, numeroAletorios.get(azar)+1);
			}else {
				numeroAletorios.put(azar, 1);
			}
			
		}
		int masRepetido=0; //valor
		int claveMasRepetido=0;//clave 
		for(Map.Entry<Integer, Integer> numeros:numeroAletorios.entrySet()) {
			System.out.println("La clave "+numeros.getKey()+" valor "+numeros.getValue());
			if(numeros.getValue()>masRepetido) {
				masRepetido=numeros.getValue();//recogiendo el valor mas grande
				claveMasRepetido=numeros.getKey();//junto con su clave
			}
		}
		//COMO TreeMap va en orden por clave podemos utilizar firstKey y lastKey
		System.out.println("El menor es: "+numeroAletorios.firstKey());
		System.out.println("EL mayor es "+numeroAletorios.lastKey());
		System.out.println("El mas repetido es "+claveMasRepetido+" con "+masRepetido+" repeticiones");
	}
	
	
	

}
