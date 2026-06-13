package Animales;

import java.util.ArrayList;

public class Tienda_Main {

	public static void main(String[] args) {
		Vacuna vacuna1=new Vacuna("Moquillo");
		Vacuna vacuna2=new Vacuna("Parvovirus");
		ArrayList<Vacuna> listaVacunas=new ArrayList<Vacuna>();
		Vacuna vacuna3=new Vacuna("Rabia");
		Vacuna vacuna4=new Vacuna("Covid");
		listaVacunas.add(vacuna3);
		listaVacunas.add(vacuna4);
		
		Animal animal1=new Animal("Golden retriever", "Perro", 3, 800);
		animal1.ayadirVacuna(vacuna1);
		animal1.ayadirVacuna(vacuna2);
		Animal animal2=new Animal("Mastin", "Perro", 7, 100);

		animal2.ayadirListaVacunas(listaVacunas);

		System.out.println(animal1);
		
		System.out.println(animal2);
	}
}
