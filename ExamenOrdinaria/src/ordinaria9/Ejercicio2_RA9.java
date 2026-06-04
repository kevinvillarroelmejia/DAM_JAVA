package ordinaria9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio2_RA9 {

	public static void main(String[] args) {
		

		String usuario = "admin";
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/naciones";
		try (Connection conexion = DriverManager.getConnection(server, usuario, password)) {
			System.out.println("Conexion realizada con exito");
			cambiarIdiomaOficial(conexion, "Zambia","Bemba");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	public static void cambiarIdiomaOficial(Connection conexion, String nombrePais,String idioma) throws SQLException{
		PreparedStatement query = conexion.prepareStatement("select * from countries where name =?;",
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		query.setString(1, nombrePais);
		ResultSet resultadoUno = query.executeQuery();
		resultadoUno.last();
		boolean existePais=true;
		boolean existeIdioma=true;
		if (resultadoUno.getRow() == 0) {
			System.out.println(nombrePais + " no es un pais real o no esta dado de alta en la base de datos");
			existePais=false;
		}
		query=conexion.prepareStatement("select * from languages where language=?;",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		query.setString(1, idioma);
		ResultSet resultadoDos=query.executeQuery();
		resultadoDos.last();
		if(resultadoDos.getRow()==0) {
			System.out.println("El  "+idioma+" no se un idioma real o no esta dado de alta en la base datos");
			existeIdioma=false;
		}
		if(existeIdioma&&existePais) {
			resultadoUno.beforeFirst();
			resultadoUno.next();
			int idPais=resultadoUno.getInt("country_id");
			int idIdioma=resultadoDos.getInt("language_id");
			query=conexion.prepareStatement("update country_languages set official=1 where language_id=? and country_id=?;");
			query.setInt(1, idIdioma);
			query.setInt(2, idPais);
			int lineasAfectadas=query.executeUpdate();
			if(lineasAfectadas!=0) {
				System.out.println("El "+idioma+" es ahora idioma oficial en "+nombrePais);
			}
		}
		
	}
}
