package Ventanas_swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class swing {

	public static void main(String[] args) {	
		//creacion de ventana pero no tiene ni tamaño ni se visualiza
		JFrame ventana=new JFrame("Ventana de bien"); //con titulo
		
		ventana.setLocationRelativeTo(null);//ventana en un posicion determinada
		
		ventana.setSize(350,200); //tamaño ventana
				
		ventana.setLayout(new FlowLayout()); //orden uno al lado del otro
		JLabel mensaje=new JLabel("Hola mundo");//texto dentro
		JButton boton=new JButton("Aceptar");
		JTextField edicion=new JTextField(59);
		
		ventana.add(edicion);
		ventana.add(mensaje);
		ventana.add(boton);

		ventana.setVisible(true);
		
		
		
	}
}
