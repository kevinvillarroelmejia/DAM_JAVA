package Entregas;

import java.util.ArrayList;
import java.util.Collections;

public class MainEjercicio2 {

	public static void main(String[] args) {
		Empleado leonador=new Empleado("LeonardoDicaprio", 1503.47, 345.44);
		Empleado ale=new Empleado("Ale", 2503.47, 100.44);
		Empleado sara=new Empleado("Saara", 2503.47, 100.44);
		Empleado marcos=new Empleado("Marco", 5000.2, 100.44);



		ArrayList<Empleado> listaEmpleados=Empleado.getListaEmpleados();
		Collections.sort(listaEmpleados);
		for(Empleado empleado:listaEmpleados) {
			System.out.println(empleado);
		}
		
//		System.out.println(leonador);
//		System.out.println(ale);
	}

}
