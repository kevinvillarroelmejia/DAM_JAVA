package SOLUCION;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cita {

	private Medico medico;
	private LocalDate fechaYhoraDeLacitaPedida;
	private LocalDate fechaYhoraDelaCitaDada; //tiene que ser 7 dias mas
	
	public Cita(Medico medico) {
		this.medico=medico;
		this.fechaYhoraDeLacitaPedida=LocalDate.now();
		this.fechaYhoraDelaCitaDada=fechaYhoraDeLacitaPedida.plusDays(7);
	}
	public Medico getNombreMedico() {
		return this.medico;
	}
	public LocalDate getFechaAsistirCita() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.fechaYhoraDelaCitaDada;
	}
	
}
