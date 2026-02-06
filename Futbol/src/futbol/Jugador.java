package futbol;

public class Jugador  extends Persona{
	
	private int dorsal=0;
	private Equipo equipo;
	
	public Jugador(String nombre, int dorsal, Equipo equipo) {
		super(nombre);
		this.dorsal=dorsal;
		this.equipo=equipo;
		this.equipo.ayadeJugador(this);
	}
	//jugador sin dorsal
	public Jugador(String nombre) {
		super(nombre);
	}
	
	
	public void mostrarJugador() {
		System.out.println(this.nombre);
		System.out.println(this.dorsal);
		System.out.println(this.equipo.getNombre());
	}

}
