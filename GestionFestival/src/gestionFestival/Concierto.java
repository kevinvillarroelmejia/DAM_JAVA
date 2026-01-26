package gestionFestival;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Concierto  extends Actividades{
	private ArrayList<Artista> artistasInvitados=new ArrayList<Artista>();
	
	public Concierto(String nombre, int aforoMaximo, LocalDateTime fechaHora) {
		super(nombre, aforoMaximo, fechaHora);
	}
	public void ayadirArtistasConcierto(Artista a) {
		artistasInvitados.add(a);
	}
	
	
	
}
