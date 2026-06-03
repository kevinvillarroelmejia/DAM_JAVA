package FicherosTexto;
 
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
 
public class LecturaFicherosTexto {
 
	// FORMA 1 - BufferedReader línea a línea (la más usada)
	public static void lectura1() {
		try {
			BufferedReader lector = new BufferedReader(new FileReader("/mnt/temp/quijote.txt"));
			String linea;
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
 
	// FORMA 2 - Scanner línea a línea
	public static void lectura2() {
		try {
			Scanner scanner = new Scanner(new File("/mnt/temp/quijote.txt"));
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
 
	// FORMA 3 - Todo de golpe en ArrayList (cada línea = un elemento)
	public static void lectura3() {
		Path ruta = Path.of("/mnt/temp/quijote.txt");
		try {
			ArrayList<String> lineas = (ArrayList<String>) Files.readAllLines(ruta);
			for (String linea : lineas) {
				System.out.println(linea);
			}
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
 
	// FORMA 4 - Todo de golpe en un solo String
	public static void lectura4() {
		Path ruta = Path.of("/mnt/temp/quijote.txt");
		try {
			String contenido = Files.readString(ruta);
			System.out.print(contenido);
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
}
