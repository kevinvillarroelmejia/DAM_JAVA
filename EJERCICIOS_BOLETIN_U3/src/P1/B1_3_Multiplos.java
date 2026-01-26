package P1;

import java.util.Scanner;

public class B1_3_Multiplos {

	public static void main(String[] args) {

		//===============EJERCICIO 3==============================
		 //Escribir un programa donde se muestren los 5 primeros números múltiplos de
		 //uno dado por el usuario (se introducirá por teclado)
		 //ESTA ES MI SOLUCION PERO LO ENTENDI MAL
		 Scanner multiplo= new Scanner(System.in);
		 int num;
		 for(int i=0; i<5; i++) {
		 System.out.println("TE DIRE SI ES MULTIPLO DE UNO: ");
		 num = multiplo.nextInt();
		 if (num%1==0) {
		 System.out.println(num + " Es multiplo de UNO");
		 }
		 else {
		 System.out.println(num + " No es multiplo de UNO");
		 }
		 multiplo.close();
		 }
			//SOLUCION
		 Scanner multiplo2 = new Scanner(System.in);
		 int numero;
		 System.out.println("Introduce un numero ");
		 numero = multiplo2.nextInt();
		 for (int i =1;i<5;i++) {
		 System.out.println(numero * i);
		 }
		 
		
	}

}
