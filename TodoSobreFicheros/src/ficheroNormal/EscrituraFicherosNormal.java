package ficheroNormal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class EscrituraFicherosNormal {

	public static void main(String[] args) {

		
		//EN ESCRITURA ES IMPORTANTE CERRAR EL FileWriter(METODO DE ESCRITURA)
		
				//HAY DOS FORMAS DE ESCRIBIR EN UN FICHERO
				//PARA ESCRIBIR ES COMO EL ( > ) DE LINUX

				//PARA AÑADIR ES COMO EL ( >> ) DE LINUX
				//
				//escribir1();
				//escribir2();
//				escribir3();
//				escribir4();
				escribir5();
			}
			
			/*================================   PRIMER METODO  ==========================================*/
			//este METODO es el menos eficiente
			//Si ya EXISTE el fichero sobreEscribe su contenido
			//el write no mete el \n a menos que nosotros lo pongamos
			//este metodo tiene el modo añadir con el true
			public static void escribir1() {
				try {
					//objeto para apuntar al fichero y poder escribir
					//si le pongo (true) al final te pasa a modo añadir en ves de escribir
					FileWriter pluma=new FileWriter("/home/alumno/Escritorio/ficheroEscritura.txt",true);//con true al final se añade los cambios
					pluma.write("hola mundo en un fichero");
					pluma.close();//TODO IMPORTANTE cerrar el fichero
				}catch (Exception e) {
					System.out.println("error"+e.getMessage());
				}
			}
			//este es el mmismo que el anterior pero con el objeto dentro del try no ahorramos cerrar el close
			public static void escribir1_1() {
				try(FileWriter pluma=new FileWriter("/home/alumno/Escritorio/ficheroEscritura.txt",true)) {
					pluma.write("hola mundo en un fichero");
				}catch (Exception e) {
					System.out.println("error"+e.getMessage());
				}
			}
			
			/*=======================   SEGUNDO METODO   =================================================*/
			// ESTE METODO ES MAS RAPIDO AUN QUE NOSOTROS NO LO NOTEMOS CON POCOS DATOS
			//TODO ESTE METODO TIENE EL MODO AÑADIR CON EL TRUE
			// este motodo tiene una funcion newlinea que es un salto de linea este metodo viene SOLO con BufferedWriter
			public static void escribir2() {
				try(BufferedWriter pluma=new BufferedWriter(new FileWriter("/home/alumno/Escritorio/ficheroEscritura.txt"))) {
					pluma.write("hola mundo en un fichero");
					pluma.newLine(); //esto es un salto de linea
					pluma.write("Segunda linea");
				}catch (Exception e) {
					System.out.println("error"+e.getMessage());
				}
			}
			//este seria el modo añadir pero con el anterior
			public static void escribir2_1() {
				try(BufferedWriter pluma=new BufferedWriter(new FileWriter("/home/alumno/Escritorio/ficheroEscritura.txt",true))) {
					pluma.write("hola mundo en un fichero");
					pluma.write("Segunda linea\n");
				}catch (Exception e) {
					System.out.println("error"+e.getMessage());
				}
			}
			
			
			
			/*=======================   TERCER METODO   =================================================*/
			//TODO metodo escritura con formato
			//lo utilizamos cuando queremos un formato especifico
			// MODO ESCRITURA
			//StandardCharsets.UTF_8 esto se pone para no tener problemas con caracteres espaciales
			public static void escribir3() {
				try(PrintWriter pluma=new PrintWriter(new FileWriter("/home/alumno/Escritorio/ficheroEscritura.txt",true))) {
					pluma.print("Primera linea.");
					pluma.println("Sigo en la segunda linea y salto"); //lo unico que hace es que este tiene un salto de linea
					pluma.println("Segunda linea ");
					String nombre="Ana";
					String apellido="Campos Moro";
					int edad=27	;
					double sueldo=1200;
					pluma.printf ("NOMBRE: %s ,%s. EDAD: %d. SUELDO: %.2f",nombre,apellido,edad,sueldo);
				}catch (Exception e) {
					System.out.println("error"+e.getMessage());
				}
			}

			/*=======================   CUARTO METODO   =================================================*/
			//HASTA AHORA NECESITABAMOS UN FILEWRITER PARA PASAR AL MODO AÑADIR PONIENDO TRUE 
			//este metodo sirve cuando el contenido ya lo tenemos en una lista
			public static void escribir4() {
				Path ruta=Paths.get("/home/alumno/archivo.txt");
				ArrayList<String> lineas=new ArrayList<String>(List.of("Primera linea","Segunda linea","Tercera linea"));
				try {
					//Lo siguiente te lee el arrayList y te lo lo escribe en el fichero
					// para que entre en modo añadir tenemos que poner lo siguiente StandardOpenOption.CREATE,StandardOpenOption.APPEND
					Files.write(ruta, lineas,StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
				}catch (Exception e) {
					System.out.println("error"+e.getMessage());
				}
			}
			
			/*=======================   QUINTO METODO   =================================================*/
			//Como el anterior pero con un String
			public static void escribir5() {
				Path ruta=Paths.get("/home/alumno/archivo.txt");
				String contenido="Hola mundo. ultimo metodo de escritura";
				try {
					Files.writeString(ruta, contenido, StandardCharsets.UTF_8);
					//entra en modo añadir
					Files.writeString(ruta, contenido, StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.APPEND);

				}catch (Exception e) {
					System.out.println("error"+e.getMessage());
				}
			}
	}
