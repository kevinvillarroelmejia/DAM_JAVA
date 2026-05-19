package ejercicio2;

public class Asesino extends Personaje implements Guerrero,Ladron{

	public Asesino(String nombre) {
		super(nombre);
	}

	@Override
	public int golpear() {
		int fuerzaMasDestreza=getFuerza()+getDestreza();
		int daño=(int)(Math.random()*(fuerzaMasDestreza-5+1)+5);
		return daño;
	}
	public boolean sigilo() {
		return false;
		
	}

}
