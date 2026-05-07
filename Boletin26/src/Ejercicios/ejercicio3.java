package Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ejercicio3 {

	public static void main(String[] args) {

		/*
		 * 3. Escribir un programa que reciba como argumento un número. El método
		 * debería de listar el nombre de todos los productos cuyo stock
		 * (quantityInStock) sea igual o inferior a ese número (indicando el stock
		 * exacto del artículo) junto con el número de veces que ese producto aparece en
		 * un pedido (tabla orderdetails). También debería de informarnos si no ha
		 * encontrado ningún producto con un stock inferior al indicado. NOTA: Hay cinco
		 * productos con stock menor o igual a 500. El producto 1960 BSA Gold Star DBD34
		 * del que sólo hay 15 unidades (es el único producto del que hay 15 o menos
		 * unidades) aparece en 28 pedidos. No hay ningún producto con stock inferior o
		 * igual a 10 unidades
		 */

		String usuario = "admin"; // en casa root
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

	// le pasamos la conexion y el stockMinimo para filtrar
	private static void productosConStockMenor(Connection cnx, int stockMinimo) throws SQLException {
		boolean bandera = false;
		// con lo siguiente hacemos la consulta para pudiendo cambiar el ? por
		// stockminimo
		PreparedStatement query = cnx.prepareStatement(
				"SELECT productcode ,productName,quantityInStock FROM products WHERE quantityInStock <= ?");
		// setInt por que stockminimo es int
		query.setInt(1, stockMinimo);
		// ejecutamos la consulta
		ResultSet resultado = query.executeQuery();
		// mueve el cursor a la siguiente fila y devuelve true si existe

		while (resultado.next()) {
			bandera = true;
			// Imprime SOLO EL nombre del producto de la fila actual del ResultSet
			System.out.println(resultado.getString("productName"));
			// Creamos una segunda consulta preparada que cuenta cuántos pedidos
			// (orderdetails) existen para un productCode concreto
			PreparedStatement query2 = cnx.prepareStatement("select count(*) from orderdetails where productCode =?");
			// Sustituimos el ? por el productCode del producto actual
			// Usamos setString porque productCode es un String
			query2.setString(1, resultado.getString("productCode"));
			ResultSet resultado2 = query2.executeQuery();
			// Avanzamos a la primera (y única) fila del resultado.
			resultado2.next();
			// Imprime el número de pedidos asociados a ese producto.
			// Usamos getInt(1) porque accedemos por posición de columna (la primera),
			// ya que count(*) no tiene un nombre de columna definido por nosotros
			System.out.println(resultado2.getInt(1));
		}
		if (!bandera) {
			System.out.println("No se han encontrado productos con stock inferior a " + stockMinimo);
		}
	}

}
