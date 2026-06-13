package AccesoAletorio_IA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Agenda_AccesoAletorio {

	/*
	 * Ejercicio: Agenda de contactos con acceso aleatorio Crea un programa que
	 * gestione una agenda de 5 contactos en un fichero binario agenda.dat usando
	 * RandomAccessFile. Cada contacto almacena únicamente un nombre con un tamaño
	 * fijo. Las posiciones vacías se marcan con el carácter *. Tu programa debe:
	 * 
	 * Crear el fichero con las 5 posiciones vacías Permitir añadir un contacto en
	 * una posición concreta (1-5). Si ya está ocupada, mostrar un error Leer un
	 * contacto de una posición concreta. Si está vacía, indicarlo Listar todos los
	 * contactos que hay en la agenda
	 */
	static final int TAMAYO_NOMBRE = 20;
	static final int TAMANYO_REGISTRO = TAMAYO_NOMBRE * 2;

	public static void main(String[] args) {
		String rutaBinario = "agenda.dat";
		ArrayList<String> agendaContactos = new ArrayList<String>(5);
		try {
			File f = new File(rutaBinario);

			if (!f.exists()) {
			    crearFicheroVacio(rutaBinario);
			}
			escribirContactoPosicion(rutaBinario, 2, "Kevin");
			escribirContactoPosicion(rutaBinario, 3, "Rubi");
			escribirContactoPosicion(rutaBinario, 1, "Marioli");
			escribirContactoPosicion(rutaBinario, 5, "Reny");


//			leerContactoPorPosicion(rutaBinario, 2);
			leerTodoElFichero(rutaBinario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CREA EL FICHERO SI NO EXISTE
	public static void crearFicheroVacio(String fichero) throws FileNotFoundException, Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			for (int i = 0; i < 5; i++) {
				escribirAsterisco(raf, "*");
			}
		}
	}

	public static void escribirAsterisco(RandomAccessFile raf, String nombreContacto) throws Exception {
		char[] chars = new char[TAMAYO_NOMBRE];
		for (int i = 0; i < TAMAYO_NOMBRE; i++) {
			if (i < nombreContacto.length()) {
				chars[i] = nombreContacto.charAt(i);
			} else {
				chars[i] = ' ';
			}
		}
		for (char c : chars) {
			raf.writeChar(c);
		}
	}

	// escribir un contacto en una posicion en especifico
	public static void escribirContactoPosicion(String fichero, int registro, String nombreContacto) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			long offset = (registro - 1) * TAMANYO_REGISTRO;
			if (offset >= raf.length()) {
				System.out.println("No existe el registro " + registro);
			} else {
				raf.seek(offset);
				String nombre = leerNombre(raf);
				if (nombre.charAt(0) == '*') {
					raf.seek(offset);
					escribirNombre(raf, nombreContacto);
					System.out.println("Contacto "+nombreContacto+" añadido en posicion ");
				}
				else {
				    System.out.println("La posición ya está ocupada por " + nombre);
				}
			}
		}
	}
	public static void escribirNombre(RandomAccessFile raf, String nombreContacto) throws Exception {
		char[] chars = new char[TAMAYO_NOMBRE];
		for (int i = 0; i < TAMAYO_NOMBRE; i++) {
			if (i < nombreContacto.length()) {
				chars[i] = nombreContacto.charAt(i);
			} else {
				chars[i] = ' ';
			}
		}
		for (char c : chars) {
			raf.writeChar(c);
		}
	}
	public static void leerTodoElFichero(String fichero) throws  Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			int numRegistros = (int) raf.length() / TAMANYO_REGISTRO;
			
			System.out.println("===AGENDA COMPLETA===");
			for (int i = 0; i < numRegistros; i++) {
				raf.seek(i * TAMANYO_REGISTRO);
				String nombre = leerNombre(raf);
				int posicion=i+1;
				if (nombre.charAt(0) != '*') {
					//no se como ponerle el numero
					System.out.println("Posicion "+posicion+":"+nombre);
				}
			}
		}
	}
	
	public static void leerContactoPorPosicion(String fichero,int posicion) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			long offset = (posicion - 1) * TAMANYO_REGISTRO;
			if (offset >= raf.length()) {
				System.out.println("No existe el registro " + posicion);
			} else {
				raf.seek(offset);
				String nombre = leerNombre(raf);
				System.out.println(nombre);
			}
		}
	}

	// LEE NOMBRES
	public static String leerNombre(RandomAccessFile raf) throws Exception {
		String nombre = "";
		for (int i = 0; i < TAMAYO_NOMBRE; i++) {
			nombre = nombre + raf.readChar();
		}
		return nombre.trim();
	}
	


}
