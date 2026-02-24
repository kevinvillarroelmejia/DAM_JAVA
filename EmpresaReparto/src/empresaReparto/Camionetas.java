package empresaReparto;

public class Camionetas {

	private double pesoMax;
	private double kmMax;
	
	private static Localizacion almacen=new Localizacion(0, 0);
	
	private Ruta ruta=new Ruta();

	public Camionetas(double pesoMax, double kmMax) {
		this.pesoMax = pesoMax;
		this.kmMax = kmMax;
	}

	public void calcularRuta() {
		//Salidas:
		//el peso
		//No tenga paquetes
		//O pase los km maximos
		Paquetes destino=Paquetes.destinoMasCernano(almacen);
		while(destino!=null) {
			ruta.ayadirEntrega(destino);
			Localizacion nuevoOrigen=destino.getLocalizaion();
			Paquetes.borrarDestino(destino);
			destino=Paquetes.destinoMasCernano(nuevoOrigen);
		}
		
	}

	public void mostrarRuta() {
		ruta.mostrarRuta();

	}
}
