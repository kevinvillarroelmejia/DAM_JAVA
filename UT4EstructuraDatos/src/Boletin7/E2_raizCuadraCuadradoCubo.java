package Boletin7;

import java.util.Scanner;

public class E2_raizCuadraCuadradoCubo {

	public static void main(String[] args) {

		// 2. Incluye operaciones adicionales (raiz cuadrada, cuadrado, cubo, por
		// ejemplo)
		Scanner teclado = new Scanner(System.in);


		System.out.println("Que operacion quieres hacer: \n" 
		+ "S -> sumar\n" 
		+ "R -> restar\n" 
		+ "M -> multiplicar\n"
		+ "S -> sumar\n" 
		+ "R -> restar\n" 
		+ "M -> multiplicar\n" 
		+ "D -> dividir \n" 
		+ "Z -> Raiz cuadrada\n"
		+ "O -> Cuadrado" + "E -> Cubo\n");
		String operacion = teclado.nextLine().toUpperCase();
		int resultado = 0;
		if (operacion.equals("S") || operacion.equals("R") || operacion.equals("M") || operacion.equals("D")) {
			System.out.println("Introduce numero 1:");
			int numero1 = teclado.nextInt();
			System.out.println("Introduce numero 2:");
			int numero2 = teclado.nextInt();
			switch (operacion) {
			case "S":
				resultado = numero1 + numero2;
				break;
			case "R":
				resultado = numero1 - numero2;
				break;
			case "M":
				resultado = numero1 * numero2;
				break;
			case "D":
				resultado = numero1 / numero2;
				break;
			}
		} else {
			System.out.println("Introduce numero 1:");
			int numero1 = teclado.nextInt();
			switch (operacion) {
		case "Z":
			resultado = (int)Math.sqrt(numero1);
			break;
		case "O":
			resultado = (int)Math.pow(numero1, 2);
			break;
		case "E":
			resultado = (int)Math.pow(numero1, 3);;
			break;
		}

		}

		System.out.println("El resultado es " + resultado);

	}
}
