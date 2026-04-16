package Login;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class LoginSaltHash {

	public static void main(String[] args) {
		String usuario="kevin";
		String passwd="abc123";
		
		//Generar Salt
		String salt=generarSalt();
		//Generar Salt
		
		System.out.println(salt); //solo la salt
		System.out.println("Tamaño de la salt: "+salt.length());
		String passwCondSalt=salt+passwd;
		System.out.println(passwCondSalt); //salt mas contraseña
		
		String hash=generarHash(salt+passwd);
	
	}

	//funcion que genere el hash
	public static String generarHash(String saltMasContra){
		MessageDigest digest;
		String hashTXT=null;
		try {
			digest = MessageDigest.getInstance("SHA-521");
			byte[] hash=digest.digest(saltMasContra.getBytes(StandardCharsets.UTF_8));
			hashTXT=Base64.getEncoder().encodeToString(hash);//esa cadena de hast lo convertimos a String legible
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("El algoritmo SHA-512 no esta disponible");
		}
		return hashTXT;
		
		
	}
	public static String generarSalt() {
		SecureRandom azar=new SecureRandom();
		//tamaño del salt
		byte[] salt= new byte[16];
		azar.nextBytes(salt);
		String saltTXT=Base64.getEncoder().encodeToString(salt);
		return saltTXT;
	}

}
