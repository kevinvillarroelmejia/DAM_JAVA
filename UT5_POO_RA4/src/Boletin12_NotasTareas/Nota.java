package Boletin12_NotasTareas;

import java.time.LocalDate;
import java.util.ArrayList;

abstract class Nota {

	protected String titulo;
	protected String descripcion;
	protected String color;
	protected LocalDate fechaCreacion;

	public static ArrayList<Nota> listaNotas = new ArrayList<Nota>();

	public Nota(String titulo, String descripcion, String color) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.color = color;
		this.fechaCreacion = LocalDate.now();
		listaNotas.add(this);
	}

	public static void urgentesPrimero1() {
		// primero todas las NotaUrgente
		for (Nota nota : listaNotas) {
			if (nota instanceof NotaUrgente) {
				nota.listaNota();
			}
		}
		// luego todas las NotaNormal
		for (Nota nota : listaNotas) {
			if (nota instanceof NotaNormal) {
				nota.listaNota();
			}
		}
	}

	@Override
	public String toString() {
		String linea = "Tarea: " + this.titulo + "\n" + "Descripcion: " + this.descripcion + "\n" + "Color: "
				+ this.color;
		return linea;
	}

	abstract void crearNota(String titulo, String descripcion, String color);

	abstract void eliminarNota();

	abstract void listaNota();

}
