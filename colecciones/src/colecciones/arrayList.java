package colecciones;

import java.util.ArrayList;
import java.util.List;

public class arrayList {

	public static void main(String[] args) {

		//TODO ARRAY LIST ES DINAMICO
		ArrayList<String> texto= new ArrayList<>();//Array de tipo texto
		ArrayList<String> texto2= new ArrayList<String>();//esto es lo mismo
		
		//Array list de nuemeros dobles/decimales
		ArrayList<Double> decimales= new ArrayList<>();
		//Array list de nuemeros enteros
		ArrayList<Integer> enteros= new ArrayList<>(List.of(23,45,2,65));
		
		//Array con contenido List.of se tiene que importar
		ArrayList<Double>precios=new ArrayList<Double>(List.of(33.5,555.3,175.9));
				
		//añadir Elementos al ArrayList
		texto.add("Hola mundo");
		decimales.add(9.6);
		enteros.add(2);
		precios.add(3.14);
		
		//RECUPERAR/COGER ELEMENTOS DE LA LISTA
		double e1=precios.get(1);
		
		//Saber el tamaño de un Array
		System.out.println(precios.size());//4
		System.out.println(precios);

		//encontrar elementos
		ArrayList<String> alumnos= new ArrayList<>(List.of("Jaime,Adrian,Oscar,Lucia"));
		if(alumnos.contains("Lucia")) {
			System.out.println("Esta en la lista");
		}else {
			System.out.println("no esta en la lista");
		}
		
		
		//POSICION DEL ELEMENTO
		//si esta repetido te devuelve el primero
		int posicion=alumnos.indexOf("Lucia");//si no lo encuentra devuelve -1
		
		//Para saber el ultimo repetido
		int ultimaPosicion=alumnos.lastIndexOf("Oscar");
		
		//como eliminar elementos -- eliminar la primera lucia -- 
		//-- si no lo elimina devuelve un false
		alumnos.remove("Lucia");
		
		//eliminar por posicion -- elimino oscar
//		System.out.println(alumnos.remove(1));//aqui da error
		
		System.out.println(enteros.remove((Integer)3));
		
		//Inicializar un ArrayList
		enteros.clear();
		
		//preguntar si esta vacia
		if(enteros.isEmpty()) {
			System.out.println("El Array List esta vacio");
		}
		
		//hacer una copia de un Array
		ArrayList alumnos2=(ArrayList)alumnos.clone();
		
		
		//Lista INMUTABLE
		List<Integer> enteros2= List.of(23,45,2,65);

	}
}
