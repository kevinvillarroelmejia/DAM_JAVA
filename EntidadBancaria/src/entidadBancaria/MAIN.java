package entidadBancaria;

public class MAIN {

	public static void main(String[] args) {
		
		Banco santander=new Banco("Santader", "ES68 1234");
		Sucursal Madrid=new Sucursal(santander, "Calle del Pez", 5, 20229, "Madrid"	, "2342");
		

	}
}
