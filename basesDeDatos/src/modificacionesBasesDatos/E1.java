package modificacionesBasesDatos;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class E1 {

	public static void main(String[] args) {

		/*executeQuery() --Cuando hacemos un SELECT
		 *executeUpdate() --Cuando hacemos un modificaciones*/
		
		String usuario = "root";
        String password = "1234";

        //con esto seleccionamos la base de datos si no ponemos sakila es como solo estar dentro del servidor
        String server = "jdbc:mysql://localhost:3306/sakila";
        try (Connection conexion=DriverManager.getConnection(server, usuario, password)){//la coneccion la hacemos aqui){
        	System.out.println("--Conexion realizada con exito--");
        	PreparedStatement queryAvanzado=conexion.prepareStatement("INSERT INTO actor VALUES NULL,?,?,?");
        	//metiendo el nombre apellido y fecha
        	queryAvanzado.setString(1, "Kevin");//Columna 1 nombre
        	queryAvanzado.setString(2, "Villarroel");//columna 2 apellido
        	
        	LocalDateTime fechaHora=LocalDateTime.now();//fecha y hora actual
        	DateTimeFormatter formato=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        	String fechaFormateada=fechaHora.format(formato);
        	queryAvanzado.setString(3, fechaFormateada);//columna 3 fecha
        	System.out.println(queryAvanzado.executeUpdate()); // es el numero de filas involucrados
        	
        	//eliminando 
        	queryAvanzado.executeUpdate("DELETE FROM actor WHERE last_name='Villarroel'");
        	
        	
        }catch (SQLException e) {
        	System.out.println("error "+e.getMessage());
        	
		}
        
        //Creando base de datos
        String server2 = "jdbc:mysql://localhost:3306/";
        try (Connection conexion=DriverManager.getConnection(server2, usuario, password)){//la coneccion la hacemos aqui){
        	System.out.println("Conexion realizada con exito");
        	String query1="CREATE DATABASE IF NOT EXIST agenda";
        	String query2="Use agenda";
        	String query3="CREATE TABLE IF NOT EXIST personas(telefono int(9), primary_Key, nombre varchar(50))";
        	
        	Statement consulta=conexion.createStatement();
        	consulta.executeUpdate(query1);
        	consulta.executeUpdate(query2);
        	consulta.executeUpdate(query3);
        	
        }catch (Exception e) {
        	System.out.println("ERROR CREACION BASE DE DATOS");
        }
        
        
        // GESTOR DE ACTORES SAKILA
        try (Connection conexion=DriverManager.getConnection(server2, usuario, password)){
        	System.out.println("Conexion realizada con exito");
        	
        }catch (SQLException e) {
        	
		}

	}

}
