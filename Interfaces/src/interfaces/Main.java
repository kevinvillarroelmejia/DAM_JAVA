package interfaces;

public class Main {

	public static void main(String[] args) {
		
		Persona p1=new Persona("Kevin", "Mejia", 25);
		//metodo estatico llamamos a la interfaz para utilizar el metodo
		Jubilada.mePuedoJubilar(57);
		
		//metodo de instancia lo utilizamos a traves del objeto
		p1.informacion();
	}
}
