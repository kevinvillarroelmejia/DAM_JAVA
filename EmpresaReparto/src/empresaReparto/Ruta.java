package empresaReparto;

import java.util.ArrayList;

public class Ruta {

	private ArrayList<Paquetes> rutaPaquetes=new ArrayList<Paquetes>();

	public void ayadirEntrega(Paquetes destino) {
		rutaPaquetes.add(destino);
	}
	public void mostrarRuta() {
		
		int i=1;
		for(Paquetes p:rutaPaquetes) {
			System.out.printf("%d - La siguiente entrega esta en la localizacion %d:%d ",1,p.getX(),p.getY());
			i++;
		}
	}
}
