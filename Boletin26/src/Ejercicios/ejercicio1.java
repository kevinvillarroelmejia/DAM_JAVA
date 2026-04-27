package Ejercicios;

import java.sql.*;

public class ejercicio1 {

	public static void main(String[] args) {
		/*
		 * 1. Escribir un programa que reciba como argumento el apellido de un empleado
		 * y liste el nombre de todos los empleados que tienen ese apellido así como el
		 * nombre y el apellido de todos los empleados que les reportan (reportsTo). El
		 * método debería de contemplar que no existiera ningún empleado con el apellido
		 * indicado y en ese caso debería de mostrar un error. También debería de
		 * identificar cuando a un empleado no le reporta a nadie NOTA: Existen tres
		 * empleados con el apellido Patterson y ninguno con el apellido Morales. A Mary
		 * Patterson le reportan 4 personas, a William tres y a Steve nadi
		 */
		String usuario = "root"; // en casa root
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/classicmodels";
		String apellido = "Patterson";

		try (Connection conexion = DriverManager.getConnection(server, usuario, password)) {
			System.out.println("Conexion realizada con exito");
			listarEmpleadosApellidos(conexion, apellido);

		} catch (SQLException e) {
			System.out.println("ERROR " + e.getMessage());
		}
	}

	public static void listarEmpleadosApellidos(Connection conexion, String apellido) throws SQLException {
		boolean existeElEmpleado = false;

		PreparedStatement query = conexion
				.prepareStatement("select employeeNumber,lastName, firstName from employees where lastName like ?");
		query.setString(1, apellido);
		ResultSet resultado = query.executeQuery();
		while (resultado.next()) {
			existeElEmpleado = true;
			System.out.println("");
			System.out.println("Nombre--> " + resultado.getString("lastName"));
			System.out.println("Apellido--> " + resultado.getString("firstName"));
			int numeroEmpleado = resultado.getInt("employeeNumber");

			// ESTA ES LA PARTE CLAVE
			PreparedStatement query2 = conexion
					.prepareStatement("select lastName,firstName from employees where reportsTo=?");
			query2.setInt(1, numeroEmpleado);
			ResultSet resultado2 = query2.executeQuery();
			boolean existeReportes = false;
			while (resultado2.next()) {
				existeReportes = true;
				// FORAMTO SALIDA
				System.err.println("Este empleado le reporto a: " + apellido);
				System.out.print("Apellido: ");
				System.out.println(resultado2.getString("lastName"));
				System.out.print("Nombre: ");
				System.out.println(resultado2.getString("firstName"));
			}
			if (!existeReportes) {
				System.out.println("No existen reportes con el apellido " + apellido);
			}
		}
		if (!existeElEmpleado) {
			System.out.println("No existe el empleado con el apellido " + apellido);
		}
	}
}
