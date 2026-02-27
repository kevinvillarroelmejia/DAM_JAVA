package SOLUCION;

import java.util.ArrayList;

public class Juego {

	private ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
	private int numeroJugadoresActivos;
	public Juego(int numJugadores) {
		
		//añadiendo n jugadores
		//cuando creamos un juego
		
		for(int i=0;i<numJugadores;i++) {
			listaJugadores.add(new Jugador(i+1));
		}
		this.numeroJugadoresActivos=numJugadores;
	}
	
	
	public void nuevaPrueba(int expulsados) {
		if(this.numeroJugadoresActivos<=expulsados) {
			System.out.println("Picha, que nos quedamos sin ganador!");
		}else {
			this.numeroJugadoresActivos-=expulsados;
			new Prueba(expulsados,this.listaJugadores);
			if(this.numeroJugadoresActivos==1) {
				System.out.println("El juego de la gama ha terminado");
				System.out.printf("El ganador es el jugador: ",verGanador());
			}
		}
		
		
	}
	public void verPruebas() {
		Prueba.verPruebas(listaJugadores.size());
	}
	
	
}
