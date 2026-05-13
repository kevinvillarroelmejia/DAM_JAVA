package boletin27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		String usuario = "admin"; // en casa root
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/pokemondb";
//		ArrayList<Pokemon> listaPokemon=new ArrayList<Pokemon>();

		try(Connection conexion = DriverManager.getConnection(server,usuario,password)){
			//leerBaseDatos(conexion);
			ArrayList<Pokemon> listaPokemon=guardarPokemon(conexion);
			//ordenando la lista por orden alfabetico por el compareTo
			Collections.sort(listaPokemon);
			for (Pokemon pokemon : listaPokemon) {
				System.out.println(pokemon);
<<<<<<< HEAD
			}	
=======
			}
			
>>>>>>> branch 'main' of https://github.com/kevinrashiid/DAM_JAVA
		}catch (SQLException e) {
			System.out.println("Error " +e.getMessage());
		}
	}

	private static void leerBaseDatos(Connection conexion) throws SQLException{
		PreparedStatement query = conexion.prepareStatement("select * from  pokemondb.pokemon");
		ResultSet resultado=query.executeQuery();
		while(resultado.next()) {
			System.out.println(resultado.getString("nombre")+" (#"+resultado.getInt("numero_pokedex")+") ");
			System.out.println("Peso: "+resultado.getFloat("peso"));
			System.out.println("Altura: "+resultado.getFloat("altura"));
			System.err.println("==========================");
		}
	}
	public static ArrayList<Pokemon> guardarPokemon(Connection conexion) throws SQLException{
		PreparedStatement query = conexion.prepareStatement("select * from  pokemondb.pokemon");
		ResultSet resultado=query.executeQuery();
		Pokemon nuevoPokemon=null;

		ArrayList<Pokemon> listaPokemon=new ArrayList<Pokemon>();

		while(resultado.next()) {
			//reutilizando la consulta
			query =conexion.prepareStatement("SELECT  nombre FROM tipo join pokemon_tipo where tipo.id_tipo=pokemon_tipo.id_tipo and  numero_pokedex = ?"
					,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			
			query.setInt(1,resultado.getInt("numero_pokedex"));
			ResultSet resultadoTipos=query.executeQuery();

			resultadoTipos.last();
			
			int numTipos=resultadoTipos.getRow();
			resultadoTipos.first();
			/////////---------------------
			if(numTipos==1) {
				nuevoPokemon=new Pokemon(resultado.getInt("numero_pokedex"), 
					resultado.getString("nombre"),
					resultado.getFloat("peso"),
					resultado.getFloat("altura"),
					resultado.getString("nombre"),
					resultadoTipos.getString("nombre"));
					//falta sacar el tipo de la base de datos y ponerlo aqui
					listaPokemon.add(nuevoPokemon);
			}else {
				String tipo1=resultadoTipos.getString("nombre");
				resultadoTipos.next();
				String tipo2=resultadoTipos.getString("nombre");
				nuevoPokemon=new Pokemon(resultado.getInt("numero_pokedex"), 
						resultado.getString("nombre"),
						resultado.getFloat("peso"),
						resultado.getFloat("altura"),
						tipo1,tipo2);
			}
		}
		return listaPokemon;
	}
}
