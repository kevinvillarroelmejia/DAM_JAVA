package accesoAletorioFicheros;

import java.io.RandomAccessFile;
import java.util.HashMap;

public class Ejercicio_AccesoAletorio_fichero {
	

	static final int TAMAÑO_NOMBRE = 20;
	static final int TAMAÑO_REGISTRO = (TAMAÑO_NOMBRE * 2) + 4; // CONSTANTE -- NO SE PUEDE MODIFICAR EL VALOR

	public static void main(String[] args) {
		// modificable
		String fichero = "/home/alumno/agenda.dat";
		HashMap<String, Integer> agenda = new HashMap<String, Integer>();
		agenda.put("Alejandro", 33);
		agenda.put("Luis", 24);
		agenda.put("Kevin", 7);
		agenda.put("Elvira", 41);
		try {
			crearAgenda(fichero, agenda);

			modificaRegistro(fichero, 2, "Ana Maria", 33);
			leerRegistro(fichero, 2);
			leerRegistro(fichero, 3);
			nuevoRegistro(fichero, "Jose Antonio", 56);
			leerRegistro(fichero, 5);
			leerTodosRegistros(fichero);
			borrarRegistro(fichero, 2);
			modificaRegistro(fichero, 3, "Elvira", 80);
			leerTodosRegistros(fichero);

		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
		}
	}
	// SI EL FICHERO EXISTE NO SE ELIMINA (pero nos los sobreEscribe)
	// AQUI TAMBIEN SE TIENEN QUE TRATAR CON EXCEPSIONES
	// throws Exception -- cuando salte una excepcion la gestionara el try catch de
	// arriba
	// === APERTURA DE FICHERO ===
	// r cuando solo leemos leer
	// rw cuando queremos leer y escribir

	public static void leerTodosRegistros(String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			int numRegistro = (int) (raf.length() / TAMAÑO_REGISTRO);
			for (int i = 1; i <= numRegistro; i++) {
				String nombre = leerNombre(raf);
				int edad = raf.readInt();
				if (nombre.charAt(0) != '*') {
					System.out.printf("Registro: %d- Nombre: %s. Edad %d\n", i, nombre, edad);
				}
			}
			// TERMINAR ESTO
		}
	}

	public static void escribirNombre(RandomAccessFile raf, String nombre) throws Exception {
		char[] chars = new char[TAMAÑO_NOMBRE];
		for (int i = 0; i < TAMAÑO_NOMBRE; i++) {
			if (i < nombre.length()) {
				chars[i] = nombre.charAt(i);
			} else {
				chars[i] = ' ';
			}
		}
		for (char c : chars) {
			raf.write(c);// si no tuvieramos throws Exception esto daria error
		}
	}

	public static void borrarRegistro(String fichero, int registro) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			long posicion = TAMAÑO_REGISTRO * (registro - 1);
			if (posicion >= raf.length()) {
				System.out.println("El registro " + registro + " no existe");
				System.out.println("el registro mas alto es el " + raf.length() / TAMAÑO_REGISTRO);
			} else {
				raf.seek(posicion);
				String nombre = leerNombre(raf);
				if (nombre.charAt(0) == '*') {
					System.out.println("El registro " + registro + " ya esta borrado");
				} else {
					String nombreBorrado = '*' + nombre.substring(1);
					raf.seek(posicion);
					escribirNombre(raf, nombreBorrado);
					System.out.println("El registro " + registro + " se ha borrado");
				}
			}
		}
	}

	public static void nuevoRegistro(String fichero, String nombre, int edad) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			raf.seek(raf.length());
			escribirNombre(raf, nombre);
			raf.writeInt(edad);
			System.out.println("Registro añadiendo correctamente");
		}
	}

	public static void modificaRegistro(String fichero, int registro, String nombre, int edad) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			long posicion = TAMAÑO_REGISTRO * (registro - 1);
			if (posicion >= raf.length()) {
				System.out.println("El registro " + registro + " no existe");
				System.out.println("El registro mas alto es el " + raf.length() / TAMAÑO_REGISTRO);
			} else {
				raf.seek(posicion);// colocamos el curso en la posicion que le indicamos (SI NO LA POSICION POR
									// DEFECTO ES 0)
				String nombreLeido = leerNombre(raf);
				if (nombreLeido.charAt(0) == '*') {
					System.out.printf("Registro" + registro + " no se puede modificar YA ESTA BORRADO");
				} else {
					raf.seek(posicion);
					escribirNombre(raf, nombre);
					raf.writeInt(edad);
					System.out.println("Registro " + registro + " modificado correctamente");
				}
			}
		}
	}

	public static void crearAgenda(String fichero, HashMap<String, Integer> agenda) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) { // rw modo de apertura del fichero
			for (String nombre : agenda.keySet()) { // recogiendo el nombre
				int edad = agenda.get(nombre);
				escribirNombre(raf, nombre);
				raf.writeInt(edad);
			}
			System.out.println("Agenda creada. Tamaño: " + raf.length() + " bytes");// length aqui daria lo que ocupa el																		// fichero
		}
	}

	// abrimos el fichero en modo r
	public static void leerRegistro(String fichero, int registro) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			long posicion = TAMAÑO_REGISTRO * (registro - 1);
			if (posicion >= raf.length()) {
				System.out.println("El registro " + registro + " no existe");
				System.out.println("El registro mas alto es el " + raf.length() / TAMAÑO_REGISTRO);
			} else {
				raf.seek(posicion);// colocamos el curso en la posicion que le indicamos
				String nombre = leerNombre(raf);
				int edad = raf.readInt();
				if (nombre.charAt(0) == '*') {
					System.out.printf("Registro : %d- Nombre: %s Edad: %d\n", registro, nombre, edad);
				} else {
					System.out.println("El registro " + registro + " se ha marcado para ser borrado");
				}
			}
		}
	}

	public static String leerNombre(RandomAccessFile raf) throws Exception {
		String nombre = "";
		for (int i = 0; i < TAMAÑO_NOMBRE; i++) {
			char c = raf.readChar();
			nombre = nombre + c;
		}
		return nombre.trim();
	}
}
