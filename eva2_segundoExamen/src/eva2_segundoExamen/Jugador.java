package eva2_segundoExamen;

public class Jugador {
	
	private String numIdentificador;
	private boolean estadoJugador=true;
	
	private int  contadorJugador;
	
	public Jugador(String numIdentificador,boolean estadoJugador) {
		this.numIdentificador=obtenerCodigo();
//		this.estadoJugador=estadoJugador; //activo o expulsado
		contadorJugador++;
	}

    public String obtenerCodigo() {
    	String codigo = String.valueOf(contadorJugador);
        for(int i=codigo.length(); i<3; i++)
        	codigo = "0" + codigo;
        codigo += codigo;
        return codigo;
    }

    
    public String numIdentificador() {
    	return numIdentificador;
    }

	public boolean isEstadoJugador() {
		return estadoJugador;
	}

}
