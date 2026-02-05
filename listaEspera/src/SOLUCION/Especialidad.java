package SOLUCION;

import java.util.ArrayList;
import java.util.Collections;

public class Especialidad {
	private String nombre;
	private ArrayList<Medico> listaMedicos = new ArrayList<>();
	
	public Especialidad (String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void aniadeMedico(Medico medico) {
		this.listaMedicos.add(medico);
	}
	
	public void mostrarMedicos() {
		System.out.println("\nLISTA DE MÉDICOS DE LA ESPECIALIDAD - " + this.nombre);
		if (this.listaMedicos.size()!=0) {
			for (Medico medico:this.listaMedicos) {
				System.out.println("Nombre: " + medico.getNombre() + " (" + medico.getContadorCitas() + " citas)");
			}
		} else {
			System.out.println("No hay médicos con esta especialidad");
		}

	}
	
	public int numMedicos() {
		return listaMedicos.size();
	}

	public Medico getMedico() {
		Medico medico = null;
		if (listaMedicos.size() == 1) {
			medico = listaMedicos.get(0);
		} else {
			// 1. Encontrar el menor número de citas de uno o unos médicos
			int menor = Integer.MAX_VALUE;//ESTO ES EL MAXIMO VALOR QUE PERMITE UN INT
			for (Medico med: listaMedicos) {
				if (med.getContadorCitas()< menor)
					menor = med.getContadorCitas();
			}
			// 2. Encontrar cuantos médicos tienen ese número de citas menor
			ArrayList<Medico> medicosConMenosCitas = new ArrayList<>();
			for (Medico med: listaMedicos) {
				if (med.getContadorCitas() == menor) {
					medicosConMenosCitas.add(med);
				}
			}
			// 3. Elegir uno de ellos
			Collections.shuffle(medicosConMenosCitas);
			medico = medicosConMenosCitas.get(0);
		}
		return medico;
	}

}