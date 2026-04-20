package Login;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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
				bandera = true;
			} else if (opcion == 2) {
				registrar();
				bandera = true;
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
		Scanner teclado = new Scanner(System.in);
		System.out.println("Usuario: ");
		String usuario = obtenerUsuarioUnico();
		System.out.println("Contraseña: ");
		String contraseña = obtenerContraseya(teclado);
//		System.out.println("INCIAR SESION");
		String salt = generarSalt();
		String saltContra = salt + contraseña;
		String hashString = generarHash(saltContra);

	}

	private static String obtenerContraseya(Scanner teclado) {
		String contraseya="";
		String contraseya2="";
		do {
		System.out.println("Contraseña: ");
		contraseya=teclado.nextLine();
		System.out.println("Repite con contraseña: ");
		contraseya2=teclado.nextLine();
		if(!contraseya.equals(contraseya2)) {
			System.out.println("Las contraseñas no coinciden");
		}
		}while(!contraseya.equals(contraseya2));
		return contraseya;
	}

	private static String obtenerUsuarioUnico() {

		return null;
	}

	public static void registrar() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("-- REGISTRAR NUEVO USUARIO --");
		System.out.println("Nombre NUEVO USUARIO: ");
		String nombreUsuario = teclado.nextLine();
		System.out.println("Contraseña");
	}

	/* por que no utilizar el thowr */
	public static void existeBBDD(String server, String usuario, String passwd) {
		Scanner teclado = new Scanner(System.in);
		try (Connection conexion = DriverManager.getConnection(server, usuario, passwd)) {
			System.out.println("Conexion realizada con exito");
			String query1 = "CREATE DATABASE IF NOT EXIST datosPersonales";
			String query2 = "Use datosPersonales";
			String query3 = "CREATE TABLE IF NOT EXIST credenciales(usuario varchar(50) primary_key, saltTXT varchar(24), hashTXT varchar(88), email varchar(50), privilegios int)";

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

	// funcion que genere el hash
	public static String generarHash(String saltMasContra) {
		MessageDigest digest;
		String hashTXT = null;
		try {
			digest = MessageDigest.getInstance("SHA-521");
			byte[] hash = digest.digest(saltMasContra.getBytes(StandardCharsets.UTF_8));
			hashTXT = Base64.getEncoder().encodeToString(hash);// esa cadena de hast lo convertimos a String legible
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("El algoritmo SHA-512 no esta disponible");
		}
		return hashTXT;
	}

}
