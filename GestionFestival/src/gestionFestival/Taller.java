package gestionFestival;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Taller  extends Actividades{

	private String materialesEspeciales;
	public Taller(String nombre,String materialesEspe, int aforoMaximo, LocalDateTime fechaHora) {
		super(nombre, aforoMaximo, fechaHora);
		this.materialesEspeciales=materialesEspe;
	}

}
