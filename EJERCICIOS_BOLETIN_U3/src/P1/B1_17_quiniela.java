package P1;

public class B1_17_quiniela {

	public static void main(String[] args) {

		// ===============EJERCICIO 17==============================
		// Escribir un programa que nos permita generar una quiniela. Para ello nos debe
		// generar
		// quince números aleatorios entre el 1 y el 3. Recuerda que los resultados
		// válidos son 1 X o 2,
		// así que si te sale un 3 lo que tienes que imprimir en pantalla es una X
		int inicio = 1;
		int fin = 3;
		int quinceNum;
		for (int i = 0; i < 15; i++) { // generamos 15 numeros
			quinceNum = (int) (Math.random() * (fin - inicio + 1) + inicio); // que sean entre 1 y 3
			if (quinceNum == 3) { // esos 15 numeros alguno es 3 que saque 3
				System.out.println("X");
			} else if (quinceNum != 3) { // si es diferente a 3 que saque los que puede que son 1 o 2
				System.out.println(quinceNum);
			}
		}
	}
}
