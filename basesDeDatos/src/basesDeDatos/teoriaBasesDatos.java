package basesDeDatos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        	//CON ESTE Staement solo se puede avanzar hacia adelante en la base de datos
        	Statement query=conexion.createStatement();
        	/* --TODO REPASAR ESTO-- */
        	//TYPE_FORWARD_ONLY--> con este solo puede ir hacia adelante (es por el esta por defecto)
        	//CONCUR_READ_ONLY
        	
        	//TYPE_SCROLL_INSENSITIVE --> ir hacia adelante o atras
        	//CONCUR_UPDATABLE
        	
        	//CON ESTE Staement te deja moverte libremente
        	Statement query1=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	Statement queryModificacion=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        	//En el ResulSet se pone a lo que queremos tener acceso y la condicion (where)
        	ResultSet resultado=queryModificacion.executeQuery("SELECT * FROM empleados");//RECOGER QUERY
        	
        	//esto se utiliza cuando mi consulta no es fija por ejemplo cuando cogemos datos de un fichero
        	PreparedStatement queryAvanzado=conexion.prepareStatement("SELECT * FROM actor WHERE first_name=? AND last_name",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        	queryAvanzado.setString(1, "Empleado 1");
        	ResultSet resultadoAvanzado=queryAvanzado.executeQuery();
        	
        	//resultado.absolute(67);
        	//resultado.updateString("nombre_completo", "Kevincito");
        	//resultado.updateRow();//para que se apliquen los cambios
        	
     		/*.next() siguiente
    		 * .beforeFirst() antes del 1º
    		 * .afterLast() despues del ultimof
    		 * .previous() anterior
    		 * .first() primero
    		 * .last() ultimo
    		 * .getrow numero de la fila donde te encuentres
    		 * .absolute() --> si ponemos un numero positivo pone el curso desde arriba,Si es negativo lo pone empezando a contar desde abajo
    		 * .relative() --> pone el curso empezando a contar desde donde estas */ 
        	while(resultado.next()) {//avanza a la siguiente linea hasta el final
   
        		// System.out.println("NIE "+resultado.getString("nif_nie")); //o el numero de la columna 1,2,3,4
        		 System.out.printf("Email: %s\n, Nombre Empleado %s\n %S",resultado.getRow(),resultado.getString("email_corp"),resultado.getString("nombre_completo"));

        		/*resultado.getInt() si es numero*/
        		// resultado.getRow() -- numero de linea
        	}

            //conexion.close(); // ← corregido

        } catch (SQLException e) { //SQLException para que de errores sobre bases de dato
            System.out.println("ERROR " + e.getMessage());
        }

	}

}
