package Boletin12_NotasTareas;

public class Main {

	public static void main(String[] args) {
		// T
		NotaNormal nota1 = new NotaNormal("Meter lavadora", "Lavar el uniforme", "amarillo");
		NotaUrgente nota2Urgente = new NotaUrgente("Entrenar", "Ir al gimnasio", "rojo");
		
//		nota1.listaNota();
//		nota2Urgente.listaNota();
		Nota.urgentesPrimero1();
	}

}
