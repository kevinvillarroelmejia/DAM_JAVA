package gestionFestival;

import java.util.ArrayList;

public class Asistente extends Participantes{
	private  ArrayList<Concierto> conciertoAsociados=new ArrayList<Concierto>();
	private ArrayList<Exposicion> exposicionesAsociadas=new ArrayList<Exposicion>();
	private ArrayList<Taller> talleresAsociados=new ArrayList<Taller>();
	public Asistente(int numeroID, String nombre) {
		super(numeroID, nombre);
	}
	public Asistente(int numeroID, String nombre,String apodo) {
		super(numeroID, nombre);
	}
	public void ayadirAsistenteConcierto(Concierto con) {
		conciertoAsociados.add(con);
	}
	public void ayadirAsistenteAsociados(Exposicion con) {
		exposicionesAsociadas.add(con);
	}
	public void ayadirTallersAsociados(Taller con) {
		talleresAsociados.add(con);
	}
}
