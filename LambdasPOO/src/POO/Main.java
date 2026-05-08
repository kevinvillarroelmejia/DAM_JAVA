package POO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Pokemon p1=new Pokemon(1,"Bulbasur","Planta");
		Pokemon p2=new Pokemon(2,"Evysaur","Planta");
		Pokemon p7=new Pokemon(6, "Lucario", "Lucha","Siniestro");
		Pokemon p8=p7;
		
		Pokemon p5=new Pokemon(4,"charizar","fuego","dragon");
		Pokemon p6=new Pokemon(5, "Metapod", "Agua");
		
		//Cada vez que imprimimos utiliza el la funcion toString
		//toString
		System.out.println(p1);
		
		ArrayList<Pokemon> listaPokemon=new ArrayList<Pokemon>(List.of(p1,p2,p5,p6,p7,p8));
		Collections.sort(listaPokemon);
		for(Pokemon p:listaPokemon) {
			System.out.println(p);
		}
		
		
		//Cuando utilizamos el equals (sin sobreescribir su codigo)entre objetos comparamos direcciones de memoria
		if (p1.equals(p8)) {
			System.out.println("Son Iguales");
		}else {
			System.out.println("Son diferentes");
		}
		
		//equals
		if(p8.equals(p7)) {
			System.out.println("Son Iguales");
		}else {
			System.out.println("Son diferentes");
		}
		
		
		//compareTo
	}
}