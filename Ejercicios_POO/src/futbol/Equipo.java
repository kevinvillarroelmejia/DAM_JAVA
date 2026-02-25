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
	
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	public int getGolesAFavor() {
		return golesAFavor;
	}
	public int getGolesEnContra() {
		return golesEnContra;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	public void setGolesAFavor(int golesAFavor) {
		this.golesAFavor = golesAFavor;
	}
	public void setGolesEnContra(int golesEnContra) {
		this.golesEnContra = golesEnContra;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	

	public void ganaPartido() {
		this.partidosGanados++;
		this.puntos+=3;	
	}
	
	public void pierdePartido() {
		this.partidosEmpatados++;
	}
	
	public void empataPartido() {
		this.partidosEmpatados++;
		this.puntos++;
	}
	
	public void cambiaGoles(int aFavor, int enContra) {
		this.golesAFavor+=aFavor;
		this.golesEnContra+=enContra;
	}

	
}
