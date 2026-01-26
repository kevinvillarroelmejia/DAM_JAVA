package academia;

import java.util.ArrayList;
import java.util.HashSet;

public class examen {

//	private pregunta preguntas;
	private int numPreguntas;
	private ArrayList<pregunta> bancoPreguntas = new ArrayList<pregunta>();

	public examen(int numeroPreguntas, ArrayList<pregunta> listaPreguntas) {
		this.numPreguntas = numeroPreguntas;
		this.bancoPreguntas = listaPreguntas;

		// eligiendo 3 preguntas al aletoriamente
		HashSet<pregunta> preguntasAletorias = new HashSet<pregunta>();
		do {
			int azar = (int) (Math.random() * 3) + 1;
			preguntasAletorias.add(listaPreguntas.get(azar));
		} while (preguntasAletorias.size() != 3);
	}

	public void mostrarExamen() {
		for (pregunta p : bancoPreguntas) {
			p.mostrarPregunta();
			String[] respuestas = p.getSolucion();
			for (String r : respuestas) {
				System.out.println(r);
			}
			System.out.println("");
		}
	}

	public void solucionExamen() {
		System.out.println("SOLUCION");
		for (pregunta p : bancoDePreguntas) {
			System.out.println(p.getSolucion());
		}
	}
}
