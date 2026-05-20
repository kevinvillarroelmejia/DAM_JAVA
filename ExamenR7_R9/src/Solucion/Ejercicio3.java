package Solucion;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		
		Carta carta1=new Carta("Black lotus", "Artefacto", 0,"Sacrifica el Black Lotus. Agrega 3 manás de cualquier color a tu pool de maná");
		Carta carta2=new Carta("Luna de Sangre", "Encantamiento", 3, "Todas las tierras no básicas son Montañas");
		Carta carta3=new Carta("Ave del Paraiso", "Criatura", 1, "Vuela. Agrega un maná de cualquier color");
		
		
		carta1.cementerio();
		carta2.mano();
		carta3.cementerio();
		Carta.mostrarCartas();

	}

}
