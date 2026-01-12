package entidadBancaria;

public class MAIN {

	public static void main(String[] args) {
		
		Banco santander=new Banco("Santader", "ES68 1234");
		Banco Caixa=new Banco("Caixa", "ES43 2342");

		
		Sucursal Madrid=new Sucursal(Caixa, "Calle del Pez", 5, 20229, "Madrid"	, "2342");
		Sucursal Barcelona=new Sucursal(santander, "Calle godella", 5, 56459, "Barcelona","2342");

		Clientes Oscar=new Clientes(Madrid, "OScar", "Teradillo", "X3432223", 324455555);
		Clientes Kevin= new  Clientes(Barcelona, "Kevin Rashid", "Villarroel Mejia", "3422232F", 234242299);
		
		
		//FUNCIONES ESTATICAS --- NO SON LLAMADAS POR NINGUN OBJETO 
		Sucursal.añadirClientes(Oscar);
		Sucursal.añadirClientes(Kevin);

		
		Sucursal.listarClientes();		
		Banco.listarSucursales();
	}
}
