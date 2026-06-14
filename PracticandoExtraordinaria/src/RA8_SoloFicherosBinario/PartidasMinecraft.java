package RA8_SoloFicherosBinario;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class PartidasMinecraft {

	public static void main(String[] args) {

		String ficheroTextoCSV = "partidas.csv";

		String ficheroBinario = "partidas.dat";
		lecturaEscritura(ficheroTextoCSV, ficheroBinario);
		System.out.println();
		lecturaBinario(ficheroBinario);
		System.out.println();
		mostrarLineasPorJuego(ficheroBinario, "Minecraft");
		System.out.println();
		juegadorMayorPuntacion(ficheroBinario);
		System.out.println();
		calcularMediaPuntosPorJuego(ficheroBinario, "LeagueofLegends");
	}

	public static void lecturaEscritura(String ficheroTexto, String ficheroBinario) {
		String[] listaLinea = new String[3];
		try {
			//TODO LECTURA CSV
			BufferedReader lector = new BufferedReader(new FileReader(ficheroTexto));
			String linea;
			//TODO EL DataOutputStream FUERA DEL WHILE PARA QUE FUNCIONE LEEMOS DE UN CSV Y ESCRIBIMOS EN UN BINARIO
			//TODO ESCRITURA .dat
			try (DataOutputStream binario = new DataOutputStream(new FileOutputStream(ficheroBinario))) {
				while ((linea = lector.readLine()) != null) {
					listaLinea = linea.split(";");
					binario.writeUTF(listaLinea[0]);
					binario.writeUTF(listaLinea[1]);
					int puntuacion = Integer.parseInt(listaLinea[2]);
					binario.writeInt(puntuacion);
				}
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}
	public static void lecturaBinario(String ficheroBinario) {
		try (DataInputStream binario = new DataInputStream(new FileInputStream(ficheroBinario))) {
			while (binario.available() > 0) {//.available() numeros de bytes que quedan
				String nombreJugador = binario.readUTF();
				String juego = binario.readUTF();
				int puntos=binario.readInt();
				System.out.println("NOMBRE JUGADOR: "+nombreJugador+" "+puntos+" "+juego);
			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void mostrarLineasPorJuego(String ficheroBinario,String juego) {
		try (DataInputStream binario = new DataInputStream(new FileInputStream(ficheroBinario))) {
			while (binario.available() > 0) {//.available() numeros de bytes que quedan
				String nombreJugador = binario.readUTF();
				String videoJuego = binario.readUTF();
				int puntos=binario.readInt();
				if(videoJuego.equalsIgnoreCase(juego)) {
					System.out.println("NOMBRE JUGADOR: "+nombreJugador+" "+puntos+" "+juego);
				}
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void juegadorMayorPuntacion(String ficheroBinario) {
		try (DataInputStream binario = new DataInputStream(new FileInputStream(ficheroBinario))) {
			int puntosMasAltos=0;
			String mejorJugador="";
			String juegoMejorjugador="";
			while (binario.available() > 0) {//.available() numeros de bytes que quedan
				String nombreJugador = binario.readUTF();
				String videoJuego = binario.readUTF();
				int puntos=binario.readInt();
				if(puntos>puntosMasAltos) {
					puntosMasAltos=puntos;
					mejorJugador=nombreJugador;
					juegoMejorjugador=videoJuego;
				}
			}
			System.out.println("-- Mejor jugador --");
			System.out.println(mejorJugador+ "("+juegoMejorjugador+") - " +puntosMasAltos);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void calcularMediaPuntosPorJuego(String ficheroBinario,String nombreJuego) {
		try (DataInputStream binario = new DataInputStream(new FileInputStream(ficheroBinario))) {
			int contadorJuego=0;
			double mediaPuntos=0;
			while (binario.available() > 0) {//.available() numeros de bytes que quedan
				String nombreJugador = binario.readUTF();
				String videoJuego = binario.readUTF();
				int puntos=binario.readInt();
				if(videoJuego.equalsIgnoreCase(nombreJuego)) {
					contadorJuego++;
					mediaPuntos=mediaPuntos+(double)puntos;
				}
			}
			if(contadorJuego==0) {
				System.out.println("No hay juegos con este nombre");
			}else {
				mediaPuntos=mediaPuntos/contadorJuego;
				System.out.printf("\nMedia de puntos del juego %s %.2f",nombreJuego,mediaPuntos);
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
