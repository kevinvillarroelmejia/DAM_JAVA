package interfaces;

public interface Jubilada {
	/*ATRIBUTOS
	 * publicos
	 * static
	 * finales
	 * */
	int EDAD_JUBILADOS=67;
	
	
	//el metodo es abstracto por defecto
	//ESTE SE TIENE QUE SOBREESCRIBIR ES ABSTRACTO
	void cuantoMeFalta();
	
	//metodos que pertecen a la interfaz
	//ESTE NO SE PUEDE SOBREESCRIBIR
	static void mePuedoJubilar(int edad) {
		if(edad< EDAD_JUBILADOS) {
			System.out.println("No te puedes jubilar");
		}else {
			System.out.println("Te puedes jubilar");
		}
	}
	
	//los metodos de instancias
	//ESTE ES OPCIONAL SOBREESCRIBIRLO
	default void informacion() {
		System.out.println("Edad corriente de jubilacion: "+ EDAD_JUBILADOS);
	};
	
}
