package basesDeDatos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class teoriaBasesDatos {

	public static void main(String[] args) {
		
		
		String usuario = "admin";
        String password = "1234";

        //con esto seleccionamos la base de datos si no ponemos sakila es como solo estar dentro del servidor
        String server = "jdbc:mysql://localhost:3306/logistica_global";

        try (Connection conexion=DriverManager.getConnection(server, usuario, password)){//la coneccion la hacemos aqui){
        	System.out.println("Conexion realizada con exito");
        	Statement query=conexion.createStatement();
        	
        	//En el ResulSet se pone a lo que queremos tener acceso y la condicion
        	ResultSet resultado=query.executeQuery("SELECT * FROM empleados where email_corp='ojo@mordor.gov'");//RECOGER QUERY
        	
        	while(resultado.next()) {//avanza a la siguiente linea hasta el final
        		/*.next() siguiente
        		 * .beforeFirst() antes del 1º
        		 * .afterLast() despues del ultimof
        		 * .previous() anterior
        		 * .first() primero
        		 * .last() ultimo
        		 * .getrow numero de la fila donde te encuentres*/
        		System.out.println("NIE "+resultado.getString("nif_nie")); //o el numero de la columna 1,2,3,4
        		System.out.printf("Email: %s\n, Nombre Empleado %s\n ",resultado.getString("email_corp"),resultado.getString("nombre_completo"));
        	}

            //conexion.close(); // ← corregido

        } catch (SQLException e) { //SQLException para que de errores sobre bases de dato
            System.out.println("ERROR " + e.getMessage());
        }

	}

}
