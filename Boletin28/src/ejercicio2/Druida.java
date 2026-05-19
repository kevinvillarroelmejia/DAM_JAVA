package ejercicio2;

public class Druida extends Personaje implements Guerrero, Mago {

	public Druida(String nombre) {
		super(nombre);
	}

	@Override
	public int hechizo() {
		return 0;
	}

	@Override
	public int golpear() {
		int fuerzaMasDestreza = getFuerza() + getDestreza();
		int daño = (int) (Math.random() * (fuerzaMasDestreza - 5 + 1) + 5);
		return daño;
	}

}
