package Solucion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio2 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/classicmodels";
		String usr = "admin";
		String pswd = "1234";
		try (Connection conexion = DriverManager.getConnection(url, usr, pswd)) {
			System.out.println("Conexión realizada con exito\n");
			moverEmpleados(conexion, "Tokyo", "Paris");
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void moverEmpleados(Connection cnx, String ciudadOrigen, String ciudadDestino) throws SQLException {
		System.out.println("Moviendo todos los empleados de " + ciudadOrigen + " a " + ciudadDestino);
		String query = "SELECT officecode FROM offices WHERE city = ?";
		// primero hay que comprobar si hay oficinas en ambas ciudades
		PreparedStatement sql = cnx.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		sql.setString(1, ciudadOrigen);
		ResultSet resultado = sql.executeQuery();
		resultado.last();
		if (resultado.getRow() == 0)
			System.out.println("No hay oficina en la ciudad " + ciudadOrigen);
		else {
			resultado.absolute(1);
			int codigoCiudadOrigen = resultado.getInt("officecode");
			sql = cnx.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sql.setString(1, ciudadDestino);
			resultado = sql.executeQuery();
			resultado.last();
			if (resultado.getRow() == 0)
				System.out.println("No hay oficina en la ciudad " + ciudadDestino);
			else {
				// si las hay, hacemos el update
				resultado.absolute(1);
				int codigoDestino = resultado.getInt("officecode");
				sql = cnx.prepareStatement("UPDATE employees SET officecode = ? WHERE officecode = ?");
				sql.setInt(1, codigoDestino);
				sql.setInt(2, codigoCiudadOrigen);
				int numero = sql.executeUpdate(); // devuelve el numero de cambios
				System.out.println("Se van a mover " + numero + " empleados");
				// y ahora comprobamos cuantos empleados hay en la oficina de destino
				sql = cnx.prepareStatement("SELECT COUNT(*) FROM employees WHERE officeCode = ?");
				sql.setInt(1, codigoDestino);
				resultado = sql.executeQuery();
				resultado.next();
				System.out.println("La oficina de " + ciudadDestino + " tiene ahora " + resultado.getInt(1) + " empleados");		
			}
		}	
	}

}
