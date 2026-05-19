package ejercicio2;

public class Sombra extends Personaje implements Mago,Ladron{

	public Sombra(String nombre) {
		super(nombre);
	}

	@Override
	public boolean sigilo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hechizo() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
