package ejercicio2;

public class Personaje {
	protected String nombre;
	protected int fuerza=caracteristicasAletorias();
	protected int inteligencia=caracteristicasAletorias();
	protected int magia=caracteristicasAletorias();
	protected int carisma=caracteristicasAletorias();
	protected int constinuacion=caracteristicasAletorias();
	protected int destreza=caracteristicasAletorias();
	
	public Personaje(String nombre) {
		this.nombre=nombre;
	}
	
	public int caracteristicasAletorias() {
		int azar=(int)(Math.random()*(15-5+1)+5);
		return azar;
	}

	public int getFuerza() {
		return fuerza;
	}

	public String getNombre() {
		return nombre;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public int getMagia() {
		return magia;
	}

	public int getCarisma() {
		return carisma;
	}

	public int getConstinuacion() {
		return constinuacion;
	}

	public int getDestreza() {
		return destreza;
	}
	
	
	
}
