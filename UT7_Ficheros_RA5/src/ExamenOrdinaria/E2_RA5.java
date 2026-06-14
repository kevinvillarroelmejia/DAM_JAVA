package ExamenOrdinaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class E2_RA5 {
	static String rutaPaises = "D:\\IES FRANCISCO DE GOYA\\DAM\\PROGRAMACION\\paises.csv";
	static String sobreEscrito="D:\\IES FRANCISCO DE GOYA\\DAM\\PROGRAMACION\\paises1.csv";
	public static void main(String[] args) {
		escribirFormato();

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
