package gestionFestival;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exposicion  extends Actividades{
	private String tematicaConcreta;
	public Exposicion(String nombre,String tematica, int aforoMaximo, LocalDateTime fechaHora) {
		super(nombre, aforoMaximo, fechaHora);
		this.tematicaConcreta=tematica;
	}


}
