package ExamenOrdinaria;

import java.util.ArrayList;

public class E1_Receta {
	
	private String nombreReceta;
	private int numeroPersonas;
	private ArrayList<E1_Ingredientes> listaIngredientes=new ArrayList<E1_Ingredientes>();
	
	public E1_Receta(String nombreReceta,int numeroPersonas)	{
		this.nombreReceta=nombreReceta;
		this.numeroPersonas=numeroPersonas;
	}
	
	//sobreCarga de metodo
	public void ayadirIngrediente(E1_Ingredientes ingrediente) {
		listaIngredientes.add(ingrediente);
	}
	public void ayadirIngrediente(ArrayList<E1_Ingredientes> lista) {
		for(E1_Ingredientes ingrediente:lista) {
			listaIngredientes.add(ingrediente);
		}
	}
	
	@Override
	public String toString() {

		String linea=
				this.nombreReceta.toUpperCase()+"PARA "+this.numeroPersonas+" PERSONAS"+"\n";
		String dobleLinea="";
		for(int i=0;i<linea.length()-1;i++) {
			dobleLinea=dobleLinea+"=";
		}
		linea=linea+dobleLinea+"\n";
		for(E1_Ingredientes ingrediente:listaIngredientes) {
			linea=linea+ingrediente+"\n";
		}
		return linea;
	}

}
