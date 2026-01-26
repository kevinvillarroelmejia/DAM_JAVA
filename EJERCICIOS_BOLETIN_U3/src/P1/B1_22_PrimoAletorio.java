package P1;

public class B1_22_PrimoAletorio {

	public static void main(String[] args) {

		//===============EJERCICIO 22==============================
		//Escribir un programa que genere un número primo aleatorio entre el 10.000.000 y el
		//50.000.000
		boolean esPrimo; //variable como bandera
		int azar;
		//este algoritmo es el peor codigo que podemos hacer pero funciona
		do {
			azar =(int) (Math.random()*(400000000+1))+100000000; //generar numero aleatorio
			int raiz=(int)Math.sqrt(azar)+1; 
			esPrimo=true; // estamos dando vuelta 
			System.out.println("Probando el numero "+ azar+ "...");
		//empezamos por 3 por que por 0 no se puede dividir y por 1 tampoco
		//por que es primo y el 2 es el unico primo
			if (azar%2==0)
				esPrimo=false;//con esto me aseguro que el numero generado sea IMPAR
			//divisor<azar && esPrimo==true dos condiciones que se tienen que cumplir
			//con el += son saltamos los pares
			for(int divisor=3; divisor<raiz && esPrimo==true; divisor+=2) {
				if (azar%divisor==0) {
					esPrimo=false;	
				}
			}
		}while(esPrimo == false);
		System.out.println("El numero " + azar + " es primo" );
				
	}
}
