package Boletin25;

 abstract class Vehiculo {
	 protected String matricula;
	 protected int ayoVenta;
	 protected Conductor conductor;
	 
	 public Vehiculo(String matricula,int ayoVenta,Conductor conductor) {
		 this.matricula=matricula;
		 this.ayoVenta=ayoVenta;
		 this.conductor=conductor;
	 }
	 public abstract void mostrarSeguro();
	 
}
