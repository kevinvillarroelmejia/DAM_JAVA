package examenR7_R9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		listarEmpleadosPais("San Francisco");
//		moverEmpleadosDeOficina("San Francisco", "Boston");
	}

	public static void listarEmpleadosPais(String paisPedido) {
		String usuario = "root";
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/classicmodels";
		
		
		/*
		 * TODO no se puede hacer solo el ejercicio con un join se tiene que hacer con varias consultas
		 * 
		 * RESOLVERLO
		 * 
		 * */
		try (Connection conexion = DriverManager.getConnection(server, usuario, password)) {
			System.out.println("Conexion realizada con exito -- 1 -- ");
			PreparedStatement queryPais = conexion.prepareStatement(
					"SELECT employees.firstName," + "employees.email FROM employees "
							+ "JOIN offices ON offices.officeCode = employees.officeCode WHERE offices.city like ?;",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			queryPais.setString(1, paisPedido);
			ResultSet resultado = queryPais.executeQuery();
			resultado.last();
			System.out.println(
					"Hay " + resultado.getRow() + " empleados en la oficina de " + paisPedido + ". Sus datos son:");
			resultado.first();
			while (resultado.next()) {
				System.out.println(resultado.getString("firstName") + "(" + resultado.getString("email") + ")");
			}

		} catch (SQLException e) {
			System.out.println("ERROR 1 " + e.getMessage());
		}
	}
	
	/*
	 * aqui sale un error por que no le he asignado el valor al ?
	 * 
	 * */
	public static void moverEmpleadosDeOficina(String ciudadAntigua , String ciudadNueva) {
		String usuario = "root";
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/classicmodels";
		try (Connection conexion = DriverManager.getConnection(server, usuario, password)) {
			System.out.println("Conexion realizada con exito  -- 2 -- ");
			System.err.println("Moviendo todos los empleados de "+ciudadAntigua +" a "+ciudadNueva);
			
			//Se van a mover 2 empleados de Tokyo a París
			PreparedStatement queryPais = conexion.prepareStatement(
					"SELECT employees.firstName FROM employees JOIN offices ON offices.officeCode = employees.officeCode WHERE offices.city like ?",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultado2=queryPais.executeQuery();
			resultado2.last();
			System.out.println("Se van a mover "+resultado2.getRow()+" empleados de "+ciudadAntigua+" a "+ciudadNueva);
			resultado2.first();
			
			//CONSULTA PARA CONSEGUIR LAS LAS CLAVES DE LA CIUDAD
			//select officeCode from offices where offices.city like "Tokyo"
			PreparedStatement queryUPDATE = conexion.prepareStatement(
					"select officeCode from offices where offices.city like ?");
			queryUPDATE.setString(1, ciudadAntigua);
			ResultSet resultado3=queryUPDATE.executeQuery();
			String idCiudadAntigua=resultado3.getString("officeCode");
//			resultado3.next();
//			System.out.println(idCiudadAntigua);
		} catch (SQLException e) {
			System.out.println("ERROR 1 " + e.getMessage());
		}
	}
	
}
