package eva2_segundoExamen;

import java.util.HashMap;

public class Prueba {
	private int numPrueba;
	private int expulsados;
	
	private int totalPruebas;
	public static HashMap<Integer, Prueba> listaDePruebas=new HashMap<Integer, Prueba>();
	
	public Prueba (int numPrueba,int expulsados) {
		this.numPrueba=obtenerCodigo();
		this.expulsados=expulsados;
		listaDePruebas.put(numPrueba, this);
		numPrueba++;
		totalPruebas++;
	}
    public int obtenerCodigo() {
    	String codigo = String.valueOf(numPrueba);
        for(int i=codigo.length(); i<3; i++) {
        	codigo += codigo;
        }
        int nuevoCodigo=Integer.parseInt(codigo);
        return nuevoCodigo;
    }
	public int getNumPrueba() {
		return numPrueba;
	}
	public int getTotalPruebas() {
		return totalPruebas;
	}
	public int getExpulsados() {
		return expulsados;
	}
	public void setExpulsados(int expulsados) {
		this.expulsados = expulsados;
	}


    
}
