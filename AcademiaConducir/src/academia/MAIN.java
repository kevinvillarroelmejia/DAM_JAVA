package academia;

public class MAIN {

	public static void main(String[] args) {
//		ArrayList<pregunta> examen=new ArrayList<pregunta>();
		
		
		pregunta p1=new pregunta("¿Que señales son azules?", "peligro", "no hay señales azules", "informativas");
		pregunta p2=new pregunta("¿Que velocidad maxima en autopistas?", "la que de tu coche", "60", "20");
		pregunta p3=new pregunta("¿Puedo circular eb caballo por autovia?", "Si si llevas gorro de vaquero", "En casos especiales", "De ninguna forma");
		pregunta p4=new pregunta("¿Quien tiene preferencia en un paso de peatones?", "Los coches", "Los animales", "Los peatones");
		
		//TODO Creamos un examen de 3 preguntas guardadas en la clase preguntas
		examen ex1=new examen(3,pregunta.getBancoDePreguntas());
		ex1.mostrarExamen();
		//ex1.solucionExamen();

		
	}

}
