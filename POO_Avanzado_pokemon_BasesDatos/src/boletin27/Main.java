package boletin27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		String usuario = "admin"; // en casa root
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/pokemondb";
//		ArrayList<Pokemon> listaPokemon=new ArrayList<Pokemon>();

		try(Connection conexion = DriverManager.getConnection(server,usuario,password)){
			//leerBaseDatos(conexion);
			for (Pokemon pokemon : guardarPokemon(conexion)) {
				System.out.println(pokemon);
			}
			
			
			
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
//		String nombre="";
//		float peso=0;
//		float altura=0;
		ArrayList<Pokemon> listaPokemon=new ArrayList<Pokemon>();

		while(resultado.next()) {
			
			PreparedStatement queryTipos =conexion.prepareStatement("select");
			
			nuevoPokemon=new Pokemon(
					resultado.getInt("numero_pokedex"), 
					resultado.getString("nombre"),
					resultado.getFloat("peso"),
					resultado.getFloat("altura"));
					//falta sacar el tipo de la base de datos y ponerlo aqui
					listaPokemon.add(nuevoPokemon);
		}
		return listaPokemon;
	}
}
