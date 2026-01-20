package boletin4;

import java.util.Scanner;

public class B4 {
	public static void main(String[] args) {
		// ================ejercicio 1=============================
		// Escribir un programa que pida un número por teclado y calcule su factorial.
		// Como
		// sabes, la factorial de un número se calcula multiplicando ese número por los
		// sucesivos factores que obtenemos restando uno hasta llegar a la unidad.
		// Por ejemplo, el factorial de 6 (que se representa así 6!) sería este:
		// 6! = 6*5*4*3*2*1 = 720
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.println("introduce numero y te calculo sus factoriales -->");
		int numeroPedido = teclado.nextInt();
		int factorial = 1;
		for (int i = numeroPedido; i >= 1; i--) {// for que genere desde el numero que meto hasta el uno
			factorial = factorial * i; // multiplico por i que va cada vez que entre en el bucle sera un numero menor
		}
		System.out.println(factorial);
		*/
		
		// ================ejercicio 2=============================
		//En matemáticas, la sucesión de Fibonacci se trata de una serie infinita de números
		//naturales. Los dos primeros son siempre el 0 y el 1. Los siguientes se obtienen
		//sumando los dos anteriores. El tercero sería 1 (la suma de 0 + 1), el cuarto sería 2 (la
		//suma de 1 + 1), el quinto 3 (la suma de 1 + 2) y así sucesivamente. La lista con los 10
		//primeros números sería esta: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34].
		//Queremos hacer un programa que reciba un número por teclado y nos calcule tantos
		//números de la sucesión de fibonacci como indique ese número. Por ejemplo, si
		//metemos un 8 la salida de tu programa debería de ser así:
		//0,1,1,2,3,5,8,13
		/*
		Scanner teclado =new Scanner(System.in);
		System.out.println("Cuantos numeros quieres sacar de Fibonacci -->");
		int numero =teclado.nextInt();		
		int num0=0;
		int num1=1;
		for (int i=0 ; i<numero ; i++) { //imprimimos 10 numeros
			System.out.print(num0 + " "); 
			//sumamos los dos anteriores que se van actulizando 
			//por que a num0 se le va asignar el valor antiguo de num1 
			int nuevo=num1+num0; // SUMA DE DOS ANTERIORES
			num0=num1; //el num1 pasa a ser el num0
			num1=nuevo;//y el num1 se guarda el valor que dio de num1+num0
		}
		*/
		// ================ejercicio 3=============================
		//Queremos ahora hacer un programa que reciba un número por teclado y nos muestre
		//en orden todos los números de la sucesión de fibonacci que sean menores o iguales
		//al que has enviado como argumento. Por ejemplo, si metemos el número 4 nos
		//debería de devolver esto:
		//0,1,1,2,3
		/*
		Scanner teclado =new Scanner(System.in);
		System.out.println("Cuantos numeros quieres sacar de Fibonacci -->");
		int numero =teclado.nextInt();		
		int num0=0;
		int num1=1;
		String texto="";
		for (int i=0 ; i<numero ; i++) { //imprimimos 10 numeros
			if(numero>num0) { //si numero es mayor num0 imprime cuando num0 se pase deja de imprimir
				System.out.print(", " + num0);
				// sumamos los dos anteriores que se van actulizando
				// por que a num0 se le va asignar el valor antiguo de num1
				int nuevo = num1 + num0; // SUMA DE DOS ANTERIORES
				num0 = num1; // el num1 pasa a ser el num0
				num1 = nuevo;// y el num1 se guarda el valor que dio de num1+num0
			}
		}
		*/
		/*
		Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número límite --> ");
        int limite = teclado.nextInt();
        teclado.close();
        int num0 = 0;
        int num1 = 1;
        String texto = "0"; // empieza con el primer número

        // mientras el siguiente número sea menor o igual al límite
        while (num1 <= limite) {
            texto = texto+", " + num1;
            int nuevo = num0 + num1;
            num0 = num1;
            num1 = nuevo;
        }
        System.out.println(texto);
		 */
		
		// ================ejercicio 4=============================
		//Escribir un programa que cuente el número de cifras que tiene un número (por
		//ejemplo, el 8 tiene una cifra, el 221 tres y el 456789 seis).
		
		/*
		int numero=200;
		String numeroRecorrido=String.valueOf(numero);
		int contador=0;
		for(int i=0; i<numeroRecorrido.length(); i++) {
			contador++;
		}
		System.out.println(contador);
		*/
		
		// ================ejercicio 5=============================
		//Escribir un programa que nos diga si un número es capicúa.
		//UN NUMERO CAPICUA ES SI SE LEE IGUAL DEL DERECHO Y DEL REVES POR EJMPLO:
		//818 111 232
		//para resolver esto tenemos que convertir a String para darle la vuelta
		//luego de darle la vuelta lo volvemos a convertir a int 
		//y ese int lo comparamos con int que pasamos por teclado
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("introduce numero y te dire si es CAPICUA --> ");
		int numeroPedido=teclado.nextInt();
		teclado.close();//cerramos el teclado
		
		String numeroTexto=String.valueOf(numeroPedido);//convertir de numero a texto
		String alReves ="";//cadena vacia para introducir el texto al reves
		
		//recoremos la cadena al reves -1 por que queremos la ultima posicion
		//y se para cuando sea menor que 0
		for(int i=numeroTexto.length()-1; i>=0; i--) {
			alReves = alReves + numeroTexto.charAt(i);//introducimos la cadena al reves en la variable
		}
		int numeroInt=Integer.parseInt(alReves);//convertir de texto a numero
		if(numeroInt==numeroPedido) { //COMPARACION DEL NUMERO PEDIDO Y EL NUMERO CONVERTIDO
			System.out.println("EL NUMERO " +numeroPedido+ " ES CAPICUA");
		}else {
			System.out.println("EL NUMERO NOOO " +numeroPedido+ " ES CAPICUA\"");
		}
		
		
		// ================ejercicio 6=============================
		//Escribir un programa que muestre por pantalla 
		//los 50 primeros números primos, 
		//sus raíces cuadradas, 
		//sus cuadrados 
		//sus cubos
		
		int numero = 2;
		// NUMERO AL AZAR ES PRIMO O NO??
		int contador = 0;
		for (contador = 0; contador < 50; contador++) { //LOS 50 PRIMEROS NUMEROS PRIMOS
			boolean esPrimo;
			// APARTIR DE AQUI COMPROBAMOS SI UN NUMERO ES PRIMO
			do {
				int raiz = (int) Math.sqrt(numero) * 1;// calcula la raiz cuadrada de un numero
				esPrimo = true;
				if (numero % 2 != 0) {// si es impar
					for (int i = 2; i < raiz; i++) {
						if (numero % i == 0) {
							esPrimo = false;
						}
					}
				}
				if (esPrimo == false) {
					numero++;
				}
			} while (esPrimo == false);
			System.out.println(numero + " es primo");
			//SACANDO RAIZ - CUADRADO- CUBO
			double numeroRaiz=Math.sqrt(numero);
			int cuadrado=numero*numero;
			int cubo=numero*numero*numero;
			System.out.println(numero +" |RaizCuadra --> " +numeroRaiz+" |Cuadrado --> "+ cuadrado+" |Cubo--> "+cubo);
			numero++; // 
		}
		
		// ================ejercicio 7=============================
		//Decimos que dos números primos son gemelos cuando están separados por un único
		//número (el 11 y el 13, el 17 y el 19, el 41 y el 43, etc.). Escribir un programa que calcule
		//la primera pareja de primos gemelos por encima del 50
		/*
		int numero = 150;
		int anterior=0;
		boolean gemelosEncontrado = false;
		while (gemelosEncontrado == false) {
			boolean esPrimo;

			do {
				int raiz = (int) Math.sqrt(numero) * 1;// calcula la raiz cuadrada de un numero
				esPrimo = true;
				if (numero % 2 != 0) {// si es impar
					for (int i = 2; i < raiz; i++) {
						if (numero % i == 0) {
							esPrimo = false;
						}
					}
				}
				if (esPrimo == false) {
					numero++;
				}
			} while (esPrimo == false);
			// si el numero primo encontrado tiene una diferencia de uno
			if (numero - anterior == 2) {
				gemelosEncontrado = true;
			} else {

			}
		}
		*/
		// ================ejercicio 8=============================
		//Escribe un programa que sume por un lado las cifras pares y por otro las impares de
		//un número y nos muestre ambos resultados. Por ejemplo, si el número en cuestión es
		//el 128 nos debería e decir que la suma de las cifras pares es 9 y la de las impares 2
		/*
		int numero =3221; //numero entregado
		//las inicializamos fuera para poderse utilizar tanto fuera del bucle como dentro
		int pares=0;
		int impares=0;
		//LO CONVERTIMOS A TEXTO PARA PODERSE RECORRER
		String convertido=String.valueOf(numero);
		for(int i=0;i<convertido.length();i++) {
			if(i%2==0) {
				pares=pares+i;
			}else {
				impares=impares+i;
			}
		}
		System.out.println("PARES --> " +pares);
		System.out.println("IMPARES --> "+impares);
		*/
		
		// ================ejercicio 9=============================
		//Escribir un programa que nos pida por teclado primero una cadena y luego un
		//carácter. A continuación debe de imprimirnos cuantas veces aparece dicho carácter y
		//en las posiciones de la cadena donde lo hace. Por ejemplo, si nuestra cadena es Hola
		//Mundo y el carácter la o nos debería de decir algo así:
		//La o aparece en 2 ocasiones
		//Las posiciones en las que aparece son: 1,9
		/*
		Scanner teclado = new Scanner(System.in);

		System.out.println("INTRODUCE TEXTO");
		String texto = teclado.nextLine();

		System.out.print("INTRODUCE CARACTER --> ");
		String caracter = teclado.nextLine();

		teclado.close();

		int contador = 0;

		// CON ESTE FOR E IF COMPROBAMOS CUANTAS VECES APARECE UN CARACTER
		for (int i = 0; i < texto.length(); i++) {
			// comparacion de chart // .charAt(0) 0 por que como solo es un caracter
			if (texto.charAt(i) == caracter.charAt(0)) {
				contador++;
			}
		}
		System.out.println("EL CARACTER " + caracter + " APARECIO " + contador + " VECES");
		// PARA CONTAR PONER LAS POSICIONES SIN COMA AL FINAL
		// POR QUE TIENE QUE SALIR SI O SI ASI --> 1,9
//		int contadorPosiciones=0;
		String posciones = "";
		System.out.print("LAS POSICIONES EN LAS QUE APARECE SON --> ");
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == caracter.charAt(0)) {
//				contadorPosiciones++;
//				System.out.print(i);
//				if(contadorPosiciones!=contador) {
//					System.out.println(", ");
//				}
				posciones = posciones + i + ", "; //ESTO SERIA IGUAL QUE LAS LINEAS COMENTADAS ANTES
			}
		}//CORTAMOS Y MOSTRAMOS SOLO DESDE EL PRINCIPIO Y CORTAMOS EL ESPACIO Y LA COMA --> DOS CARACTERES ", "
		//POR ESO RESTAMOS -2 
		posciones = posciones.substring(0, posciones.length() - 2);
		System.out.println(posciones);
		*/
		
		// ================ejercicio 10=============================
		//Escribir un programa que nos pida una cadena por teclado y luego nos imprima sólo
		//las cifras que aparecen en ella.
		//Por ejemplo, si introducimos la cadena “Beverly Hills, 5. CP: 28934” Debería
		//devolvernos: 528934
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("INTRODUCE TEXTO CON NUMERO --> ");
		String cadenaTexto=teclado.nextLine();
		teclado.close();//cerramos por que ya no lo vamos a utilizar mas
		System.out.print("Los numeros del texto son--> ");
		for(int i=0;i<cadenaTexto.length();i++) { //RECOREMOS EL TEXTO Y
			switch(cadenaTexto.charAt(i)) {//SI EL CONTENIDO DE LA i
			case '0','1','2','3','4','5','6','7','8','9': //ES ENTRE 0 Y 9
				System.out.print(cadenaTexto.charAt(i));  //LA IMPRIMES
				break;
				default:
					System.out.println("TU TEXTO NO TIENE NUMEROS");
			}
		}
		*/
		
		
		// ================ejercicio 11=============================
		//Escribir un programa que nos pida una frase por teclado y luego nos la imprima
		//separando todos los caracteres de sus palabras (excepto los espacios) con un guión.
		//Por ejemplo, si la frase introducida es “esto es una prueba” la salida del programa
		//debería de ser “e-s-t-o e-s u-n-a p-r-u-e-b-a”
		/*String texto="programando en java";
		String textoPares="";
		for(int i=0;i<texto.length();i++) {//recoremos la cadena
				textoPares=textoPares +"-"+ texto.charAt(i);//accedemos a la letra y la añadimos a textoPares
				//con esto soluciono el guion del inicio
				if(i==0) {
					textoPares=textoPares.substring(1);
				}
				textoPares=textoPares.replace("- -", " ");
			}
		
		System.out.print(textoPares);
		*/
		/////////////SOLUCION DEL PROFE/////////////
		/*
		String texto="programando en java";
		String textoPares=""+ texto.charAt(0);
		for(int i=1;i<texto.length();i++) {//recoremos la cadena
				textoPares=textoPares +"-"+ texto.charAt(i);//accedemos a la letra y la añadimos a textoPares
				//con esto soluciono el guion del inicio
				
				textoPares=textoPares.replace("- -", " ");
			}
		System.out.print(textoPares);
		*/
		
		
		
		// ================ejercicio 12=============================
		//Crear un programa que lea un número de año por teclado e indique si es bisiesto o
		//no. Un año bisiesto es aquel que es divisible por 4, siempre y cuando no lo sea por
		//100. La excepción a esta regla son los años múltiplos de 400, que siempre son
		//bisiestos.
		
		
		
		
		//// ================ejercicio 13=============================
		//Hacer un programa que lea un número y un carácter y visualice una matriz compacta
		//repitiendo ese carácter y con tantas filas y columnas como indique el número. Por
		//ejemplo, si metemos el 4 y la x nos debería de mostrar esto
		//xxxx
		//xxxx
		//xxxx
		//xxxx		
		/*
		System.out.println("introduce un caracter: ");
		String caracter =teclado.nextLine();
		
		System.out.println("Introduce un numero de repeticiones: ");
		int repeticiones =teclado.nextInt();
		teclado.close();
		
		String linea="";
		for(int i=0; i<repeticiones ; i++) {
			linea=linea+caracter; 
		}
		for(int i=0; i<repeticiones ; i++) {
			System.out.println(linea);
		}
		*/
		
		
		//cuando tengo que repetir algo y luego ese algo lo tengo que repetir
		//esto seria lo mismo que los dos for que los de atras
		
		/*for(int i=0; i<repeticiones ; i++) {
			for(int j=0; j<repeticiones ; j++) {
				System.out.print(caracter);
			}
			System.out.println();//salto de linea con println
		}
		*/
		
		
		// ================ejercicio 14=============================
		//Escribe un programa que lea una hora por teclado en formato 24 horas (HH:MM). 
		//Tu programa debería de decir si corresponde a la mañana (entre las 6 y las 11, ambas
		//inclusive), si es una hora de la tarde (entre las 12 y las 19, ambas inclusive), si es de la
		//noche (entre las 20 y las 23, ambas inclusive), si es de la madrugada (entre las 0 y las
		//5, ambas inclusive) o bien, si el formato no es correcto o no se corresponde con una
		//hora real (minutos de mas de 60, horas negativas o por encima de 23, etc.
		
		//SOLUCION DEL PROFE --VALIDACION DE UNA CADENA 
		// QUE COSAS TENGO QUE VALIDAR
		//1.-Longitud==5
		//2.-Caracter de separacion ==':'
		//3.-horas entre 0>= <=23
		//4.- Minutos entre 0>= <=59
		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("INTRODUCE HORA EN FORMATO MM:HH --> ");
		String hora= teclado.nextLine();
		teclado.close();
		boolean bandera=true; //bandera
		int hhEntero=0;
		int mmEntero=0;
		if(hora.length()==5 && hora.charAt(2)==':' && hhEntero>=0 && hhEntero<=23 && mmEntero>=0 && mmEntero<=59)	{	
				hhEntero=Integer.parseInt(hora.substring(0,2)); //CORTAMOS LAS HORAS Y LAS CONVERTIMOS A INT
				mmEntero=Integer.parseInt(hora.substring(3,5)); //CORTAMOS LOS MINUTOS Y LOS CONVERTIMOS A INT
				}else {
					bandera=false; //SI NO SE CUMPLE LO DEL IF BANDERA ES IGUAL A FALSE SALTA AL ELSE QUE ESTA DEBAJO
				}
		if(bandera=true) { 
			System.out.println("la hora " + hora+" esta en un formato correcto");
			if(hhEntero>=06 && hhEntero<=11)	{
				System.out.println("Las "+hora+" es por la mañana");
			}
			else if(hhEntero>=12 && hhEntero<=19) {
				System.out.println("Las "+hora+" es por la tarde");
			}
			else if(hhEntero>=20 && hhEntero<=23) {
				System.out.println("Las "+hora+" es por la noche");
			}
			else if(hhEntero>=00 && hhEntero<=05) {
				System.out.println("Las "+hora+" es de madrugada");
			}
		}else {
			System.out.println("la hora " + hora+" esta en un formato INCORRECTO");
		}
		*/
		
		
		///ESTO ES UNA ESTA BIEN HASTA QUE ENTRA EN EL IF QUE SE PUEDE UNIR TODO Y AHORRARTE VARIAS LINEAS DE CODIGO
		/*if(hora.length()==5)	{
			if(hora.charAt(2)==':') {
				String hh=hora.substring(0,2);//extraemos las horas
				String mm=hora.substring(3,5);//extraemos los minutos
				int hhEntero=Integer.parseInt(hh); //conversion se horas a enteros
				int mmEntero=Integer.parseInt(mm);//conversion se minutos a enteros
				
				//ESTO ES LO MISMO QUE LO DE ARRIBA COMENRADO
				hhEntero=Integer.parseInt(hora.substring(0,2)); //CORTAMOS LAS HORAS Y LAS CONVERTIMOS A INT
				int mmEntero=Integer.parseInt(hora.substring(3,5)); //CORTAMOS LOS MINUTOS Y LOS CONVERTIMOS A INT
				if(hhEntero>=0 && hhEntero<=23) {
					if(mmEntero>=0 && mmEntero<=59) {
						bandera=true;
					}
					else {
						bandera =false;
					}
				}else {
					bandera =false;
				}
			}
			
			else {
				bandera=false;
			}
		}
		else {
			bandera=false;
		}
		if(bandera=true) {
			System.out.println("la hora " + hora+" esta en un formato correcto");
			if(hhEntero>=06 && hhEntero<=11)	{
				System.out.println("Las "+hora+" es por la mañana");
			}
			else if(hhEntero>=12 && hhEntero<=19) {
				System.out.println("Las "+hora+" es por la tarde");
			}
			else if(hhEntero>=20 && hhEntero<=23) {
				System.out.println("Las "+hora+" es por la noche");
			}
			else if(hhEntero>=00 && hhEntero<=05) {
				System.out.println("Las "+hora+" es de madrugada");
			}		}else {
			System.out.println("la hora " + hora+" esta en un formato incorrecto");
		}
		*/
		
		// ================ejercicio 15=============================
		//Escribe un programa que reciba por teclado una fecha en el formato DD/MM/YYYY. El
		//programa debe de comprobar si la fecha es correcta teniendo en cuenta:
		//Qué el formato sea el correcto
		//Que la fecha sea totalmente válida teniendo en cuenta incluso los años que son
		//bisiestos (aquellos que son divisibles entre cuatro).
		//VAMOS A RESOLVER ESTO SEGUN LO QUE SABEMOS
		
		/*
		String fecha="22/11/2024";
		boolean fechaCorrecta=true;
		if(fecha.length()!=10) {
			fechaCorrecta=false;
			// operacion OR || SI O SI tiene que tener las dos / /
			//si una de las dos condiciones no se cumplen no es una fecha
		}else if(fecha.charAt(2)!='/' || fecha.charAt(5) !='/'){ 
			fechaCorrecta=false;
		}else {
			int dia =Integer.parseInt(fecha.substring(0,2));
			int mes =Integer.parseInt(fecha.substring(3,5));
			if(dia<1 || dia >31) {
				fechaCorrecta=false;
			}else if(mes<1 || mes >12){
				fechaCorrecta =false;
			}
		}

		//comprobacion DE QUE APROBO todas las banderas
		if(fechaCorrecta==true) {
			System.out.println("la fecha " +fecha+" es correcta");
		}else {
			System.out.println("INCORRECTA");
		}
		*/
		
		//Suma de los números del 1 al 100 (método de Gauss).
		/*
		int inicio =1;
		int fin=100;
		int resultado=0;
		resultado=((inicio+fin)*100)/2;
		System.out.println(resultado);
		*/
	}
}





