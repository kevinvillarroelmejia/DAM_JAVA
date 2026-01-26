package academia;

import java.util.ArrayList;
import java.util.HashSet;

public class pregunta {
	private String pregunta;
	private String respuestaMala1;
	private String respuestaMala2;
	private String respuestaBuena;
	
	private static ArrayList<pregunta> bancoDePreguntas=new ArrayList<pregunta>();
	
	public pregunta(String pregunta,String respuestaMala1,String respuestaMala2,String respuestaBuena) {
		this.pregunta=pregunta;
		this.respuestaBuena=respuestaBuena;
		this.respuestaMala1=respuestaMala1;
		this.respuestaMala2=respuestaMala2;
		bancoDePreguntas.add(this);
	}
	//Funcion que devuelve el arrayList
	public static ArrayList<pregunta> getBancoDePreguntas() {
		return bancoDePreguntas;
	}
	public void  mostrarPregunta() {
		System.out.println(this.pregunta);
		ArrayList<String> respuestasAletorias=new ArrayList<String>();
		respuestasAletorias.add(this.respuestaBuena);
		respuestasAletorias.add(this.respuestaMala1);
		respuestasAletorias.add(this.respuestaMala2);
		int azar=(int)(Math.random()*3)+1;
		System.out.println(respuestasAletorias.get(azar));
		
		

	}
	public String getPregunta() {
		return pregunta;
	}
	


	
	
}
