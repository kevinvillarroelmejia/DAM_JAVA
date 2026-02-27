package SOLUCION;

import java.util.ArrayList;
import java.util.HashMap;

public class Prueba {

	public static HashMap<Integer, Prueba> listPruebas = new HashMap<Integer, Prueba>();
	private int numeroPrueba;
	private int numeroExpulsados;

	public Prueba(int expulsados, ArrayList<Jugador> lista) {
		this.numeroExpulsados = expulsados;
		this.numeroExpulsados=Prueba.listPruebas.size()+1;
		Prueba.listPruebas.put(this.numeroPrueba, this);//numeroPrueba:la prueba en si
		int contador=0;
		int min=1;
		int max=lista.size();
		
		while(contador<expulsados){
			int azar=(int)(Math.random()*max)+min;
			if(lista.get(azar-1).getActivo()) {
				lista.get(azar-1).setExpulsado();
				contador++;
			}
		}
	}

	public static void verPruebas(int numJugadores) {
		int numPruebas=Prueba.listPruebas.size();
		System.out.println("Numero de pruebas: "+numPruebas);
		int restantes=numJugadores;
		for(int i=1;i<=numPruebas;i++) {
			Prueba p=listPruebas.get(i);
			System.out.printf("Prueba numero: %d. Expulsados: %d.Restantes: %d\n",i,p.numeroExpulsados);
		}
	}
}
