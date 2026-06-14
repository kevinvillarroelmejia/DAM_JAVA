package RA5_FicherosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class E1_NotasAcademicas {

	public static void main(String[] args) {

		String ficheroNotasAcademicas = "notas_academia.csv";
		String ficheroAprobados = "aprobados.csv";
		lecturaNotasAcamicas(ficheroNotasAcademicas, ficheroAprobados);

	}

	public static void lecturaNotasAcamicas(String fichero, String ficheroAprobados) {
		ArrayList<String> arrayListLineas = new ArrayList<String>();

		try {
			BufferedReader lector = new BufferedReader(new FileReader(fichero));
			String linea;
			String[] lista = new String[3];
			double notaMediaIngles = 0;
			double notaMediaFrances = 0;
			double notaMediaAleman = 0;
			int numAlumnosAleman = 0;
			int numAlumnosFrances = 0;
			int numAlumnosIngles = 0;

			double notaMasAlta = 0;
			String alumnoNotaMasAlta = "";
			while ((linea = lector.readLine()) != null) {
				try {
					lista = linea.split(";");// csv
					if (lista.length == 3) {
						if (lista[1].equalsIgnoreCase("Ingles")) {
							numAlumnosIngles++;
							notaMediaIngles = notaMediaIngles + Double.parseDouble(lista[2]);
						} else if (lista[1].equalsIgnoreCase("Frances")) {
							numAlumnosFrances++;
							notaMediaFrances = notaMediaFrances + Double.parseDouble(lista[2]);
						} else if (lista[1].equalsIgnoreCase("Aleman")) {
							numAlumnosAleman++;
							notaMediaAleman = notaMediaAleman + Double.parseDouble(lista[2]);
						}
						double nota = Double.parseDouble(lista[2]);
						if (nota > notaMasAlta) {
							notaMasAlta = nota;
							alumnoNotaMasAlta = linea;
						}
						if (Double.parseDouble(lista[2]) >= 5) {
							arrayListLineas.add(linea);
						}
					}
				} catch (Exception e) {
					System.out.println("Linea ignorada (formato incorrecto):" + linea);
				}
			}
			System.out.println(" -- MEDIAS POR IDIOMA --");
			System.out.printf("Ingles: %.2f\n", notaMediaIngles / numAlumnosIngles);
			System.out.printf("Frances: %.2f\n", notaMediaFrances / numAlumnosFrances);
			System.out.printf("Aleman: %.2f\n", notaMediaAleman / numAlumnosAleman);
			System.out.println("Alumno con nota mas alta: " + alumnoNotaMasAlta);
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		// ESCRIBIMOS
		Path ruta = Paths.get(ficheroAprobados);
		try {
			Files.write(ruta, arrayListLineas, StandardCharsets.UTF_8);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
