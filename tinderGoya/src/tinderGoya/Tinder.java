package tinderGoya;

import java.util.ArrayList;
import java.util.HashSet;

public class Tinder {
	private HashSet<Hombre> listaDeHombres = new HashSet<Hombre>();
	private HashSet<Mujer> listaDeMujeres = new HashSet<Mujer>();
	private HashSet<NoDefinido> listaDeNoDefinidos = new HashSet<NoDefinido>();

	public Tinder() {

	}

	// añade hombre a la lista
	public void ayade(Hombre hombre) {
		listaDeHombres.add(hombre);
	}

	public void ayade(Mujer mujer) {
		listaDeMujeres.add(mujer);
	}

	public void ayade(NoDefinido noDefinido) {
		listaDeNoDefinidos.add(noDefinido);
	}

	public void buscaMatches(Hombre hombre) {
		// lista de persona si es en caso 0
		ArrayList<Persona> matches = new ArrayList<Persona>();

		if (hombre.getQueBusca() == 0) {
			for (Persona persona : matches) {
				if (persona != hombre) {
					matches.add(persona);
				}
			}
		} else if (hombre.getQueBusca() == 1) {
			for (Hombre hombres : listaDeHombres) {
				if(hombres!=hombre) {
					matches.add(hombres);
				}
			}
		} else { // queBusca==2
			for (Mujer mujeres : listaDeMujeres) {
				matches.add(mujeres);
			}
		}
		// finalmente hago el listado de matches
		for (Persona persona : matches) {
			persona.mostrarDatos();
		}
	}

}
