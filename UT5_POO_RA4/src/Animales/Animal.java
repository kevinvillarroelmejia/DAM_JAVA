package Animales;

import java.util.ArrayList;

public class Animal {
	private String raza;
	private String especie;
	private int edadMeses;
	private double precio;

	private ArrayList<Vacuna> listaVacunas = new ArrayList<Vacuna>();

	public Animal(String raza, String especie, int edadMeses, double precio) {
		this.raza = raza;
		this.especie = especie;
		this.edadMeses = edadMeses;
		this.precio = precio;
	}

	public void ayadirVacuna(Vacuna vacuna) {
		listaVacunas.add(vacuna);
	}

	public void ayadirListaVacunas(ArrayList<Vacuna> listaVacunas) {
		for (Vacuna vacuna : listaVacunas) {
			this.listaVacunas.add(vacuna);
		}
	}

	@Override
	public String toString() {
		String linea = "";
		String dobleLinea = "";
		for (int i = 0; i < raza.length(); i++) {
			dobleLinea = dobleLinea + "=";
		}
		if(listaVacunas.size()!=0) {
			linea = this.raza.toUpperCase() + "\n" + dobleLinea + "\nEspecie: " + this.especie + "\nEdad: " + this.edadMeses
					+ "\nPrecio: " + this.precio+"\nVacunas: ";
			for(Vacuna vacuna:listaVacunas) {
				linea=linea+vacuna+",";
			}

		}else {
			linea = this.raza + "\n" + dobleLinea + "\nEspecie: " + this.especie + "\nEdad: " + this.edadMeses
					+ "\nPrecio: " + this.precio+"\nVacunas: Sin registrar";
		}

		return linea;

	}
	
//	
//	ArrayList<String> nombres = new ArrayList<>();
//	for (Vacuna v : listaVacunas) {
//	    nombres.add(v.toString());
//	}
//	linea = linea + String.join(", ", nombres);

}
