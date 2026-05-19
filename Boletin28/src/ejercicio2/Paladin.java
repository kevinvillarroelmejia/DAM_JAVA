package ejercicio2;

public class Paladin extends Personaje implements Guerrero{

	public Paladin(String nombre) {
		super(nombre);
	}

	@Override
	public int golpear() {
		return 0;
	}

}
