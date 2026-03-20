package E9_Notas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Alumno implements Serializable {// CUANDO GRABAMOS UN OBJETO EN UN FICHERO BINARIO TIENE QUE SER
												// Serializable
	private String nombreAlumno;
	private double[] ras = new double[5];

	private static String nombreModulo;

	private static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

	public Alumno(String nombreAlumno, double[] ras) {
		this.nombreAlumno = nombreAlumno;
		this.ras = ras;
	}
	public static void leerAlumno(String fichero) {
		// try with resource
		try (BufferedReader lector = new BufferedReader(new FileReader(fichero));) {
			String linea;
			Alumno.nombreModulo = fichero.substring(0, fichero.length() - 4);
			while ((linea = lector.readLine()) != null) {// COMPROBAMOS SI LECTOR ES DIFERENTE A NULL
				System.out.println(linea);
				String[] elementos1 = linea.split(": ");
				String nombre = elementos1[0];
				String[] ras = elementos1[1].split(", ");
				double[] notas = new double[5];
				for (int i = 0; i < 5; i++) {
					notas[i] = Double.parseDouble(ras[i]);
				}
				Alumno alumno = new Alumno(nombre, notas);
				Alumno.listaAlumnos.add(alumno);
			}
		} catch (Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void procesarNotasAlumnos() {
		System.out.printf("Modulo: %s\n", Alumno.nombreModulo);
		System.err.println("Alumnos con todo aprobado: ");
		int contador = 0;
		for (Alumno alumno : Alumno.listaAlumnos) {
			System.out.println(alumno.nombreAlumno);
			if (alumno.todoAprobado()) {
				System.out.println(alumno.nombreAlumno);
				contador++;
			}
		}
		if(contador==0) {
			System.err.println("No hay nigun alumno con todos RAs aprobados");
		}
		System.err.println("\nResultados de aprendizaje y alumnos suspensos");
		for(int i=1;i<=5;i++) {
			System.out.printf("RA%d: \n,",i);
			Alumno.suspensosPorRA(i-1);
		}
	}

	
	
	private static void suspensosPorRA(int i) {
		int contador=0;
		for(Alumno alumno:Alumno.listaAlumnos) {
			if(alumno.ras[i]<5) {
				//TODO TIP ESTO PARA IMPRIMIR SIN LA ULTIMA COMA
				if(contador!=0) {
					System.out.println(", ");
				}
				System.out.printf("%s",alumno.nombreAlumno);
				contador++;
			}
		}
		if(contador==0) {
			System.err.println("Todos aprobados");
		}
		
	}

	private boolean todoAprobado() {
		boolean aprobado = true;
		for (double nota : ras) {
			if (nota < 5) {
				aprobado = false;
			}
		}
		return false;
	}

	public static void salvarAlumnosBinario(String ficheroBinario) {

	}
	//HACER UNA FUNCION 
}
