package basesDeDatos;

import javax.crypto.*;
import java.security.*;
import java.util.Base64;

public class Ejercicio_Login {

	public static void main(String[] args) {
		String usuario="kevin";
		String passwd="abc123";
		
		//Generar Salt
		//Generar Salt
		SecureRandom azar=new SecureRandom();
		//tamaño del salt
		byte[] salt= new byte[61];
		azar.nextBytes(salt);
		String saltTXT=Base64.getEncoder().encodeToString(salt);
		System.out.println(saltTXT);
		String passwdSalt=saltTXT+passwd;
		System.out.println(passwdSalt);
		
		
		
	}
	

	
	//funcion que genere el hash
	public String generarHash(String saltMasContra) {
		//tamaño fijo
		
		
		return "";
	}
	
}
