package empresaSeguros;

public class main {

	public static void main(String[] args) {
		//OBJETO CONDUCTOR KEVIN DNI-- PUNTOS CARNET-- NACIMIENTO-- AÑO CARNET
		conductor kevin=new conductor("51553933f", 4, 2007,2020);
		conductor ale=new conductor("24543933f", 8, 2003,2027);
		System.out.println("EDAD KEVIN--> "+kevin.edad()+" AÑOS");
		System.out.println("ANTIGUEDAD DEL CARNET DE KEVIN --> "+kevin.antiguedad()+" AÑOS");

		//OBJETO COCHES Y MOTOS HEREDAN COSAS DE VEHICULOS
		motos kawasaky=new motos("44444mb",2005,kevin);
		coches laFerrari=new coches("1", 2010, ale);
		
		System.out.println("IMPORTE SEGURO A TODO RIESGO --> "+kevin.seguroTodoRiesgo()+"€");
		System.out.println("IMPORTE A TERCEROS "+kevin.seguroTerceros()+"€");
		
	}
}
