package ExamenOrdinaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class E1_RA5 {

	static String rutaPaises = "D:\\IES FRANCISCO DE GOYA\\DAM\\PROGRAMACION\\paises.csv";
	static String sobreEscrito="D:\\IES FRANCISCO DE GOYA\\DAM\\PROGRAMACION\\paises1.csv";
	public static void main(String[] args) {
		leerFicheroPaises();
		escribirFormato();
	}

	public static void leerFicheroPaises() {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaPaises));
			String linea;
			int numeroPaises = 0;
			String[] lineaPaises = new String[4];
			ArrayList<String> nombrePaises = new ArrayList<String>();
			ArrayList<String> capitales = new ArrayList<String>();
			ArrayList<String> monedas = new ArrayList<String>();
			ArrayList<String> animales = new ArrayList<String>();
			if ((linea = lector.readLine()) == null) {
				System.out.println("No hay datos de ningun pais en el fichero");
			} else {
				while ((linea = lector.readLine()) != null) {
					lineaPaises = linea.split(",");
					if(lineaPaises.length==4) {
						nombrePaises.add(lineaPaises[0]);
						capitales.add(lineaPaises[1]);
						monedas.add(lineaPaises[2]);
						animales.add(lineaPaises[3]);
						numeroPaises++;

					}
				}
				System.out.println("Paise en el fichero: " + numeroPaises);
				System.out.print("Nombre del pais: ");
				for(int i=0;i<nombrePaises.size();i++) {
					if(i==nombrePaises.size()-1) {
						System.out.print(" y "+nombrePaises.get(i));
					}else {
						System.out.print(nombrePaises.get(i) + ", ");
					}
				}
				System.out.println();
				System.out.print("Las capitales de los mismos son: ");
				for(int i=0;i<capitales.size();i++) {
					if(i==capitales.size()-1) {
						System.out.print(" y "+capitales.get(i));
					}else {
						System.out.print(capitales.get(i) + ", ");
					}
				}
				
				System.out.println();
				System.out.print("Sus monedas oficiales son: ");
				for(int i=0;i<monedas.size();i++) {
					if(i==monedas.size()-1) {
						System.out.print(" y "+monedas.get(i));
					}else {
						System.out.print(monedas.get(i) + ", ");
					}
				}
				System.out.println();
				System.out.print("Sus animales mas representativos son: ");
				for(int i=0;i<animales.size();i++) {
					if(i==animales.size()-1) {
						System.out.print(" y "+animales.get(i));
					}else {
						System.out.print(animales.get(i) + ", ");
					}				}
				lector.close();
			}
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}

	public static void escribirFormato() {
		ArrayList<String> lineaArraylist=new ArrayList<String>();
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaPaises));
			String linea;
			String[] listaLinea=new String[3];
			String lineaEscrita="";
			while ((linea = lector.readLine()) != null) {
				listaLinea=linea.split(",");
				if(listaLinea.length==4) {
					lineaEscrita=listaLinea[0]+","+listaLinea[1]+","+listaLinea[3];
					lineaArraylist.add(lineaEscrita);
				}
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		
		Path ruta = Paths.get(sobreEscrito);
		try {
			Files.write(ruta, lineaArraylist, StandardCharsets.UTF_8);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
