package listaEspera;

public class Main {

	public static void main(String[] args) {
		
		Especialidad e1=new Especialidad("Traumotologia");
		Especialidad e2=new Especialidad("Urologia");
		Especialidad e3=new Especialidad("Dermatoliga");
		Especialidad e4=new Especialidad("Oftalmologia");

		Medico m1=new Medico("Jorge", e3);
		Medico m2=new Medico("Kevin", e1);
		Medico m3=new Medico("Elena", e1);

		Paciente p1=new Paciente("Antonio Costa");
		Paciente p2=new Paciente("Ines Rodrigo");
		
		p1.pideCita(e3);
		p1.pideCita(e1);
		p2.pideCita(e2);
		p2.pideCita(e1);
		p2.pideCita(e1);
		
		
	}

}
