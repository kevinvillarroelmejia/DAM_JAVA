package Viajes;

import java.util.ArrayList;

public class Presupuesto {

	 private String nombreCliente;
	 
	 private  ArrayList<Actividad> listaActividades=new ArrayList<Actividad>();

	 public Presupuesto(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	 }
	 
	 public void ayadirActividad(Actividad actividad) {
		 listaActividades.add(actividad);
	 }
	 
	 public void ayadirListaActividades(ArrayList<Actividad> listaActividad) {
		 for(Actividad actividad:listaActividad) {
			 this.listaActividades.add(actividad);
		 }
	 }
	 
	 public double costeTotal() {
		 double presupuesto=0;
		 for(Actividad actividad:listaActividades) {
			 presupuesto=presupuesto+actividad.getPrecioTotal();
		 }
		 return presupuesto;
	 }
	 
	 @Override
	 public String toString() {
		 String linea="";
		 linea="PRESUPUESTO DE "+this.nombreCliente.toUpperCase()+"\n";
		 int asteriscos=linea.length();
		 for(int i=0;i<asteriscos-1;i++) {
			 linea=linea+"*";
		 }
		 if(this.listaActividades.size()!=0) {
			 linea=linea+"\n";
			 int guiones=0;
			 for(Actividad actividad:listaActividades) {
				 linea=linea+actividad+"\n";
				 guiones=actividad.toString().length();
			 }
			 for(int i=0;i<guiones;i++) {
				 linea=linea+"-";
			 }
			 linea=linea+"\n";
//			 linea+"TOTAL: "+costeTotal()+"€";
			 linea=linea+String.format("TOTAL: %.2f", costeTotal());
		 }else {
			 linea=linea+"\nSin actividades contradas";
		 }
		 return linea;
	 }

}
 