package FicherosBinarios_AccesoAletorio;

import java.io.RandomAccessFile;
import java.util.HashMap;

public class Apuntes_AccesoAleatorio {

	// TAMAÑOS FIJOS (clave para acceso aleatorio)
	static final int TAMANYO_NOMBRE = 20;  // caracteres (1 char = 2 bytes)
	static final int TAMANYO_EDAD = 4;     // bytes (1 int = 4 bytes)
	static final int TAMANYO_REGISTRO = TAMANYO_NOMBRE * 2 + TAMANYO_EDAD; // 44 bytes

	public static void main(String[] args) {
		String fichero = "registros.dat";
		HashMap<String, Integer> agenda = new HashMap<>();
		agenda.put("Isabel", 35);
		agenda.put("Marcos", 51);
		agenda.put("José María", 57);
		agenda.put("Luis", 23);

		try {
			crearRegistro(fichero, agenda);
			leerRegistro(fichero, 2);
			modificarRegistro(fichero, 2, "José Miguel", 56);
			leerTodosLosRegistros(fichero);
			anyadeRegistro(fichero, "Armando", 35);
			borrarRegistro(fichero, 3);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	// CREAR - escribe todos los registros del HashMap
	// "rw" = lectura y escritura, crea el fichero si no existe
	public static void crearRegistro(String fichero, HashMap<String, Integer> agenda) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			for (String nombre : agenda.keySet()) {
				escribirNombre(raf, nombre);
				raf.writeInt(agenda.get(nombre));
			}
		}
	}

	// LEER UN REGISTRO - seek() salta directamente a la posición
	// offset = (registro - 1) * TAMANYO_REGISTRO
	private static void leerRegistro(String fichero, int registro) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			long offset = (registro - 1) * TAMANYO_REGISTRO;
			if (offset >= raf.length()) {
				System.out.println("No existe el registro " + registro);
			} else {
				raf.seek(offset);
				String nombre = leerNombre(raf);
				if (nombre.charAt(0) == '*') {
					System.out.println("Registro " + registro + " está marcado como borrado");
				} else {
					int edad = raf.readInt();
					System.out.printf("Registro %d: '%s', %d años%n", registro, nombre, edad);
				}
			}
		}
	}

	// LEER TODOS LOS REGISTROS - calcula cuántos hay con length() / TAMANYO_REGISTRO
	private static void leerTodosLosRegistros(String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			int numRegistros = (int) raf.length() / TAMANYO_REGISTRO;
			for (int i = 0; i < numRegistros; i++) {
				String nombre = leerNombre(raf);
				int edad = raf.readInt();
				if (nombre.charAt(0) != '*')
					System.out.printf("Registro %d: '%s', %d años%n", i + 1, nombre, edad);
			}
		}
	}

	// MODIFICAR - seek() a la posición y sobreescribe
	private static void modificarRegistro(String fichero, int registro, String nombreNuevo, int edadNueva) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			long offset = (registro - 1) * TAMANYO_REGISTRO;
			if (offset >= raf.length()) {
				System.out.println("No existe el registro " + registro);
			} else {
				raf.seek(offset);
				String nombre = leerNombre(raf);
				if (nombre.charAt(0) != '*') {
					raf.seek(offset);
					escribirNombre(raf, nombreNuevo);
					raf.writeInt(edadNueva);
				} else {
					System.out.println("Registro borrado, no se puede modificar");
				}
			}
		}
	}

	// AÑADIR - seek() al final del fichero con raf.length()
	private static void anyadeRegistro(String fichero, String nombre, int edad) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			raf.seek(raf.length());
			escribirNombre(raf, nombre);
			raf.writeInt(edad);
		}
	}

	// BORRAR - marca el primer carácter con '*' (borrado lógico)
	private static void borrarRegistro(String fichero, int registro) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			long offset = (registro - 1) * TAMANYO_REGISTRO;
			if (offset >= raf.length()) {
				System.out.println("No existe el registro " + registro);
			} else {
				raf.seek(offset);
				String nombre = leerNombre(raf);
				if (nombre.charAt(0) == '*') {
					System.out.println("Ya estaba borrado");
				} else {
					nombre = '*' + nombre.substring(1);
					raf.seek(offset);
					escribirNombre(raf, nombre);
				}
			}
		}
	}

	// ESCRIBIR NOMBRE con tamaño fijo (rellena con espacios)
	private static void escribirNombre(RandomAccessFile raf, String nombre) throws Exception {
		char[] chars = new char[TAMANYO_NOMBRE];
		for (int i = 0; i < TAMANYO_NOMBRE; i++) {
			if (i < nombre.length()) {
				chars[i] = nombre.charAt(i);
			} else {
				chars[i] = ' ';
			}
		}
		for (char c : chars) {
			raf.writeChar(c);
		}
	}

	// LEER NOMBRE con tamaño fijo (quita espacios con trim)
	private static String leerNombre(RandomAccessFile raf) throws Exception {
		String nombre = "";
		for (int i = 0; i < TAMANYO_NOMBRE; i++) {
			nombre = nombre + raf.readChar();
		}
		return nombre.trim();
	}
}