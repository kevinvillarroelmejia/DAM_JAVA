package Boletin24_FicherosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio4_invertirFicheroYTexto {
	static String rutaFicheroViejo="D:\\IES FRANCISCO DE GOYA\\DAM\\PROGRAMACION\\ficheroViejo.txt";
	static String rutaFicheroNuevo="D:\\IES FRANCISCO DE GOYA\\DAM\\PROGRAMACION\\ficheroNuevo.txt";
	public static void main(String[] args) {
	
		darVueltaFichero(rutaFicheroViejo, rutaFicheroNuevo);
	}
	public static void darVueltaFichero(String ficheroViejo,String ficheroNuevo) {
		//=========primero leemos y guardamos en un arrayList =========
		List<String> lineas=new ArrayList<String>();
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ficheroViejo));
			String linea;
			while ((linea = lector.readLine()) != null) {
				lineas.add(linea);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		
		//=========Reinvertimos tanto el contenido como las letras =========
		lineas=lineas.reversed();
		ArrayList<String> resultado=new ArrayList<String>();
		for(String palabra:lineas) {
			String palabraInvertida="";
			for(int i=palabra.length()-1;i>=0;i--) {
				palabraInvertida=palabraInvertida+palabra.charAt(i);
			}
			resultado.add(palabraInvertida);
		}
		
		//=========Guardamos el contenido TODO -- escribiendo arrayList en un fichero=========
		Path ruta = Paths.get(rutaFicheroNuevo);
		try {
			Files.write(ruta, resultado, StandardCharsets.UTF_8);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
