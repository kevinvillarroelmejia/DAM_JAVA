package Examen_IA_Veterinaria;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Examen2_RA8_Main {
	static String ficheroVisitas = "visitas.txt";
	static String binarioVisitasDat = "visitasBinario.dat";
	public static void main(String[] args) {
		ArrayList<Visitas> listaVisitas = leerVisitasGuardasVisitas();
		leerBinarioVisitas("Gato");


	}

	public static ArrayList<Visitas> leerVisitasGuardasVisitas() {
		ArrayList<Visitas> listaVisita=new ArrayList<Visitas>();
		Visitas visita = null;
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ficheroVisitas));
			String linea;
			String[] lineaVisita = new String[4];
			while ((linea = lector.readLine()) != null) {
				lineaVisita = linea.split(";");
				if (lineaVisita.length == 4) {
					visita = new Visitas(lineaVisita[0], lineaVisita[1], lineaVisita[2],
							Double.parseDouble(lineaVisita[3]));
					listaVisita.add(visita);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		//ESCRIBIMOS TODO EL ARRAYLIST EN EL BINARIO
		try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(binarioVisitasDat))) {
			escritor.writeObject(listaVisita);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return listaVisita;
	}

	public static void leerBinarioVisitas(String especieAnimal) {
		ArrayList<Visitas> lista = new ArrayList<Visitas>();
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(binarioVisitasDat))) {
			lista = (ArrayList<Visitas>) binario.readObject();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		Visitas visitaMasCara=lista.get(0); //asigna el primer objeto
		for(Visitas visita:lista) {
			if(visita.getEspecie().equalsIgnoreCase(especieAnimal)) {
				System.out.println(visita);
			}
			if(visita.getCosteVisita()>visitaMasCara.getCosteVisita()) {
				visitaMasCara=visita;
			}
		}
		System.out.println("La visita mas cara: "+visitaMasCara+"("+visitaMasCara.getCosteVisita()+")");
	}
	
	
	

}