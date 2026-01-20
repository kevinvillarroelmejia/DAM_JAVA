package TeorioHashSet;

import java.util.HashSet;

public class primitivaConHashSet {

	public static void main(String[] args) {

		/*Generar numero aletorios entre el 1 y el 49 sin ser repetidos*/
		HashSet<Integer> primitiva=new HashSet<Integer>();
		while(primitiva.size()!=6) {
			int aletorio=(int)(Math.random()*49)+1;
				primitiva.add(aletorio);
		}
		System.out.println(primitiva);
		
	}
}
