package empresaSeguros;

abstract class vehiculos {

	protected String matricula;
	protected int añoFabricacion;
	protected conductor conductor;
	
	public vehiculos(String matricula,int añoFabricacion,conductor c) {
		this.matricula=matricula;
		this.añoFabricacion=añoFabricacion;
		this.conductor=c;
	}

}
