package FicherosTexto;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class EscrituraFicherosTexto {

	// FORMA 1 - FileWriter (simple)
	// Si el fichero no existe se crea. Si existe se borra su contenido.
	// Con el segundo parámetro true, añade al final (append).
	public static void escritura1() {
		try (FileWriter escritor = new FileWriter("/mnt/temp/java.txt")) {
			escritor.write("Hola, mundo con FileWriter!\n");
			escritor.write("Segunda línea.");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		// Para AÑADIR al final: segundo parámetro true
		try (FileWriter escritor = new FileWriter("/mnt/temp/java.txt", true)) {
			escritor.write("\nEsta línea se añade al final.");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	// FORMA 2 - BufferedWriter (más eficiente para grandes datos)
	// newLine() escribe salto de línea portable
	public static void escritura2() {
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter("/mnt/temp/java.txt"))) {
			escritor.write("Primera línea con Buffer.");
			escritor.newLine();
			escritor.write("Segunda línea.");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		// Para AÑADIR: true en FileWriter
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter("/mnt/temp/java.txt", true))) {
			escritor.write("Línea añadida.");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	// FORMA 3 - PrintWriter (permite printf con formato)
	public static void escritura3() {
		try (PrintWriter escritor = new PrintWriter("/mnt/temp/java.txt", StandardCharsets.UTF_8)) {
			escritor.println("Línea 1 con PrintWriter.");
			escritor.print("Sin salto de línea. ");
			escritor.println("Con salto.");
			String nombre = "Ana";
			int edad = 30;
			double altura = 1.75;
			escritor.printf("Usuario: %s, Edad: %d, Altura: %.2f m", nombre, edad, altura);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		// Para AÑADIR: envolver con FileWriter(ruta, charset, true)
		try (PrintWriter escritor = new PrintWriter(
				new FileWriter("/mnt/temp/java.txt", StandardCharsets.UTF_8, true))) {
			escritor.println("Línea añadida.");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	// FORMA 4 - Files.write() (graba un ArrayList de golpe, una línea por elemento)
	public static void escritura4() {
		Path ruta = Paths.get("/mnt/temp/java.txt");
		ArrayList<String> lineas = new ArrayList<>(List.of("Primera", "Segunda", "Tercera"));
		try {
			Files.write(ruta, lineas, StandardCharsets.UTF_8);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		// Para AÑADIR:
		ArrayList<String> nuevas = new ArrayList<>(List.of("Cuarta", "Quinta"));
		try {
			Files.write(ruta, nuevas, StandardCharsets.UTF_8,
					StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	// FORMA 5 - Files.writeString() (graba un String de golpe)
	public static void escritura5() {
		Path ruta = Paths.get("/mnt/temp/java.txt");
		try {
			Files.writeString(ruta, "Contenido completo.\nSegunda línea.", StandardCharsets.UTF_8);
			// Para AÑADIR:
			Files.writeString(ruta, "\nLínea añadida.", StandardCharsets.UTF_8,
					StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}