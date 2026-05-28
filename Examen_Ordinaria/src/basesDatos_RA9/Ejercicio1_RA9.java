package basesDatos_RA9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio1_RA9 {

	public static void main(String[] args) {

		String usuario = "admin";
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/naciones";
		try (Connection conexion = DriverManager.getConnection(server, usuario, password)) {
			System.out.println("Conexion realizada con exito");
			idiomaPorPais(conexion, "Vanuatu");
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void idiomaPorPais(Connection conexion, String nombrePais) throws SQLException {
		PreparedStatement query = conexion.prepareStatement("select * from countries where name =?;",
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		query.setString(1, nombrePais);
		ResultSet resultadoUno = query.executeQuery();
		resultadoUno.last();
		if (resultadoUno.getRow() == 0) {
			System.out.println(nombrePais + " no es un pais real o no esta dado de alta en la base de datos");
		} else {
			resultadoUno.beforeFirst();
			resultadoUno.next();
			int numeroIdPais = resultadoUno.getInt("country_id");
//			System.out.println(resultadoUno.getString("country_id")+resultadoUno.getString("name"));
			String nombrePaisVarible = resultadoUno.getString("name");
			query = conexion.prepareStatement("select * from country_languages where country_id = ? and official=1;",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			query.setInt(1, numeroIdPais);
			ResultSet resultadoDos = query.executeQuery();
			resultadoDos.last();
			if (resultadoDos.getRow() == 0) {
				System.out.println("No hay ningun idioma oficial en " + nombrePais);
			} else {
				resultadoDos.beforeFirst();
				resultadoDos.next();
				int idIdiomaOficioal = resultadoDos.getInt("language_id");
				query = conexion.prepareStatement("select language from languages where language_id=?;",
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				query.setInt(1, idIdiomaOficioal);
				ResultSet resultadoTres = query.executeQuery();
//				resultadoTres.beforeFirst();
				while (resultadoTres.next()) {
					System.out.println("Idoma Oficial en " + nombrePais + ": " + resultadoTres.getString("language"));
				}
				// CONSULTA PARA OTROS IDIOMAS
				query = conexion.prepareStatement(
						"select * from country_languages where country_id = ? and official=0;",
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				query.setInt(1, numeroIdPais);
				ResultSet resultadoCuatro = query.executeQuery();
				resultadoCuatro.next();
				int idOtrosIdiomas = resultadoCuatro.getInt("language_id");
				resultadoCuatro.last();
				if (resultadoCuatro.getRow() == 0) {
					System.out.println("No hay otros idiomas");
				} else {
					query = conexion.prepareStatement("SELECT * FROM naciones.languages where language=?;");
					query.setInt(1, idOtrosIdiomas);
					ResultSet resultadoQuito = query.executeQuery();
					System.out.println("Otros idiomas: ");
					while (resultadoQuito.next()) {
						System.out.println(resultadoCuatro.getString("language"));
					}
				}
			}
		}

	}
}
