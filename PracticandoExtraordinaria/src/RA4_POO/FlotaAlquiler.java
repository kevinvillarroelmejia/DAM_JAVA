package RA4_POO;

import java.util.ArrayList;

public class FlotaAlquiler {
	
	private static ArrayList<Vehiculo> listaVehiculos=new ArrayList<Vehiculo>();
	
	public static void ayadirVehiculoFlota(Vehiculo vehiculo) {
		listaVehiculos.add(vehiculo);
	}
	public static void mostrarFlota() {
		System.out.println("-- FLOTA COMPLETA --");
		for(Vehiculo vehiculo:listaVehiculos) {
			System.out.println(vehiculo);
		}
	}
	
	public static void mostrarSoloCoches() {
		for(Vehiculo vehiculo:listaVehiculos) {
			if(vehiculo instanceof Coche) {
				System.out.println(vehiculo);
			}
		}
	}
	public static  void mostrarSoloFurgonetas() {
		for(Vehiculo vehiculo:listaVehiculos) {
			if(vehiculo instanceof Furgoneta) {
				System.out.println(vehiculo);
			}
		}
	}
	
	public  static void mostrarVehiculoPorMatricula(String matricula,int diasAlquiler) {
		System.out.println("-- BUSCAR VEHICULO --");
		Vehiculo encontrado=listaVehiculos.get(0);
		for(Vehiculo vehiculo:listaVehiculos) {
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
				encontrado=vehiculo;
			}
		}
		if(encontrado.getMatricula().equalsIgnoreCase(matricula)) {
			System.out.println(encontrado);
			System.out.println("Alquiler "+diasAlquiler+" dias: "+encontrado.calcularPrecioAlquiler(diasAlquiler));
		}else {
			System.out.println("No existe vehiculo con esta matricula");
		}
	}
	
	public static  void vehiculoMasBarato() {
		System.out.println("-- VEHICULO MAS BARATO --");
		Vehiculo vehiculo=listaVehiculos.get(0);
		for(Vehiculo elemento:listaVehiculos) {
			if(elemento.getPrecioPorDia()<vehiculo.getPrecioPorDia()) {
				vehiculo=elemento;
			}
		}
		System.out.println(vehiculo);
	}
}
