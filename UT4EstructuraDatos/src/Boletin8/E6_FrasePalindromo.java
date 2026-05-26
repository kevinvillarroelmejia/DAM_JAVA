package Boletin8;

public class E6_FrasePalindromo {

	public static void main(String[] args) {
//		6. EJERCICIO CON FORMATO DE EXAMEN
//		Realiza un programa que lea una frase y nos diga si es un palíndromo o no. Un palíndromo es
//		una palabra o frase que se lee igual hacia adelante que hacia atrás sin tener en cuenta los
//		espacios en blanco ni que los caracteres tengan tilde o estén en mayúsculas.
//		Ejemplos de palíndromos:
//		La ruta nos aporto otro paso natural
//		Atale demoníaco Cain o me delata
//		Para facilitar la codificación se deberán introducir las frases sin tildes, pero si hay que tener
//		en cuenta las mayúsculas y los espacios. Tampoco tendrán signos de puntuación
//		Ejemplo de funcionami ento:
//		Introduce un texto: Dabale arroz a la zorra el abad
//		El texto introducido es un palíndromo
//		No hace falta comprobaciones sobre la entrada (que siempre será una cadena de texto, pero
//		si que es preciso vigilar que a veces puede que haya mas de un espacio entre las palabras o
//		incluso al principio y al final de la frase

		String frase = "La ruta nos aporto otro paso natural";
		if(frasePalindromo(frase)) {
			System.out.println("La frase:\n "+frase+"\nEs palíndromo");
		}else {
			System.out.println("La frase\n: "+frase+"\nNO es palíndromo");

		}
		System.out.println();

	}

	public static boolean frasePalindromo(String frase) {
		String fraseFormateada=frase.trim().toLowerCase();
		String fraseInvertida="";
		String fraseSinEspacios="";
		for(int i=0;i<fraseFormateada.length();i++) {
			if(fraseFormateada.charAt(i)!=' ') {
				fraseSinEspacios=fraseSinEspacios+fraseFormateada.charAt(i);
			}
		}
		boolean bandera=false;
		//TODO FOR INVERTIDO
		for(int i=fraseFormateada.length()-1;i>=0;i--) {
			if(fraseFormateada.charAt(i)!=' ') {
				fraseInvertida=fraseInvertida+fraseFormateada.charAt(i);
			}
		}
		if(fraseInvertida.equalsIgnoreCase(fraseSinEspacios)) {
			bandera=true;
		}
		return bandera;
	}
}
