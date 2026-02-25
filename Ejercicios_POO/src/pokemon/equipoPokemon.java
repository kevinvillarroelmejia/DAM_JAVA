package pokemon;

public class equipoPokemon {
	private String entrenador;
	private Pokemon[] equipoPokemon=new Pokemon[3];
	
	
	//CONSTRUCTOR
	//CREANDO UN EQUIPO DE 3 POKEMONS
	public equipoPokemon(String entr, Pokemon p1,Pokemon p2,Pokemon p3) {
		this.entrenador=entr;
		this.equipoPokemon[0]=p1;//AÑADIENDO EL POKEMON AL ARRAY
		this.equipoPokemon[1]=p2;
		this.equipoPokemon[2]=p3;
	}
	
	//TODO FUNCION
	//mostrando cada pokemon del array
	public void mostrarEquipo() {
		System.out.println("Entrador "+this.entrenador );
		for(int i=0;i<3;i++) {
			this.equipoPokemon[i].infoPokemon();;
		}
	}
	
	//TODO FUNCION
	//cambate entre equipos 
	public void combateEntreEquipos() {
		
		
		
		
		
	}
	
	
}
