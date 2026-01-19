package TeorioHashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TeorioHashSet {

	public static void main(String[] args) {

		//HashSet es un array dinamico
		/*TODO Pero no podemos meter elementos duplicados*/
		
		//Lo utilizamos cuando nos tenemos que eliminar lo duplicadoss
		
		//SI TENEMOS ELEMENTOS DUPLICADOS LOS VA ELIMINAR
		//LA RECUPERACION DE ELEMENTOS ES MUY RAPIDA
		//NO SE PUEDE RECUPERAR LOS ELEMENTOS POR POSICION
		
		//Utilizada para encontrar elementos muy rapidos
		
		HashSet<String> alumnnos=new HashSet<String>();
		
		//HashSet con elementos
		HashSet<String> profes=new HashSet<String>(Arrays.asList("Jose Maria Morales,Yago Navarrete"));
//		System.out.println("Profes "+profes);
//		System.out.println("Alumnos "+alumnnos);
		
		alumnnos.add("Alfonso Litario");
		alumnnos.add("Penelope giro");
		alumnnos.add("Kevin Villarroel");
		
		profes.add("Esteban Dolero");
		System.out.println("Profes "+profes);
		System.out.println("Alumnos "+alumnnos);
		
		profes.add("Esteban Dolero");//este esta repetido no lo añade tampoco da error
		System.out.println("Profes "+profes);
		
		/*El add si no entra da false*/
		
		//TODO La unica forma de borrar en un HashSet es por contenido
		alumnnos.remove("Penelope giro");
		System.out.println("Alumnos sin Penelope "+alumnnos);
		
		//TODO Para encontrar si un ELEMENTO ESTA O NO UTILIZAMOS contains
		if(profes.contains("Esteban Dolero")) {
			System.out.println("Esta en el grupo");
		}else {
			System.out.println("No esta en el grupo");
		}
		
		
		//TODO RECORIENDO UN HASHSET
		//y mostrar quitando la ultima coma
		int i=0;
		for(String alumno:alumnnos) {
			if(i!=alumnnos.size()-1) {
				System.out.print(alumno+", ");
			}else {
				System.out.print(alumno);
			}
			i++;
		}
		//convirtiendo
		System.out.println();
		//De un ArrayList a un HashSet
		ArrayList<Integer> numeroArrayList=new ArrayList<>(List.of(1,4,5,6,7,8,8,6,5,3,2,1,1,3,4,5,6,7,8,7));
		System.out.println("ArrayList normal duplicados "+numeroArrayList);
		
		//TODO Convirtiendo en un HashSet para eliminar duplicados
		HashSet<Integer> numerosConHashSet=new HashSet<Integer>(numeroArrayList);
		System.out.println("HashSet sin duplicados "+numerosConHashSet);

		numeroArrayList=new ArrayList<Integer>(numerosConHashSet);//lo duplica y lo hace independiente
		System.out.println("ArrayList sin duplicados "+numeroArrayList);
	
		//TODO OPERACIONES ENTRE CONJUNTOS
		HashSet<Integer> otrosNumeros=numerosConHashSet;//haciendo referencia
		System.out.println(otrosNumeros);
		otrosNumeros.remove(5);
		System.out.println(otrosNumeros);
		System.out.println(numerosConHashSet);
		
		//TODO OPERACION ENTRE Arrays en general
		/*UNION 
		 * Coje un conjunto coje el otro y los une y elimina los duplicados*/
		HashSet<Integer> conjunto1=new HashSet<Integer>(Arrays.asList(1,2,3,4,5,9));
		HashSet<Integer> conjunto2=new HashSet<Integer>(Arrays.asList(7,8,4,5));
		conjunto1.addAll(conjunto2); /*UNION*/
		System.out.println(conjunto1);
		
		/*INTERCECCION
		 *Coje los comunes y se queda con el que llama al metodo*/
		conjunto1.retainAll(conjunto2);
		System.out.println(conjunto1);
		
		/*DIFERENCIA
		 * */
		conjunto2.removeAll(conjunto1);
		System.out.println(conjunto2);
	}
}
