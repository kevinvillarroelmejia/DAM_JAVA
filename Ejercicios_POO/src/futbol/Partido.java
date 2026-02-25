package futbol;

public class Partido {
	
	private Equipo local;
	private Equipo visitante;
	
	public Partido(Equipo equipo1, Equipo equipo2) {
		this.local=equipo1;
		this.visitante=equipo2;
	}
	//que reciba dos equipos y eque actulice la clasificacion
	public void resultadoPartido(int golesVisitante,int golesLocal) {
		visitante.setPartidosGanados(+1);
		visitante.setGolesAFavor(golesLocal);
		if(golesVisitante>golesLocal) {
			local.ganaPartido();
			visitante.pierdePartido();
		}else if(golesVisitante<golesLocal) {
			visitante.ganaPartido();
			local.pierdePartido();
		}else {
			visitante.empataPartido();
			local.empataPartido();
		}
		local.cambiaGoles(golesVisitante,golesLocal);
		visitante.cambiaGoles(golesLocal,golesVisitante);

	}

}
