package Ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class E7 {

	public static void main(String[] args) {
		
		String fichero="/home/alumno/credenciales";
		HashMap<String, String> diccionario=leerFichero(fichero); //devolviendo el fichero
		nuevoUsuario(diccionario,fichero);
		diccionario=leerFichero(fichero);
		comprobarUsuario(diccionario);

	}
	public static HashMap<String, String> leerFichero(String ruta){
		HashMap<String, String> diccionario=new HashMap<String, String>();
		try (BufferedReader lector=new BufferedReader(new FileReader(ruta))){
			String linea="";
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
		System.out.println("Comprobando Usuario: ");
		String usuario=teclado.nextLine();
		

		System.out.println("Introduzca su Contraseña: ");
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
	//AÑADIENDO EL NUEVO FICHERO 
	public static void grabarEnFichero(String usuarios,String constrasena,String fichero) {
		System.out.println("Grabando en el fichero");
		try(PrintWriter escritor=new PrintWriter(new FileWriter(fichero,true))){
			escritor.printf("%s:%s",usuarios,constrasena);
			escritor.println();//salto de linea
		}catch (Exception e) {
			e.getMessage();
		}
	}

	/*AÑADIENDO NUEVO USUARIO COMPROBADO QUE NO EXISTE Y QUE EL USUARIO O LA CONSTRASEÑA NO TIENEN EL CARACTER : */
	public static void nuevoUsuario(HashMap<String, String> diccionario,String fichero) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Nuevo Usuario: ");
		String usuario=teclado.nextLine();
		System.out.println("Introduzca su Contraseña: ");
		String contraseña=teclado.nextLine();
		System.out.println("Confirma la Contraseña: ");
		String contraseñaRepetida=teclado.nextLine();
		teclado.close();
		
		if(!contraseña.equals(contraseñaRepetida)) {
			System.out.println("Las constraseñas son diferentes");
		}else if(diccionario.containsKey(usuario)){
			System.out.println("Usuario ya existe");
		}else if(usuario.indexOf(':')>=0 || contraseña.indexOf(':')>=0) { //si no encuntra :  devolvera -1
			System.out.println("Ni el usuario o la contraseña puedemn tener el caracter ':'");
		}else{
			grabarEnFichero(usuario,contraseña,fichero);
		}
	}
	
	
	
}
