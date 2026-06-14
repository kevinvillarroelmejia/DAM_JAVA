package ExamenOrdinaria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class E1_RA8 {

	public static void main(String[] args) {

		String ficheroDAT = "recuentoVotos.dat";
		HashMap<String, Integer> diccionarioVotos = new HashMap<String, Integer>();

//		escribirVotos(ficheroDAT, "PC", 134);
//		escribirVotos(ficheroDAT,"PA" , 10);
//		escribirVotos(ficheroDAT,"PD" , 98);
//		escribirVotos(ficheroDAT,"PB" , 2);
		escrutinio(ficheroDAT, 1730);

	}

	public static void escribirVotos(String fichero, String nombrePartido, int numVotos) {

		HashMap<String, Integer> diccionario = new HashMap<String, Integer>();
		// LEEMOS POR PRIMERVEZ
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))) {
			diccionario = (HashMap<String, Integer>) binario.readObject();
		} catch (Exception e) {
		}
		// MODIFICAMOS
		if (diccionario.containsKey(nombrePartido)) {
			diccionario.put(nombrePartido, diccionario.get(nombrePartido) + numVotos);
		} else {
			diccionario.put(nombrePartido, numVotos);
		}

		//ESCRIBIMOS
		try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(fichero))) {
			binario.writeObject(diccionario);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		//LEEMOS
		System.out.println("Nuevos votos para el partido "+nombrePartido+": "+numVotos);
		System.out.println("Votos hasta el momento: ");
		for(Map.Entry<String, Integer> partidoVotos:diccionario.entrySet()) {
			System.out.println("Partido "+partidoVotos.getKey()+": "+partidoVotos.getValue());
		}
	}
	
	public static void escrutinio(String fichero,int censoPersonas) {
		HashMap<String, Integer> diccionario = new HashMap<String, Integer>();
		// LEEMOS POR PRIMERA VEZ
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))) {
			diccionario = (HashMap<String, Integer>) binario.readObject();
			int totalVotos=0;
			double escrutinio=0;
			for(Map.Entry<String, Integer> elementosOrdenados:diccionario.entrySet()) {
				totalVotos=totalVotos+elementosOrdenados.getValue();
			}
			escrutinio=((double)totalVotos/censoPersonas)*100;
			System.out.println("Resultados con un "+(int)escrutinio+"% de escrutinio:");
			
			for(Map.Entry<String, Integer> partidoVotos:diccionario.entrySet()) {
				System.out.println("Partido "+partidoVotos.getKey()+": "+partidoVotos.getValue());
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
