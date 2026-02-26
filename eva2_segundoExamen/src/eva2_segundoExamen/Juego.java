package eva2_segundoExamen;

import java.util.ArrayList;
import java.util.Map;

public class Juego {

	private int numJugadores;
	private Jugador jugador;
	private ArrayList<Jugador> listaDeJugadores = new ArrayList<Jugador>();
	private Prueba prueba;
	
	public Juego(int numJugadores) {
		this.numJugadores = numJugadores;
		//añadir jugadores maximo numJugadores
		for (int i = 0; i <= numJugadores; i++) {
			listaDeJugadores.add(jugador);
		}
	}

	public void verJugadores() {
		System.out.println("----------------------------------------------------------");
		for (int i = 0; i < numJugadores; i++) {
			for (Jugador jugador : listaDeJugadores) {
				String estadoJugador = "";
				if (jugador.isEstadoJugador()) {// si esta activo...
					estadoJugador = jugador.numIdentificador();
				} else {
					estadoJugador = "---";
				}
				//si el estado del jugador esta true imprime su codigo si esta false imprime ---
				System.out.printf("  %s\n  ",estadoJugador);
			}
		}
	}

	public void nuevaPrueba(int eliminaciones) {
		// eliminaremos de forma aletoria los jugadores
		
		//asignar a la prueba el numero de eliminados
		
		for(int i=0;i<eliminaciones;i++) {
			int eliminado = (int) (Math.random() * numJugadores) + 1;
			
			//eliminar por indice si lo elimina 
			//el estado del jugador lo pasamos a false y se imprimiria ---
		
		}
		if(listaDeJugadores.size()>=eliminaciones) {
			System.out.println("¡Picha, que nos quedamos sin ganador!");
		}
		if(listaDeJugadores.size()>eliminaciones) {
			System.out.println("Empieza la prueba numero "+prueba.getNumPrueba());
			System.out.println("Vamos a expulsar a "+eliminaciones);
		}
		if(listaDeJugadores.size()==1) {
			System.out.println("Empieza la prueba numero "+prueba.getNumPrueba());
			System.out.println("Vamos a expulsar a "+eliminaciones);
			System.out.println("El Juego de la Gamba ha terminado!");
			System.out.println("El ganador es el jugador ");

		}
	}

	public void verPruebas() {
		System.out.println("Numero de prueba hasta ahora "+prueba.getTotalPruebas());
		for(Map.Entry<Integer, Prueba> prueba: Prueba.listaDePruebas.entrySet()) {
			System.out.println("Numero prueba "+prueba.getKey());
		}
	}
}
