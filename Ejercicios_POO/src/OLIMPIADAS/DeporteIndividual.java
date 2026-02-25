package OLIMPIADAS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DeporteIndividual extends Deporte {

	private HashMap<Participante, Double> listaParticipantes = new HashMap<Participante, Double>();

	public DeporteIndividual(String nombreDeporte) {
		super(nombreDeporte);
	}

	public void resultado(Participante p, double marca) {
		if (listaParticipantes.containsKey(p)) {// preguntamos si ya esta la llave /objeto
			if (listaParticipantes.get(p) < marca) {// si menor que marcas metemos la nueva marca
				listaParticipantes.put(p, marca);
			}
		} else {
			listaParticipantes.put(p, marca);
		}
	}

	public void obtenerPodium() {
//		for(Participante p:listaParticipantes.keySet()) {
//			System.out.printf("%s - %.2f\n",p.getNombre(),listaParticipantes.get(p));
//		}
		System.out.printf("");
		// 1.- HACEMOS UNA COPIA DE LA LISTA
		HashMap<Participante, Double> copia = new HashMap<Participante, Double>(listaParticipantes);
		// 2.- BUSCAMOS EL MAYOR
		obtenerMedalla("ORO", copia);
		obtenerMedalla("PLATA", copia);
		obtenerMedalla("BRONCE", copia);

		// Participante p = obtenerMayor(copia);
		// double marca = copia.get(p);

		// 3.- LO IMPRIMIMOS Y LO BORRAMOS
		// 3.1.-Comprobamos que no haya mas participantes con la misma marca.
		// Si los hay los sacamos tambien
		// 4.- REPETIMOS 2 Y 3(3.1) DOS VECES MAS
	}

	public void obtenerMedalla(String medalla, HashMap<Participante, Double> copia) {
		System.out.println(medalla);
		if (copia.size() != 0) {
			Participante p = obtenerMayor(copia);
			double mayor = copia.get(p);
			System.out.printf("%s con %.2f puntos \n", p.getNombre(), mayor);
			copia.remove(p);
			// LO RECORREMOS CON UN ITERATOR POR QUE TENEMOS QUE BORRAR MIENTRAS QUE
			// RECORREMOS
			Iterator<Map.Entry<Participante, Double>> iterator = copia.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Participante, Double> elemento = iterator.next();
				if (elemento.getValue() == mayor) {
					System.out.printf("%s con %.2f puntos\n", elemento.getKey().getNombre(), mayor);
					// borramos el objeto
					iterator.remove();
				}
			}
		} else {
			System.out.println("No hay participantes en esta competicion");
		}
	}

	// BUSCAMOS EL MAYOR
	public Participante obtenerMayor(HashMap<Participante, Double> lista) {
		double mayor = -1;
		Participante pMayor = null;

		for (Participante p : lista.keySet()) {
			if (lista.get(p) > mayor) {
				mayor = lista.get(p);
				pMayor = p;
			}
		}

		return pMayor;
	}

}
