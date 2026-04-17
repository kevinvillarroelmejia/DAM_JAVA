package modificacionesBasesDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Swing_BasesDatos {
	public static void main(String[] args) {
		String usuario = "admin";
		String password = "1234";
		String server = "jdbc:mysql://localhost:3306/sakila";
		
		try (Connection conexion = DriverManager.getConnection(server,usuario,password)) {
			System.out.println("Conexión realizada con éxito");
			
			Statement query = conexion.createStatement();
			String consulta = "SELECT * FROM actor";
			ResultSet resultadoString = query.executeQuery(consulta);
			ResultSet resultado = query.executeQuery("SELECT * FROM actor");
			// Creacción de ventana en entorno gráfico y tabla
			JFrame ventana = new JFrame("Tabla actor");
			DefaultTableModel modelo = new DefaultTableModel();
			JTable tabla = new JTable(modelo);
			// creación de las columnas de la tabla
			modelo.addColumn("id");
			modelo.addColumn("nombre");
			modelo.addColumn("apellido");
			// barra de scroll vertical para navegar en la tabla
			JScrollPane scroll = new JScrollPane(tabla);
			ventana.getContentPane().add(scroll);
			
			while (resultado.next()) {
				Object[] fila = new Object[3];
				fila[0] = resultado.getInt("actor_id");
				fila[1] = resultado.getString("first_name");
				fila[2] = resultado.getString("last_name");
				modelo.addRow(fila);
			}
			
			ventana.pack();
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setVisible(true);
			
			// while (resultado.next()) {
			//	System.out.printf("%d | %s | %s\n", resultado.getInt(1), resultado.getString(2), resultado.getString(3));
			//}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
