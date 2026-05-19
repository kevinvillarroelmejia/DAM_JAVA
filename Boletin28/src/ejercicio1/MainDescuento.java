package ejercicio1;

public class MainDescuento {
	
	public static void main(String[] args) {
		
		//CONSTANTES QUE NO SE PUEDEN MODIFICAR
		final int DESCUENTO_10_EUROS=1;
		final int DESCUENTO_20_PORCIENTO=2;
		final int SIN_DESCUENTO=3;
		
		Descuento descuento1=(precio,descuento)->{
			double precioFinal=0;
			if(descuento==DESCUENTO_10_EUROS) {
				precioFinal=precio-10;
			}else if (descuento==DESCUENTO_20_PORCIENTO) {
				precioFinal=precio-(precio*0.2);
			}else if (descuento==SIN_DESCUENTO) {
				precioFinal=precio;
			}
			return precioFinal;
		};
		
		System.out.println("Precio final: "+descuento1.descuento(100, DESCUENTO_10_EUROS));
		System.out.println("Precio final: "+descuento1.descuento(300, DESCUENTO_20_PORCIENTO));
		System.out.println("Precio final: "+descuento1.descuento(900, SIN_DESCUENTO));

	}
}
