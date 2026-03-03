package expreciones_regulares;

public class expreciones_regulares {

	public static void main(String[] args) {
		/* === EXPRESIONES REGULARES === */
		//System.out.println("hola mundo\nkevin"); //salto de linea \n
		//si yo quiero poner una (\) barra pongo dos ya que si pongo una me pide una letra reservada
		//		System.out.println("esto es una \\ barra"); 
		// \d --> 
		// \\d{9} --> 8 digitos seguidos 
		// [0-9]{9} --> 8 digitos y que se repita 8 veces
		// [6-8][0-9] {8} --> 
		// EL PATRON Y EL MATCHER VAN DE LA MANO
		
		/*
		Pattern patron=Pattern.compile("[6-8][0-9]{8}");
		//Pattern patron = Pattern.compile("\\d{9}");
		
		
		Matcher coincidencia =patron.matcher("655334455"); //9 digitos
		//el numero cuadra con el patron?
		if(coincidencia.find()==true) { // 
			System.out.println("Es un numero de telefonos valido");
		}else {
			System.out.println("no es un numero de telefono valido");
		}
		*/
		// METODO MAS FACIL
		String telefono ="6655445566";
		//si este patron coincide con el numero del telefono
		//[6-8] el primer digito tiene que ser 6-7-8 por que los numeros empiezan por 6,7 o 8
		//[0-9] numeros del 0-9
		//{8} 
		if(telefono.matches("[6-8][0-9]{8}")==true) {
			System.out.println("telefono valido");
		}else {
			System.out.println("telefono NO valido");
		}
		
		//[A-Z a-z Ññ] {3}
		//PATRON DNI [0-9]{8}[A-Z]
		//PATRON MATRICULA [0-9]{4}\\s[A-Z a-z&&[^AEIOUQ]]{3}
		//.find() //mira si encuentra el patron
		//.matches() //tiene que coincidir EXACTAMENTE
		
		//[A-Z]? <-- con este patron solo puede salir una letra
		//[0-9]{8}[A-Z]? //dni con una letra
		//[A-Z]* //de la A ->Z puede apacer muchas veces
		//[A-Z]+ //una o muchas si no tiene letras es falso
		//[A-Z]{3,} // al menos 3 letras
		//[A-Z]{3,8} // entre 3 y 8 letras
		
		/*
		--------------------- REGEX EN JAVA (RESUMEN) ---------------------

		► CLASES DE CARACTERES
		[abc] -> a o b o c
		[^abc] -> todo menos a, b, c
		[a-c] -> de a a c
		[a-c[f-h]] -> unión (a, b, c, f, g, h)
		[a-c&&[b-c]] -> intersección (b, c)
		[a-c&&[^b-c]] -> resta (a)

		► CLASES PREDEFINIDAS
		.  -> cualquier carácter
		\d -> dígito [0-9]
		\D -> no dígito
		\s -> espacio en blanco
		\S -> no espacio
		\w -> carácter de palabra [a-zA-Z_0-9]
		\W -> no palabra

		► LÍMITES
		^ -> inicio de línea
		$ -> fin de línea
		\b -> límite de palabra
		\B -> no límite de palabra
		\A -> inicio del texto
		\Z -> fin del texto (excepto terminador)
		\z -> fin absoluto del texto

		► CLASE Pattern
		Pattern.compile(regex) -> compila la expresión regular
		Pattern.matches(regex, texto) -> verifica coincidencia total
		pattern.split(texto) -> separa texto por el patrón
		pattern.asPredicate() -> crea predicado para comprobar cadenas

		► CLASE Matcher
		matches() -> intenta coincidir todo el texto
		find() -> busca la siguiente coincidencia
		start(), end() -> índices del resultado

		► OPERADORES LÓGICOS
		XY -> X seguido de Y
		X|Y -> X o Y

		► GRUPOS Y REFERENCIAS
		(...) -> define grupo
		\1 -> referencia al grupo anterior
		Ej: (\d\d)/\1 -> repite dos dígitos

		► CUANTIFICADORES
		X?  -> 0 o 1 vez
		X*  -> 0 o más veces
		X+  -> 1 o más veces
		X{n} -> exactamente n
		X{n,} -> al menos n
		X{n,m} -> entre n y m

		Modos:
		Greedy -> lo más largo posible
		Reluctant -> lo más corto posible
		Possessive -> no retrocede

		► FLAGS DE PATRONES
		CASE_INSENSITIVE -> ignora mayúsculas/minúsculas
		COMMENTS -> ignora espacios y comentarios con #
		MULTILINE -> permite varias líneas
		UNIX_LINES -> solo reconoce '\n'

		---------------------------------------------------------------
		*/

		
	}
}