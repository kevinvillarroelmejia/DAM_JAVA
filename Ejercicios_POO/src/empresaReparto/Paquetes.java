package empresaReparto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Paquetes {

	private double peso;
	private Localizacion localizacion;

	private static ArrayList<Paquetes> listaDePaquetes = new ArrayList<Paquetes>();

	public Paquetes(double peso, int x, int y) {
		this.localizacion = new Localizacion(x, y);
		this.peso = peso;
		listaDePaquetes.add(this); // añadiendo a la lista cada vez creamos un paquete
		// this.localizacion.setX(x);
		// this.localizacion.setY(y);
	}

	public static Paquetes destinoMasCernano(Localizacion punto) {
		// DICCIONARIO
		HashMap<Paquetes, Double> distancias = new HashMap<Paquetes, Double>();
		Paquetes destino = null;
		if (Paquetes.listaDePaquetes.size() != 0) {
			for (Paquetes paquete : listaDePaquetes) {
				// Por cada paquete, calculo la distancia usando la funcion distancia de
				// Lozalicacion
				double distancia = punto.distancia(paquete.localizacion);
				// y meto en el diccionario una entrada nueva con el paquete y su distancia
				distancias.put(paquete, distancia);
			}
		}
		// al final devuelvo el paquete con menor distancia
		double minimo = Double.MAX_VALUE;
		// para encontrar el MENOR VALOR DE LAS ENTREGAS
		for (Map.Entry<Paquetes, Double> entrega : distancias.entrySet()) {
			if (entrega.getValue() < minimo) {
				minimo = entrega.getValue();
				destino = entrega.getKey();
				destino = entrega.getKey();
			}
		}
		return null;
	}

	public int getX() {
		return localizacion.getX();
	}

	public int getY() {
		return localizacion.getY();
	}

	public Localizacion getLocalizaion() {
		return localizacion;
	}

	public static void borrarDestino(Paquetes destino) {
		listaDePaquetes.remove(destino);
	}

}
