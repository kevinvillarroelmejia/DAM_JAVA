package Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ejercicio2 {

	public static void main(String[] args) {
		/*
		 * 2. Escribir un programa que MODIFIQUE el empleado que tiene asignado un
		 * cliente (salesrepEmployeeNumber). El método debería de recibir el nombre del
		 * Cliente (customerName) y el código del nuevo empleado y tiene que mostrar el
		 * antiguo empleado (Nombre y apellido) asignado a ese cliente antes de
		 * actualizar al nuevo. También debería de mostrar el nombre y apellidos del
		 * nuevo. Además, debería de contemplar que el cliente no exista, que el código
		 * del empleado introducido sea erróneo o que el cliente no tenga asignado
		 * ningún empleado NOTAS: El cliente “Morales” no existe, el código de empleado
		 * 666 tampoco y el cliente Warburg Exchange no tiene asignado ningún empleado.
		 * El cliente Kelly's Gift Shop tiene asignado como empleado a Peter Marsh.
		 */
		String usuario = "admin"; 
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/classicmodels";
		int codigoEmpleado=1621;
		String nombreCustomer="Raanan Stores, Inc";
		try(Connection conexion=DriverManager.getConnection(server,usuario,password)){
			System.out.println("Conexion realizada con exito");
			
			cambiarEmpleadoAsignado(conexion,nombreCustomer,codigoEmpleado);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	public static void cambiarEmpleadoAsignado(Connection conexion,String nombreCustomer,int codigoNuevoEmpleado ) throws SQLException {
		//BANDERAS DE COMPROBACION
		boolean existeCliente=false;
		boolean clienteNoTieneEmpleado=false;
		//mostrar el antiguo empleado (nombre apellido) asignado a ese cliente antes de actulizar al nuevo
		PreparedStatement query=conexion.prepareStatement("SELECT firstName, lastName,salesRepEmployeeNumber FROM employees JOIN customers ON customers.salesRepEmployeeNumber = employees.employeeNumber WHERE customerName LIKE ?");
		query.setString(1, nombreCustomer);
		ResultSet resultado=query.executeQuery();
		while(resultado.next()) {
			existeCliente=true;
			resultado.getInt("salesRepEmployeeNumber");
			System.err.println("Nombre Apellido antiguo empleado");
			System.out.println("Nombre--> "+resultado.getString("firstName"));
			System.out.println("Apellido--> "+resultado.getString("lastName"));
		}
		if (!existeCliente) {
			System.out.println("----El cliente no existe----");
		}
		
		/*HACEMOS EL CAMBIO Y MOSTRAMOS LOS APELLIDOS DEL NUEVO*/
		/*CONSULTA PARA MODIFICAR DATOS*/
		PreparedStatement queryUpdate=conexion.prepareStatement("update customers set salesRepEmployeeNumber = ? where customerName like ?");
		//PONEMOS DATOS EN LA CONSULTA 
		queryUpdate.setInt(1, codigoNuevoEmpleado);
		queryUpdate.setString(2, nombreCustomer);
		int filasAfectadas=queryUpdate.executeUpdate();
		System.out.println("Filas afectadas --> "+filasAfectadas);
		
		//mostrar el nombre y apellido del nuevo
		//hacemos un query.executeQuery(); para obtener un Resulset FRESCO
		resultado=query.executeQuery();
		while(resultado.next()) {
			//El cliente tiene empleado asignado
			clienteNoTieneEmpleado=true;
			System.err.println("---Nombre y apellido del nuevo empleado---");
			System.out.println("Nombre-->"+resultado.getString("firstName"));
			System.out.println("Apellido-->"+resultado.getString("lastName"));
		}
		/*if (!clienteNoTieneEmpleado) {
			System.out.println("El cliente no tiene empleado");
		}
		*/
		//cotemplar que el cliente no exista
		
		//que el codigo del empleado no exista o que el cliente no tenga ningun empleado

	}

}
