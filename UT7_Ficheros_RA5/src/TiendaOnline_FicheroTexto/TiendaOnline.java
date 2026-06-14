package TiendaOnline_FicheroTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TiendaOnline {
	static String fichero = "productos.txt";
	static String ficheroRebajados = "productos_rebajados.txt";

	public static void main(String[] args) {
		mostrarProductosMenorPrecio(40);
	}

	public static void mostrarProductosMenorPrecio(double filtroPrecio) {
		ArrayList<String> lineasAprobadas = new ArrayList<String>();
		//LEEMOS Y FILTRAMOS
		try {
			BufferedReader lector = new BufferedReader(new FileReader(fichero));
			String linea;
			String[] lista = new String[3];
			double precioLinea = 0;
			while ((linea = lector.readLine()) != null) {
				lista = linea.split(",");
				if (lista.length == 3) {
					precioLinea = Double.parseDouble(lista[2]);
					if (precioLinea < filtroPrecio) {
						System.out.println(linea);
						lineasAprobadas.add(linea);
						
					}
				}
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
			e.printStackTrace();
		}

		// TODO ESCRIBIR
		Path ruta = Paths.get(ficheroRebajados);
		try {
			Files.write(ruta, lineasAprobadas, StandardCharsets.UTF_8);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		// TODO LEEMOS Y MOSTRAMOS LOS PRODUCTOS ENCONTRADOS
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ficheroRebajados));
			String linea2;
			String[] lista2 = new String[3];
			double precioMedio=0;
			int contador=0;
			while ((linea2 = lector.readLine()) != null) {
				lista2=linea2.split(",");
				precioMedio=precioMedio+Double.parseDouble(lista2[2]);
				contador++;
			}
			//PRECIO MEDIO // TOTAL DIVIDIDO ENTRE EL NUMERO DE PRODUCTOS ENCONTRADOS
			precioMedio=precioMedio/contador;
			System.out.println("Precio medio "+precioMedio+"\nProductos encontrados "+contador);
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
			e.printStackTrace();
		}
		

	}

}
