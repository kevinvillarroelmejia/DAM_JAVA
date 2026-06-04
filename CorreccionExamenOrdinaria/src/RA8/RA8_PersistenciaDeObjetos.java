package RA8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class RA8_PersistenciaDeObjetos {
	// variable global
	static String fichero = "votos.dat";
	static String[] partidos = { "PA", "PB", "PC", "PD" };

	public static void main(String[] args) {
		inicializarFichero(fichero);
		ayadirVotos("PC", 30);
		verResultados(3500);
//		int[] votos=leerFichero();
//		verVotos(votos);
	}

	private static void verResultados(int censo) {
		int suma=0;
		int[] votos = leerFichero();

		for(int i=0;i<4;i++) {
			suma+=votos[i];
		}
		double escrutinio=(double)(suma*100)/censo;
		System.out.printf("Resultados con un %.2f%% de escrutinio:\n",escrutinio);
		verVotos(votos);
	}

	public static void ayadirVotos(String partido, int voto) {
		int[] votos = leerFichero();
		int encontrado = -1;
		for (int i = 0; i < 4 && encontrado == -1; i++) {
			if (partido.equals(partidos[i])) {
				encontrado = i;
			}
		}
		if (encontrado == -1) {
			System.out.println("Ese partido no se presenta a las elecciones");
		} else {
			votos[encontrado] += voto;
			grabarFichero(votos);
			System.out.println("Nuevos votoso para el partido "+partido+":" +voto);
			System.out.println("Votos hasta el momento: ");
			verVotos(votos);
		}
	}

	private static void verVotos(int[] votos) {
		String[] partidos = { "PA", "PB", "PC", "PD" };
		for (int i = 0; i < 4; i++) {
			System.out.printf("Partido %s: %d votos\n", partidos[i], votos[i]);
		}
	}

	private static int[] leerFichero() {
		int[] votos = new int[4];
		try (DataInputStream f = new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)))) {
			System.out.println("El fichero existe");
			for (int i = 0; i < 4; i++) {
				votos[i] = f.readInt();
			}
		} catch (Exception e) {
			System.out.println("ERROR AL LEER EL FICHERO"+e.getMessage());
		}
		return votos;
	}

	public static void grabarFichero(int[] votos) {
		// PARA GRABAR
		try (DataOutputStream f = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))) {
			for (int i = 0; i < 4; i++) {
				f.writeInt(votos[i]);
			}
		} catch (Exception e) {
			System.out.println("Error al crear el fichero");
		}
	}

	public static void inicializarFichero(String fichero) {
		boolean noExiste = false;
		// podemos utilizar file si el fichero existe o no
		try (DataInputStream f = new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)))) {
			System.out.println("El fichero existe");
		} catch (Exception e) {
			System.out.println("El fichero no existe. Lo voy a crear...");
			noExiste = true;
		}
		if (noExiste == true) {
			// PARA GRABAR
			try (DataOutputStream f = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))) {
				for (int i = 0; i < 4; i++) {
					f.writeInt(0);
				}
			} catch (Exception e) {
				System.out.println("Error al crear el fichero");
			}
		}
	}
}






