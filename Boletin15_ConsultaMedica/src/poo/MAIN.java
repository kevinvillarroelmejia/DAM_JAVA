package poo;

public class MAIN {

	public static void main(String[] args) {

		CentroMedico ramonCajal=new CentroMedico("Ramon y Cajal", "CM-3434");
		CentroMedico quiron=new CentroMedico("Quiron", "CM-5655");

		
		Medico sainz= new Medico(ramonCajal, "Carlos", "Sainz", "Cirujano", "990099");
		
		Paciente kevin=new Paciente(quiron, "Kevin", "Villarroel", "99999999F", 111111111);
		
//		Consulta consulta1=new Consulta(, kevin, sainz, "Dolor de cabeza", "Paracetamol");
		
		sainz.cambiaCentro(quiron);//funcion que cambia de centro medico
		
		ramonCajal.listaMedicos();
		quiron.listaMedicos();
		
		quiron.listaPacientes();
		
	}

}
