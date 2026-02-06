package futbol;

import java.util.HashSet;

public class Equipo {
	private String nombre;
	private Entrenador entrenador;
	
	private int partidosGanados=0;
	private int partidosEmpatados=0;
	private int partidosPerdidos=0;
	private int golesAFavor=0;
	private int golesEnContra=0;
	private int puntos=0;
	
	HashSet<Jugador> alineacion=new HashSet<Jugador>();
	
	public Equipo(String nombre) {
		this.nombre=nombre;	
	}
	//añadiendo jugador al equipo
	public void ayadeJugador(Jugador jugador) {
		this.alineacion.add(jugador);
	}
	public void setCambiarEntranador(Entrenador e) {
		this.entrenador=e;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void mostrarEquipo() {
		
	}
	
}
