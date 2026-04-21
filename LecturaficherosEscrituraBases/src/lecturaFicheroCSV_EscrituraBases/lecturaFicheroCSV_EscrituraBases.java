package lecturaFicheroCSV_EscrituraBases;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class lecturaFicheroCSV_EscrituraBases {

	public static void main(String[] args) {
		/*
		 * LEER DE UN FICHERO CSV NOMBRE APELLIDOS EMAIL Y TELEFONO
		 * Y ESCRIBIR ESOS DATOS EN UNA BASE DE DATOS CADA COLUMNA 
		 * DE LA BASE DE DATOS SOLO PUEDE TENER 50 CARACTERES (VARCHAR(50))
		 * SI ALGUN DATO DE LA CELDA TIENE MAS DE 50 CARACTERES SE TRUNCA LOS 
		 * LOS PRIMEROS 50 CARACTERES- ES DECIR NOS QUEDAMOS SOLO CON LOS PRIMEROS
		 * 50 CARACTERES
		 * */
		
		leemosFicheroCSV();
		
	}
	// --- LEYENDO FICHERO CSV ---
	public static void leemosFicheroCSV() {
		ArrayList<String >lineas=null;
		try{
			Path fichero=Path.of("/home/alumno/Documentos/informacion.csv");
			lineas=(ArrayList<String>)Files.readAllLines(fichero);
		}catch (Exception e) {
			System.err.println("Error con el fichero");
			System.out.println(e.getMessage());
		}
		if(lineas!=null) {
			for(String linea:lineas) {
				System.out.println(linea);
				//separamos y metodos 
				//no tenemos que guardar la cabecera del fichero nombre,apellidos,etc...
				String[] campos=linea.split(",");
				
				for(String elemento:campos) {
					
				}
			}
		}		
	}
	
	
	
	
	

	
	
	
	
}
