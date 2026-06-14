package RA8_AccesoAletorio;

import java.io.RandomAccessFile;

public class Aparcamiento {

	static final int TAMAYO_NOMBRE = 10;
	static final int TAMAYO_REGISTRO = TAMAYO_NOMBRE * 2;

	public static void main(String[] args) {

		String ficheroDAT = "parking.dat";
		try {
//			crearFicheroVacio(ficheroDAT);
			aparcarVehiculo(ficheroDAT, 2, "6201HMZ");
//			liberarPlazaParking(ficheroDAT, 2);
			buscarPlazaParkingPorMatricula(ficheroDAT, "6201HM");
			mostrarTodoParking(ficheroDAT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 10 caracteres
	public static void crearFicheroVacio(String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			for (int i = 0; i < 20; i++) {
				escribirNombre(raf, "*");
			}
		}
	}

	public static void escribirNombre(RandomAccessFile raf, String nombre) throws Exception {
		char[] chars = new char[TAMAYO_NOMBRE];
		for (int i = 0; i < TAMAYO_NOMBRE; i++) {
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

	private static String leerNombre(RandomAccessFile raf) throws Exception {
		String nombre = "";
		for (int i = 0; i < TAMAYO_NOMBRE; i++) {
			nombre = nombre + raf.readChar();
		}
		return nombre.trim();
	}

	public static void aparcarVehiculo(String fichero, int posicion, String matricula) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			long offset = (posicion - 1) * TAMAYO_REGISTRO;
			if (offset >= raf.length()) {
				System.out.println("No existe el registro " + posicion);
			} else {
				raf.seek(offset);
				String nombre = leerNombre(raf);
				// TODO PARA AGREGAR
				if (nombre.charAt(0) == '*') {
					raf.seek(offset);
					escribirNombre(raf, matricula);
					System.out.println("Vehiculo " + matricula + " añadido en posicion ");
				} else {
					System.out.println("La posición ya está ocupada por " + nombre);
				}
			}
		}
	}

	public static void liberarPlazaParking(String fichero, int plazaParkingPosicion) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			long offset = (plazaParkingPosicion - 1) * TAMAYO_REGISTRO;
			if (offset >= raf.length()) {
				System.out.println("No existe el registro " + plazaParkingPosicion);
			} else {
				raf.seek(offset);
				String nombre = leerNombre(raf);
				// para eliminar
				if (nombre.charAt(0) != '*') {
					raf.seek(offset);
					escribirNombre(raf, "*");
					System.out.println("Plaza " + plazaParkingPosicion + " liberada");
				} else {
					System.out.println("La plaza ya esta liberada");
				}
			}
		}
	}

	public static void buscarPlazaParkingPorMatricula(String fichero, String matricula) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			int numRegistros = (int) raf.length() / TAMAYO_REGISTRO;

			System.out.println(" --BUSQUEDA VEHICULO-- ");
			for (int i = 0; i < numRegistros; i++) {
				raf.seek(i * TAMAYO_REGISTRO);
				String nombre = leerNombre(raf);
				int posicion = i + 1;
				if (nombre.equalsIgnoreCase(matricula)) {
					// no se como ponerle el numero
					System.out.println("Posicion " + posicion + ":" + nombre);
				}
			}
		}
	}

	public static void mostrarTodoParking(String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			int numRegistros = (int) raf.length() / TAMAYO_REGISTRO;
			int asteriscos = 0;
			System.out.println("===ESTADO DEL PARKING===");
			for (int i = 0; i < numRegistros; i++) {
				raf.seek(i * TAMAYO_REGISTRO);
				String nombre = leerNombre(raf);
				int posicion = i + 1;
				if (nombre.charAt(0) != '*') {
					System.out.println("Plaza " + posicion + ": " + nombre);
					asteriscos++;
				}
			}
			System.out.println("Plazas  ocupadas "+(numRegistros-asteriscos)+"/"+numRegistros);
		}
	}
}
