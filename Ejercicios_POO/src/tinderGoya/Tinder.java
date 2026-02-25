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
		//funcion que devuleve una lista
		matches = construirListaMatches(hombre);
		if (matches.size() == 0) {
			System.out.println("Lo siento,pero no tienes ningun match");
		} else {
			// finalmente hago el listado de matches
			for (Persona persona : matches) {
				persona.mostrarDatos();
			}
		}
	}

	private ArrayList<Persona> construirListaMatches(Hombre hombre) {
		ArrayList<Persona> matches = new ArrayList<Persona>();
		if (hombre.getQueBusca() == 0) {
			for (Hombre h : listaDeHombres) {
				// si hace match y si esta dentro del rango de edad
				if (h != hombre && hombre.esMatch(h) == true && hombre.getQueBusca() != 2) {
					matches.add(h);
				}
			}
			for (Mujer m : listaDeMujeres) {
				// si hace match y si esta dentro del rango de edad
				if (hombre.esMatch(m) == true && hombre.getQueBusca() != 2)
					matches.add(m);
			}
			for (NoDefinido o : listaDeNoDefinidos) {
				// si hace match y si esta dentro del rango de edad
				if (hombre.esMatch(o) == true && hombre.getQueBusca() != 2) {
					matches.add(o);
				}
			}
		} else if (hombre.getQueBusca() == 1) {
			for (Hombre h : listaDeHombres) {
				// si hace match y si esta dentro del rango de edad
				if (h != hombre && hombre.esMatch(h) == true && hombre.getQueBusca() != 2) {
					matches.add(h);
				}
			}
		} else { // queBusca==2
			for (Mujer m : listaDeMujeres) {
				// si hace match y si esta dentro del rango de edad
				if (hombre.esMatch(m) == true && hombre.getQueBusca() != 2)
					matches.add(m);
			}
		}
		return null;
	}
	public void buscaMatchAzar(Hombre hombre) {
		ArrayList<Persona>matches=new ArrayList<>();
		matches=construirListaMatches(hombre); //creando un arrayList atraves de una funcion
		
		int longitudArray=matches.size();
		int azar=(int)(Math.random()*longitudArray);
		matches.get(azar).mostrarDatos();
	}

}
