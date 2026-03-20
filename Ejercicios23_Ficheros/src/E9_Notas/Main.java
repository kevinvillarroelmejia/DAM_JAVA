package E9_Notas;

public class Main {

	public static void main(String[] args) {
		
		//Alumnos alumno1=new Alumnos ("Carmelo Cotón", 5, 2.5, 3, 3, 6.2);
		//Alumnos alumno2=new Alumnos ("Dolores Fuertes de Barriga", 5, 7, 9, 9, 5.5);
		//Alumnos alumno3=new Alumnos ("Francisco Lorin Colorado", 1, 6, 4.5, 3.5, 5);
		//Alumnos alumno4=new Alumnos ("Rosa Cortada del Rosal", 6.3, 7, 8, 7, 8);
		
		String fichero="/home/alumno/redes.txt";
		String ficheroBinario="redes.bin";
		
		Alumno.leerAlumno(fichero);
		Alumno.procesarNotasAlumnos();
		//Alumnos.salvarAlumnosBinario(ficheroBinario);
	}
	
//	public modulo() {
//		Scanner 
//	}
	
	

}
