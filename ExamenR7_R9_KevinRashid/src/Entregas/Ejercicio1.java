package Entregas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		String usuario = "admin"; 
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/pokemondb";
		
		try(Connection conexion = DriverManager.getConnection(server,usuario,password)){
			evolucionesPokemon(conexion,"Bulbasaur");
			
		}catch (SQLException e) {
			System.out.println("Error " +e.getMessage());
		}
		
	}
	
	public static void evolucionesPokemon(Connection conexion,String nombrePokemon ) throws SQLException  {
		PreparedStatement sql=conexion.prepareStatement("SELECT * from pokemon where nombre=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		sql.setString(1, nombrePokemon);
		ResultSet resultado=sql.executeQuery();
		int idPokemonOrigen=resultado.getInt("numero_pokedex");
		resultado.last();
		if (resultado.getRow()==0) {
			System.out.println("El pokemon "+nombrePokemon+" no existe");
		}else {
			//resultado.absolute(1);
			sql=conexion.prepareStatement("SELECT evoluciona_de.pokemon_evolucionado FROM pokemon JOIN evoluciona_de on evoluciona_de.pokemon_origen=pokemon.numero_pokedex where pokemon.nombre = ?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			sql.setString(1, nombrePokemon);
			resultado=sql.executeQuery();
			resultado.last();
			if(resultado.getRow()==0) {
				System.out.println("El pokemon "+nombrePokemon+" no evoluciona en ningun otro");
			}else {
				resultado.absolute(1);
				int idPokemonEvolucionado=resultado.getInt("pokemon_evolucionado");
				sql=conexion.prepareStatement("select * from pokemon where numero_pokedex=?");
				sql.setInt(1, idPokemonEvolucionado);
				resultado=sql.executeQuery();
				if(resultado.next()) {
					System.out.println(nombrePokemon+"("+idPokemonOrigen+")\n- evoluciona en "+resultado.getString("nombre")+"("+idPokemonEvolucionado+")");
				}
			}
			
		}
	}
}
