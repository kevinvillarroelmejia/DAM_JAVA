package Viajes;

public class Actividad {

	
	private String concepto;
	private int cantidad;
	private double precioUnidad;
	private double precioTotal;
	public Actividad(String concepto, int cantidad, double precioUnidad) {
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.precioUnidad = precioUnidad;
		this.precioTotal=precioUnidad*cantidad;
	}
	
	 @Override
	 public String toString() {
		 String linea="";
//		 "- "+this.concepto+"x"+this.cantidad+this.precioTotal;
		 linea=String.format("- %-20s x%-5d %.2f", this.concepto,this.cantidad,this.precioTotal);
		 return linea;
	 }
	public String getConcepto() {
		return concepto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}


}
