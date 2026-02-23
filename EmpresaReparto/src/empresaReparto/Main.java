package empresaReparto;

public class Main {

	public static void main(String[] args) {
		
		//borramos las variables por que no vamos a manejar
		//se añaden automaticamente gracias a la funcion
		
		new Paquetes(20.7, 5, 6);
		new Paquetes(2.1, 6, 7);
		new Paquetes(3.5, 10, 15);
		new Paquetes(40.2, 2, 25);

		// Peso max,kms, maximos diarios
		Camionetas c1 = new Camionetas(100, 100);

		c1.calcularRuta();
		c1.mostrarRuta();
		
		Localizacion origen=new Localizacion(0, 0); //la cede desde donde arrancan los camiones
		Paquetes proximo=Paquetes.destinoMasCernano();
	}

}
