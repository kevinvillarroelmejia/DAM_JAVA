package pokemon;

public class ppo2 {

	public static void main(String[] args) {
		//pokemon de un solo tipo
		Pokemon p1=new Pokemon(1,"Bulbasur","Planta");
		Pokemon p2=new Pokemon(2,"Evysaur","Planta");
		
		
		//Pokemons de dos tipos
		Pokemon p3=new Pokemon(3,"charmander","fuego","Volador");
		Pokemon p4=new Pokemon(4,"charmeleon","fuego","Volador");
		Pokemon p5=new Pokemon(4,"charizar","fuego","dragon");
		Pokemon p6=new Pokemon(5, "Metapod", "Agua");
		Pokemon p7=new Pokemon(6, "Lucario", "Lucha","Siniestro");

		

		
		System.out.println("~~~~FORMANDO EQUIPO DE 3 POKEMONS~~~~");
		equipoPokemon equipo1=new equipoPokemon("ASH", p1, p2, p3);
		equipoPokemon equipo2=new equipoPokemon("Kevin", p4, p5, p6);
		equipo1.mostrarEquipo();
		System.out.println("===============================");
		
		
		Pokemon[] pokedex=new Pokemon[151];//array de pokemon
//		pokedex[0]=gastly;//añadiendo un pokemon a
		p1.infoPokemon();//mostrar informacion del pokemon
		p1.setEvolucion(p3);//this.evolucion=p;
		p1.infoPokemon();
		
		//evolcionando a charmelon
		p3.setEvolucion(p4);
		p3.infoPokemon();
		
		System.err.println("####COMBATE####");
		p2.infoPokemon();
		p3.infoPokemon();
		p2.combateContra(p3);
		
	}
	//CAPACIDAD DE QUE LOS POKEMONS EVOLUCIONEN

}
