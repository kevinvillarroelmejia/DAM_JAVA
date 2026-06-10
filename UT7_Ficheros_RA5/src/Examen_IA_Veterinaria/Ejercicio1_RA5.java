package Examen_IA_Veterinaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio1_RA5 {

	static String ficheroVisitas = "visitas.txt";
	static String ficheroFacturacion="facturacion.txt";
	public static void main(String[] args) {
		leerVisitas();
	}

	public static void leerVisitas() {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ficheroVisitas));
			String linea;
			ArrayList<String> lineasMalFormato = new ArrayList<String>();
			HashMap<String, Double> listaClientes = new HashMap<String, Double>();
			HashMap<String, Integer> conteoClientes = new HashMap<String, Integer>();
			int contador = 0;
			String clienteNombreTop = "";
			Double clienteMontoTop = 0.0;
			String[] lineaLista = new String[4];
			while ((linea = lector.readLine()) != null) {
//				lineaLista = new String[4];
				lineaLista = linea.split(";");
				if (lineaLista.length != 4) {
					lineasMalFormato.add(linea);
				} else {
					try {
						Double importe = Double.parseDouble(lineaLista[3]);
						if (listaClientes.containsKey(lineaLista[0])) {
							// TODO ----- DEVUELVE EL VALOR ESPECIFICO DE ESA CLAVE
//								listaClientes.get(lineaLista[0]
							listaClientes.put(lineaLista[0],
									listaClientes.get(lineaLista[0]) + Double.parseDouble(lineaLista[3]));
							conteoClientes.put(lineaLista[0], conteoClientes.get(lineaLista[0]) + 1);
						} else {
							conteoClientes.put(lineaLista[0], 1);
							listaClientes.put(lineaLista[0], importe);
						}
						contador++;
					} catch (Exception e) {
						lineasMalFormato.add(linea);
					}
				}
			}
			lector.close();
			try (FileWriter escritor = new FileWriter(ficheroFacturacion)) {
				System.out.println("=========Gastos por dueño=========");
				for (Map.Entry<String, Double> cliente : listaClientes.entrySet()) {
					escritor.write(cliente.getKey() + ":" + cliente.getValue() + "("
							+ conteoClientes.get(cliente.getKey()) + ")\n");
					System.out.println(cliente.getKey() + ":" + cliente.getValue() + "("
							+ conteoClientes.get(cliente.getKey()) + ")");
				}
				System.out.println("=========Resumen=========");
				System.out.println("Total de visitas validas: " + contador);
				System.out.println("Total de visitas ignoradas: " + lineasMalFormato.size());
				for (Map.Entry<String, Double> cliente : listaClientes.entrySet()) {

					if (cliente.getValue() > clienteMontoTop) {
						clienteMontoTop = cliente.getValue();
						clienteNombreTop = cliente.getKey();
					}
				}
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
			System.out.println("Dueyo que mas ha gastado: " + clienteNombreTop + " (" + clienteMontoTop + ")");
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());

		}
	}

}
