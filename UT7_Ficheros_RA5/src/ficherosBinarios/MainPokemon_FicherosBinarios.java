package ficherosBinarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainPokemon_FicherosBinarios {

	public static void main(String[] args) {
		String fichero = "/home/josemaria/binario.bin";

		// Guardar y recuperar UN objeto
		Pokemon pokemon = new Pokemon(6, "Charizard", "Fuego", "Volador");
		guardarPokemon(pokemon, fichero);
		Pokemon pokemonRecuperado = recuperarPokemon(fichero);
		if (pokemonRecuperado != null)
			pokemonRecuperado.mostrar();

		// Guardar y recuperar UNA LISTA de objetos
		ArrayList<Pokemon> listaPokemons = new ArrayList<>(List.of(
				new Pokemon(1, "Bulbasaur", "Planta"),
				new Pokemon(6, "Charizard", "Fuego", "Volador"),
				new Pokemon(2, "Ivysaur", "Planta"),
				new Pokemon(25, "Pikachu", "Eléctrico"),
				new Pokemon(11, "Metapod", "Bicho"),
				new Pokemon(7, "Squirtle", "Agua")));
		guardarListaPokemons(listaPokemons, fichero);
		ArrayList<Pokemon> listaRecuperada = recuperarListaPokemons(fichero);
		for (Pokemon poke : listaRecuperada) {
			poke.mostrar();
		}

		// AÑADIR a un fichero existente: recuperar, añadir a la lista, volver a guardar
		Pokemon p7 = new Pokemon(131, "Lapras", "Agua", "Hielo");
		listaRecuperada = recuperarListaPokemons(fichero);
		listaRecuperada.add(p7);
		guardarListaPokemons(listaRecuperada, fichero);
	}

	// GUARDAR un objeto
	public static void guardarPokemon(Pokemon pokemon, String fichero) {
		try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(fichero))) {
			binario.writeObject(pokemon);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	// RECUPERAR un objeto (cast obligatorio al leer)
	public static Pokemon recuperarPokemon(String fichero) {
		Pokemon pokemon = null;
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))) {
			pokemon = (Pokemon) binario.readObject();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return pokemon;
	}

	// GUARDAR una lista (se guarda como un único objeto)
	public static void guardarListaPokemons(ArrayList<Pokemon> lista, String fichero) {
		try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(fichero))) {
			binario.writeObject(lista);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	// RECUPERAR una lista (cast obligatorio)
	public static ArrayList<Pokemon> recuperarListaPokemons(String fichero) {
		ArrayList<Pokemon> lista = null;
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))) {
			lista = (ArrayList<Pokemon>) binario.readObject();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return lista;
	}
}