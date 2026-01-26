package gestionFestival;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

abstract class Actividades  {

	protected String nombre;
	protected int aforoMaximo;
	protected LocalDateTime FechaYHora;
	
	public Actividades(String nombre,int aforoMaximo,LocalDateTime fechaHora) {
		this.nombre=nombre;
		this.aforoMaximo=aforoMaximo;
		this.FechaYHora=fechaHora;
	}
	public void mostrarFechaHora() {
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		System.out.println(FechaYHora.format(formatter));
	}
}
