package gestionFestival;

abstract class Participantes  {
	protected  int numeroID;
	protected String nombre;
	protected String apodo;
	
	public Participantes(int numeroID,String nombre,String apodo) {
		this.numeroID=numeroID;
		this.nombre=nombre;
		this.apodo=apodo;
	}
	public Participantes(int numeroID,String nombre) {
		this.numeroID=numeroID;
		this.nombre=nombre;
	}
}
