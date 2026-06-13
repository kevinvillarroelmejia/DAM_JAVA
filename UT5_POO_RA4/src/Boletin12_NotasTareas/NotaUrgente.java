package Boletin12_NotasTareas;

import java.util.Scanner;

public class NotaUrgente extends Nota {

	public NotaUrgente(String titulo, String descripcion, String color) {
		super(titulo, descripcion, "rojo");

	}

	@Override
	public void crearNota(String titulo, String descripcion, String color) {
		NotaUrgente nota = new NotaUrgente(titulo, descripcion, color);
	}

	@Override
	public void eliminarNota() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Estas seguro de que quieres eliminar esta nota-- SI/NO");
		String confirmacionString = teclado.nextLine();
		if (confirmacionString.equalsIgnoreCase("SI")) {
			Nota.listaNotas.remove(this);
			System.out.println("Nota eliminada");
		}
	}

	@Override
	public void listaNota() {
		System.err.println(this);
	}

}
