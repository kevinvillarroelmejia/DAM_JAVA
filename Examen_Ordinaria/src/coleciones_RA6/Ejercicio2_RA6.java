package coleciones_RA6;

import java.util.Map;
import java.util.TreeMap;

public class Ejercicio2_RA6 {

	public static void main(String[] args) {
		String[] listaAlumnos= {"Ana","Luis","Marta","Carlos","Elena","Pablo","Laura","David","Sofia","Javier",};
		TreeMap<String, Integer> diccionarioAlumnoNotas=new TreeMap<String, Integer>();
		
		for(String alumno:listaAlumnos) {
			int notaAletoria=(int)(Math.random()*11)+0;
			diccionarioAlumnoNotas.put(alumno, notaAletoria);
		}
		System.out.println("==== NOTAS DE LA CLASE ====");
		int contadorAprobados=0;
		int contadorSuspensos=0;
		int notaMasAlta=0;
		int notaMasBaja=Integer.MAX_VALUE;
		String nombreNotaBaja="";
		String nombreNotaAlta="";
		double notaMedia=0.0;
		
		for(Map.Entry<String, Integer> alumnoNotas : diccionarioAlumnoNotas.entrySet()) {
			System.out.printf("%-10.30s: %d",alumnoNotas.getKey(),alumnoNotas.getValue());
			System.out.println();
			if(alumnoNotas.getValue()>=5) {
				contadorAprobados++;
			}if(alumnoNotas.getValue()<5) {
				contadorSuspensos++;
			}
			if(alumnoNotas.getValue()>notaMasAlta) {
				notaMasAlta=alumnoNotas.getValue();
				nombreNotaAlta=alumnoNotas.getKey();
			}
			if(alumnoNotas.getValue()<notaMasBaja) {
				notaMasBaja=alumnoNotas.getValue();
				nombreNotaBaja=alumnoNotas.getKey();
			}
			notaMedia=notaMedia+alumnoNotas.getValue();
		}
		notaMedia=notaMedia/diccionarioAlumnoNotas.size();
		
		System.out.println();
		System.out.println("===== ESTADISTICAS =====");
		System.out.printf("Nota Media: %.2f\n",notaMedia);
		System.out.println("Nota mas alta: "+nombreNotaAlta +" con "+notaMasAlta);
		System.out.println("Nota mas baja: "+nombreNotaBaja+" con "+notaMasBaja);
		System.out.println("Aprobado: "+contadorAprobados);
		System.out.println("Suspensos: "+contadorSuspensos);
		
		
	}
}
