package algoritmoBusquedas;

import java.util.ArrayList;
import java.util.List;

public class algoritmosDeBusqueda {

	public static void main(String[] args) {
		ArrayList<Integer> listaNumeros = new ArrayList<Integer>(List.of(7, 5, 1, 3, 14, 5, 4, 6));

		porParejas(listaNumeros);

//		ArrayList<Integer> ordenadaSeleccion = ordenacionSeleccion(listaNumeros);
//		System.out.println(ordenadaSeleccion);
//		
//		ArrayList<Integer> ordenacionBurguja=ordenacionBurbuja(listaNumeros);
//		System.out.println(ordenacionBurguja);

	}

	// queremos una columna para ver la lista de dos en dos
	// 7,1
	// 1,3
	// 3,5
	// 5,4
	// 4,6
	public static ArrayList<Integer> porParejas(ArrayList<Integer> desordenada) {
//		ArrayList<Integer> listaPorParejas = new ArrayList<Integer>();
		boolean hayCambios = true;
		while (hayCambios == true) {
			hayCambios = false;
			for (int i = 0; i < desordenada.size() - 1; i++) {
				if (desordenada.get(i + 1) > desordenada.get(i)) {
					int eliminado = desordenada.remove(i);
					desordenada.add(i + 1, eliminado);
					hayCambios=false;
				}
			}
		}
		System.out.print(desordenada+"\n");
		return desordenada;

	}

	public static ArrayList<Integer> ordenacionBurbuja(ArrayList<Integer> listaNumeros) {
		ArrayList<Integer> listaOrdenada = new ArrayList<Integer>();

		return listaOrdenada;
	}

	public static ArrayList<Integer> ordenacionSeleccion(ArrayList<Integer> listaDesordenada) {
		ArrayList<Integer> listaOrdenada = new ArrayList<Integer>();
		while (listaDesordenada.size() != 0) {
			int mayor = -1;
			for (int n : listaDesordenada) {
				if (n > mayor) {
					mayor = n;
				}
			}
			listaDesordenada.remove((Integer) mayor);
			listaOrdenada.add(mayor);
		}
		return listaOrdenada;
	}

}
