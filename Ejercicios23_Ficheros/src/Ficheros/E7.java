package Ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class E7 {

	public static void main(String[] args) {
		
		String fichero="/home/alumno/credenciales";
//		HashMap<String, String> diccionario=leerFichero();
		HashMap<String, String> diccionario=leerFichero(fichero); //devolviendo el fichero
		comprobarUsuario(diccionario);
	}
	public static HashMap<String, String> leerFichero(String ruta){
		HashMap<String, String> diccionario=new HashMap<String, String>();
		try (BufferedReader lector=new BufferedReader(new FileReader(ruta))){
			String linea;
			while((linea=lector.readLine())!=null) {
				int posicion=linea.indexOf(':');
				diccionario.put(linea.substring(0,posicion),linea.substring(posicion+1));		
			}
			if(diccionario.size()==0) {
				System.out.println("Fichero vacio");
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Fichero inexsistente o imposible de leer");
		}
		return diccionario;
	}

	public static void comprobarUsuario(HashMap<String, String> diccionario) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Usuario: ");
		String usuario=teclado.nextLine();
		System.out.println("Contraseña: ");
		String contraseña=teclado.nextLine();
		teclado.close();
		if(!diccionario.containsKey(usuario)) {
			System.out.println("Usuario no encontrado");
		}else if(!diccionario.get(usuario).equals(contraseña)){ //explicacion sobre esto
			System.out.println("Contraseña incorrecta");
		}else {
			System.out.println("Usuario y contraseñas correctas");
		}
	}
	public static void nuevoUsuario() {
		
	}
	
	
}
