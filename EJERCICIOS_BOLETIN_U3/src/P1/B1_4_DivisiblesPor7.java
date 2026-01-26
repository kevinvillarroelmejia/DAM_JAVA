package P1;

public class B1_4_DivisiblesPor7 {

	public static void main(String[] args) {

		// ===============EJERCICIO 4==============================
		// Escribir un programa donde se muestren todos los números divisibles por 7
		// menores a 10000
		for (int i = 0; i < 1000; i++) {
			if (i % 7 == 0) {
				System.out.println(i);
			}
		}
		// SOLUCION 2:
		// podriamos multiplicar por 7 ya que sabemos que es multiplo
		// INCLUSO ESTE ES EL MAS OPTIMO
		for (int i = 1; i < 10000; i++) {
			System.out.println(7 * i);
		}
	}
}
