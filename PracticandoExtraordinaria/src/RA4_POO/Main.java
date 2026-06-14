package RA4_POO;

public class Main {

	public static void main(String[] args) {
		
		
		Coche coche1=new Coche("33333HMX", "Toyota", "Corrolla", 45.00, 2);
		Coche coche2=new Coche("44444HMX", "Mercedes", "Benz", 80.00, 5);
//		System.out.println(coche1);
		
		Furgoneta furgoneta=new Furgoneta("111111HMZ", "Dodge", "Challeger", 90.0, 9);
		Furgoneta furgoneta2=new Furgoneta("888888HMZ", "Ford", "Cupra", 100.0, 3);
		
		FlotaAlquiler.ayadirVehiculoFlota(coche1);
		FlotaAlquiler.ayadirVehiculoFlota(coche2);
		FlotaAlquiler.ayadirVehiculoFlota(furgoneta);
		FlotaAlquiler.ayadirVehiculoFlota(furgoneta2);

		FlotaAlquiler.mostrarFlota();
		System.out.println();
		FlotaAlquiler.mostrarVehiculoPorMatricula("44444HMX",20);
		System.out.println();
		FlotaAlquiler.vehiculoMasBarato();
	}

}
