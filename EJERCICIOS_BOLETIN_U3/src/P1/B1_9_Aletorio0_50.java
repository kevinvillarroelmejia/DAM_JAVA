package P1;

public class B1_9_Aletorio0_50 {

	public static void main(String[] args) {

		// ===============EJERCICIO 9=============================
		// Escribir un programa que genere un número aleatorio entre el 0 y el 50 y lo
		// muestre
		int inicio = 0;
		int fin = 50;
		int aleatorio = (int) (Math.random() * (fin - inicio + 1)) + inicio;
		System.out.println(aleatorio);

		// FORMULA PARA GENERAR UN NUMERO ENTRE UN INICIO Y UN FIN
		// (int)(Math.random()*(fin-inicio+1))+inicio;

	}

}
