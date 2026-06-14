package RA4_POO;

public class Furgoneta extends Vehiculo{

	private double cargaMax;
	public Furgoneta(String matricula, String marca, String modelo, double precioPorDia,double cargaMax) {
		super(matricula, marca, modelo, precioPorDia);
		this.cargaMax=cargaMax;
	}
	
	@Override
	public String toString() {
		String linea=this.marca+" ("+this.matricula+") - "+this.cargaMax+" kg carga - "+this.precioPorDia+" EUR/dia";
		return linea;
	}

	@Override
	public double  calcularPrecioAlquiler(int dias) {
		double precioAlquiler=precioPorDia*dias;
		return precioAlquiler;
	}

}
