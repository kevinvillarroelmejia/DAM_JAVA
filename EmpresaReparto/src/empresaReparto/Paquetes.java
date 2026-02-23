package empresaReparto;

import java.util.ArrayList;

public class Paquetes {

	private double peso;
	private Localizacion localizacion;

	private static ArrayList<Paquetes> listaDePaquetes = new ArrayList<Paquetes>();

	public Paquetes(double peso, int x, int y) {
		this.localizacion = new Localizacion(x, y);
		this.peso = peso;
		
		listaDePaquetes.add(this); //añadiendo a la lista cada vez creamos un paquete

		//this.localizacion.setX(x);
		//this.localizacion.setY(y);
	}

	public static Paquetes destinoMasCernano() {
		
		
		return null;
	}

}
