package RA4_POO;

abstract class Vehiculo {
	protected String matricula;
	protected String marca;
	protected String modelo;
	protected double precioPorDia;
	public Vehiculo(String matricula, String marca, String modelo, double precioPorDia) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.precioPorDia = precioPorDia;
	}
	
	abstract double calcularPrecioAlquiler(int dias);

	public String getMatricula() {
		return matricula;
	}

	public double getPrecioPorDia() {
		return precioPorDia;
	}
	
}
