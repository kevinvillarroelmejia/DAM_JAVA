package academia;

import java.util.ArrayList;
import java.util.HashSet;

public class pregunta {
	private String pregunta;
	private String respuestaMala1;
	private String respuestaMala2;
	private String respuestaBuena;
	private String solucion;

	private static ArrayList<pregunta> bancoDePreguntas = new ArrayList<pregunta>();

	public pregunta(String pregunta, String respuestaMala1, String respuestaMala2, String respuestaBuena) {
		this.pregunta = pregunta;
		this.respuestaBuena = respuestaBuena;
		this.respuestaMala1 = respuestaMala1;
		this.respuestaMala2 = respuestaMala2;
		bancoDePreguntas.add(this);
	}

	// Funcion que devuelve el arrayList
	public static ArrayList<pregunta> getBancoDePreguntas() {
		return bancoDePreguntas;
	}

	public void  mostrarPregunta() {
		System.out.println(this.pregunta);
		ArrayList<String> respuestasAletorias=new ArrayList<String>();
		respuestasAletorias.add(this.respuestaBuena);
		respuestasAletorias.add(this.respuestaMala1);
		respuestasAletorias.add(this.respuestaMala2);
		
		HashSet<Integer> posiciones=new HashSet<Integer>();
		ArrayList<Integer> posiciones2=new ArrayList<Integer>();
		while(posiciones.size()!=3) {
			int azar=(int)(Math.random()*3);
			if(posiciones.add(azar)) {
				posiciones2.add(azar);
			}
		}
		int u=0;
		String[] letras= {"A) ","B) ","C) "};
		for(int i:posiciones2) {		
			switch (i) {
			case 0:
				respuestasAletorias[u]=letras[i]+this.respuestaMala1;
				this.solucion=letras[u];
				break;
			case 1:
				respuestasAletorias[u] =letras[i]+this.respuestaMala2;
				break;
			case 2:
				respuestasAletorias[u] =letras[i]+ this.respuestaBuena);				
				break;
			}
			u++;
		}
	}

	public String getSolucion() {
		return this.solucion;
	}

	// ArrayList<Integer> azaresArrayList = null;
//		HashSet<Integer> azares=null;
//		for(int i=0;i<3;i++) {
//			int azar=(int)(Math.random()*3)+1;
//			azares=new HashSet<Integer>();
//		if(azares.add(azar)) {
//			TERMINAR
//		}
//			
//		}
//		azaresArrayList=new ArrayList<Integer>(azares);
//		for(int x=0;x<azaresArrayList.size()+2;x++) {
//			System.out.println(respuestasAletorias.get(x));
//		}
//		
	public void solucionExamen() {
		for (pregunta p : bancoDePreguntas) {
			System.out.println(p.getSolucion());
		}
	}

	public String getPregunta() {
		return pregunta;
	}

}
