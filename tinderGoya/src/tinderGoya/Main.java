package tinderGoya;

public class Main {

	public static void main(String[] args) {
		Tinder tinder=new Tinder(); //se crea este objeto solo para utilizar sus funciones
		
		//0 BUSCA LO QUE SEA //1 BUSCA HOMBRE //2 BUSCA MUJER
		Hombre h1 = new Hombre(tinder,"Pepe", "12/08/1975", 1,35,50);
		Hombre h2 = new Hombre(tinder,"Kevin", "18/05/2000", 2,20,27);
		Hombre h3=new Hombre(tinder,"Alvaro","01/01/1990",1);
		
		Mujer m1 = new Mujer(tinder,"Carla", "12/12/2000", 1,50,70);
		Mujer m2 = new Mujer(tinder,"Candela", "03/03/2003", 0);

		NoDefinido n1 = new NoDefinido(tinder,"Jorger", "29/02/1988", 1);
		NoDefinido n2 = new NoDefinido(tinder,"Sisi", "02/11/2001", 0,18,25);
		
//		h1.mostrarDatos();
//		h2.mostrarDatos();
//		m1.mostrarDatos();
//		n1.mostrarDatos();
		tinder.buscaMatches(h1);
		
		
		

	}
}
