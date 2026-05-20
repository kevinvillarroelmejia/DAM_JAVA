package Solucion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/classicmodels";
		String usr = "root";
		String pswd = "1234";
		try (Connection conexion = DriverManager.getConnection(url, usr, pswd)) {
			System.out.println("Conexión realizada con exito\n");
			listarEmpleados(conexion, "París");
			listarEmpleados(conexion, "Madrid");
			listarEmpleados(conexion, "Tokyo");
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	/* TODO --- PONIENDO ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
	 * PODEMOS MOVERNOS POR LA BASE DE DATOS UTILIZANDO
	 * first(), 
	 * last(), 
	 * previous(), 
	 * absolute(5)*/

	public static void listarEmpleados(Connection cnx, String ciudad) throws SQLException {
		// Como nos piden que distingamos entre que hay oficina o no tiene empleados tenemos que hacer un primer query 
		// para ver si hay oficina
		PreparedStatement sql = cnx.prepareStatement("SELECT officecode FROM offices WHERE city = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		sql.setString(1, ciudad);
		ResultSet resultado = sql.executeQuery();
		resultado.last();
		// si la última fila es la 0 es que no hay oficina
		if (resultado.getRow() == 0)
			System.out.println("No existe oficina en " + ciudad + "\n");
		else {
			// En caso contrario, buscamos los empleados de esa oficina que ya sabemos que existe
			sql = cnx.prepareStatement("SELECT  firstname, lastname, email FROM employees "
					+ "JOIN offices ON employees.officeCode = offices.officeCode "
					+ "WHERE offices.city = ?;",	ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sql.setString(1, ciudad);
			resultado = sql.executeQuery();
			resultado.last(); // -- NUMERO DE EMPLEADOS
			// si hay empleados los obtenemos cuantos y los listamos
			if (resultado.getRow() != 0) {
				System.out.println("Hay " + resultado.getRow() + " empleados en la oficina de " + ciudad + ". Sus datos son: ");
				resultado.beforeFirst(); // -- VUELE AL PRINCIPIO
				while (resultado.next())
					System.out.printf("%s, %s (%s)\n", resultado.getString("lastname"), resultado.getString("firstname"), resultado.getString("email"));
				System.out.println();
			} else
				// y si no ponemos un mensaje diciéndolo
				System.out.println("La oficina de " + ciudad + " no tiene empleados\n");
		}
	}

}
