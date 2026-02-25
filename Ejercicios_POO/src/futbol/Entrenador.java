package futbol;

public class Entrenador extends Persona{
	private Equipo equipo;
	public Entrenador(String nombre,Equipo equipo) {
		super(nombre);
		this.equipo=equipo;
		
		this.equipo.setCambiarEntranador(this);
	}

}
