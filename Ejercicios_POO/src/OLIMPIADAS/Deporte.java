package OLIMPIADAS;

abstract class Deporte {
	protected String nombreDeporte;
	public Deporte(String nombreDeporte) {
		this.nombreDeporte=nombreDeporte;
	}
	public String getNombreDeporte() {
		return nombreDeporte;
	}
	
}
