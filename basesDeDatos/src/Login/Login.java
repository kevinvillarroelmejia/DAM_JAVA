package Login;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Base64;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		String usuario = "admin";
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/";
		mostrarMenu();
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		existeBBDD(server, usuario, password);

		boolean bandera = false;
		do {
			System.out.println("Introducir opcion;");
			opcion = teclado.nextInt();

			if (opcion != 1 && opcion != 2) {
				System.out.println("Opcion no valida");
			} else if (opcion == 1) {
				iniciarSesion();
				bandera=true;
			} else if (opcion == 2) {
				registrar();
				bandera=true;
			}
		} while (bandera == false);

	}

	public static void mostrarMenu() {
		System.out.println("+=======================+");
		System.out.println("+====== 1.- Login ======+");
		System.out.println("+==== 2.- Registro =====+");
		System.out.println("+=======================+");
	}

	public static void iniciarSesion() {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Usuario: ");
		String usuario=teclado.nextLine();
		System.out.println("Contraseña: ");
		String contraseña=teclado.nextLine();
//		System.out.println("INCIAR SESION");
		String salt=generarSalt();
		
	}

	public static void registrar() {
		System.out.println("REGISTRAR");
	}

	public static void existeBBDD(String server, String usuario, String passwd) {
		try (Connection conexion = DriverManager.getConnection(server, usuario, passwd)) {// la coneccion la hacemos
																							// aqui){
			System.out.println("Conexion realizada con exito");
			String query1 = "CREATE DATABASE IF NOT EXIST datosPersonales";
			String query2 = "Use datosPersonales";
			String query3 = "CREATE TABLE IF NOT EXIST credenciales(usuario varchar(50), saltTXT varchar(50), hashTXT varchar(128), email varchar(50), privilegios int)";

			Statement consulta = conexion.createStatement();
			consulta.executeUpdate(query1);
			consulta.executeUpdate(query2);
			consulta.executeUpdate(query3);
		} catch (Exception e) {
			System.out.println("ERROR CREACION BASE DE DATOS");
		}

	}

	public static String generarSalt() {
		SecureRandom azar = new SecureRandom();
		// tamaño del salt
		byte[] salt = new byte[16];
		azar.nextBytes(salt);
		String saltTXT = Base64.getEncoder().encodeToString(salt);
		return saltTXT;
	}

}
