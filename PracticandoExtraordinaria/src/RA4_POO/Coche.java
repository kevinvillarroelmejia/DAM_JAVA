package RA4_POO;

public class Coche extends Vehiculo{
	
	private int numPlazas;
	public Coche(String matricula, String marca, String modelo, double precioPorDia,int numPlazas) {
		super(matricula, marca, modelo, precioPorDia);
		this.numPlazas=numPlazas;
	}
	
	@Override
	public String toString() {
		String linea=this.marca+" "+ this.modelo+" ("+this.matricula+") - "+this.numPlazas+" Plazas "+this.precioPorDia+" EUR/dia";
		return linea;
	}

	@Override
	double calcularPrecioAlquiler(int dias) {
		double precioAlquiler=precioPorDia*dias;
		return precioAlquiler;
	}

}
