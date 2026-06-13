package ExamenOrdinaria;

import java.util.ArrayList;

public class E1_Main {

	public static void main(String[] args) {

		E1_Receta fabadaAsturiana6Personas=new E1_Receta("Fabada Asturiana", 6);
		E1_Ingredientes fabes=new E1_Ingredientes("Fabes de Asturias",500,"grs");
		E1_Ingredientes chorizo=new E1_Ingredientes("Chorizo asturiano",2,"Unidades");

		fabadaAsturiana6Personas.ayadirIngrediente(fabes);

		
		ArrayList<E1_Ingredientes> listaIngredientes=new ArrayList<E1_Ingredientes>();
		E1_Ingredientes tocino=new E1_Ingredientes("Tocino curado entreverado asturiano",200,"grs");
		E1_Ingredientes lacon=new E1_Ingredientes("Lacon",200,"grs");
		E1_Ingredientes cebolla=new E1_Ingredientes("Cebolla",1,"Unidad");
		E1_Ingredientes aceite=new E1_Ingredientes("Aceite de oliva");
		E1_Ingredientes azafran=new E1_Ingredientes("Azafran");
		listaIngredientes.add(tocino);
		listaIngredientes.add(lacon);
		listaIngredientes.add(cebolla);
		listaIngredientes.add(aceite);
		listaIngredientes.add(azafran);
		
		fabadaAsturiana6Personas.ayadirIngrediente(listaIngredientes);
		System.out.println(fabadaAsturiana6Personas);

	}
}
