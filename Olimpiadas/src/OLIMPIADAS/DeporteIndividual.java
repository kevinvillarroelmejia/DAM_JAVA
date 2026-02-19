package OLIMPIADAS;

import java.util.HashMap;

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
		HashMap<Participante, Double> copia = new HashMap<Participante, Double>();

		// 2.- BUSCAMOS EL MAYOR
		System.out.println("ORO");
		Participante p = obtenerMayor(copia);
		double marca = copia.get(p);

		// 3.- LO IMPRIMIMOS Y LO BORRAMOS
		// 3.1.-Comprobamos que no haya mas participantes con la misma marca.
		// Si los hay los sacamos tambien
		// 4.- REPETIMOS 2 Y 3(3.1) DOS VECES MAS
	}

	public Participante obtenerMayor(HashMap<Participante, Double> lista) {
		double mayor = -1;
		Participante pMayor = null;
		for (Participante p : lista.keySet()) {
			if (lista.get(p) > mayor) {
				mayor = lista.get(p);
				pMayor = p;
			}
		}

		return null;
	}

}
