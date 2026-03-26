package laPorra_Apuestas;

import java.io.RandomAccessFile;

public class Main {

	static final int numBoletos = 100;
	static final int tamayoNombre = 30; // 30 caracteres //
	static final int tamayoRegistro = tamayoNombre * 2;

	public static void main(String[] args) {
		String fichero = "/home/alumno/porra.dat";
		try {
			crearFichero(fichero);
			apuestaPorNumero(5, "Pepe moron");
			apuestaPorNumero(4, "Pepe moron");
			apuestaPorNumero(1, "Pepe moron");
			apuestaPorNumero(4, "Pepe moron");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR" + e.getMessage());
		}

	}

	public static void crearFichero(String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) { // rw modo de apertura del fichero
			System.out.println("Agenda creada. Tamaño: " + raf.length() + " bytes");
		}
	}

	public static void apuestaPorNumero(int numeroComprado, String nombrePersona) throws Exception {
		char[] chars = new char[tamayoNombre];
		for (int i = 0; i < tamayoNombre; i++) {
			if (i < nombrePersona.length()) {
				chars[i] = nombrePersona.charAt(i);
			} else {
				chars[i] = ' ';
			}
		}
	}
	
	public void hacerSorteo(RandomAccessFile raf) {
		
	}
	
	
	public void listaParticipantes(String fichero) {
		
	}

}
