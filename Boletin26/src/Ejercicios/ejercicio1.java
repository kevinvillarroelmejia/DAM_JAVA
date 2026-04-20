package Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ejercicio1 {

	public static void main(String[] args) {

		// pedir nombre del actor
		// sacar los actores que tengan ese nombre
		// y el numero de actores que existen CON ESE NOMBRE
		String usuario = "admin";
		String password = "1234";

		String server = "jdbc:mysql://localhost:3306/classicmodels";
		int stockMinimo = 500;

		try (Connection conexion = DriverManager.getConnection(server, usuario, password)) {
			System.out.println("Conexion realizada con exito");
			productosConStockMenor(conexion, stockMinimo);

		} catch (SQLException e) {
			System.out.println("ERROR " + e.getMessage());
		}

	}

	private static void productosConStockMenor(Connection cnx, int stockMinimo) throws SQLException {
		PreparedStatement query = cnx.prepareStatement(
				"SELECT productcode ,productName,quantityInStock FROM products WHERE quantityInStock <= ?");
		query.setInt(1, stockMinimo);
		ResultSet resultado = query.executeQuery();
		while (resultado.next()) {
			System.out.println(resultado.getString("productName"));
			PreparedStatement query2 = cnx.prepareStatement("select count(*) from orderdetails where productCode =?");
			query2.setString(1, resultado.getString("productCode"));
			ResultSet resultado2 = query2.executeQuery();
			resultado2.next();
			System.out.println(resultado2.getInt(1));
		}
	}

}
