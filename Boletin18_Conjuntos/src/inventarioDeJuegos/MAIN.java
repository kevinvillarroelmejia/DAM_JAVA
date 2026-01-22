package inventarioDeJuegos;

import java.util.HashSet;

public class MAIN {

	public static void main(String[] args) {
		
		HashSet<accesorios> inventarioASH=new HashSet<accesorios>();
		personaje ash=new personaje("ash");
		
		accesorios espada=new accesorios("espada",2);
		
		ash.añadirObjetoInventario(espada);
		
		

	}

}
