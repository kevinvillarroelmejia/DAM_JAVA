package basesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class pidoNombreActor {

	public static void main(String[] args) {
		//pedir nombre del actor 
		//sacar los actores que tengan ese nombre
		//y el numero de actores que existen CON ESE NOMBRE
		String usuario = "admin";
		String password = "1234";

		String server = "jdbc:mysql://localhost:3306/sakila";

		try (Connection conexion = DriverManager.getConnection(server, usuario, password)) {
			System.out.println("Conexion realizada con exito");

			Scanner teclado = new Scanner(System.in);
			System.out.println("Nombre actor: ");
			String nombreActor = teclado.nextLine();

			//Statement queryModificacion=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			PreparedStatement queryModificable = conexion.prepareStatement("SELECT * FROM actor where first_name = ?",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			queryModificable.setString(1, nombreActor);
			ResultSet resultado = queryModificable.executeQuery();

			while (resultado.next()) {
				System.out.printf(" Linea: %d Nombre %s Apellido %s: \n", resultado.getRow(),
						resultado.getString("first_name"), resultado.getString("last_name"));
			}
		} catch (SQLException e) {
			System.out.println("ERROR " + e.getMessage());
		}

	}

}
