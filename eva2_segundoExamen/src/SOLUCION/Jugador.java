package SOLUCION;

public class Jugador {
	
	private int numero;
	private boolean activo=true;
	
	public Jugador(int codigo) {
	
	}
	
	public boolean getActivo() {
		return this.activo;
	}

	public void setExpulsado() {
		this.activo=false;
	}
}
