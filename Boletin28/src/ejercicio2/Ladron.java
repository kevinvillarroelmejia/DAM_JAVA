package ejercicio2;

public interface Ladron {
	 

	boolean sigilo();
	
	default int movimiento() {
		return 6;
	}
}
