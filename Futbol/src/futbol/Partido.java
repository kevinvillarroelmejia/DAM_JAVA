package futbol;

public class Partido {
	
	private Equipo equipo1;
	private Equipo equipo2;
	
	public Partido(Equipo equipo1, Equipo equipo2) {
		this.equipo1=equipo1;
		this.equipo2=equipo2;
	}
	//que reciba dos equipos y eque actulice la clasificacion
	public void resultadoPartido(int golesVisitante,int golesLocal) {
		equipo2.setPartidosGanados(+1);
		equipo2.setGolesAFavor(golesLocal);
		if(golesVisitante>golesLocal) {
			
		}
	}

}
