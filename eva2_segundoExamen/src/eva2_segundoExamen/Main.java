package eva2_segundoExamen;

public class Main {

	public static void main(String[] args) {

		Juego laGamba=new Juego(456);
		//metodo para ver los jugadores.deberian aparecer todos activos
		
		
		
		laGamba.verJugadores();
		
		//primera prueba con 150 eliminaciones
		laGamba.nuevaPrueba(150);
		
		//volver a ver el panel
		laGamba.verJugadores();
		
		//segunda prueba
		laGamba.nuevaPrueba(200);
		
		//Esta no se ejecuta ya que nos pasamos
		laGamba.nuevaPrueba(200);
		
		//ver la informacion de las 3pruebas 
		laGamba.verPruebas();
		
		//solo deberia quedar uno
		laGamba.verJugadores();
		
		
	}

}
