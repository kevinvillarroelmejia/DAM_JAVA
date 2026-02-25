package entidadBancaria;

public class MAIN {

	public static void main(String[] args) {
		
		Banco santander=new Banco("Santader", "ES68 1234");
		Banco Caixa=new Banco("Caixa", "ES43 2342");

		//IBAN CODIGO > BANCO > SUCURSAL > CUENTA 
		
		Sucursal Madrid=new Sucursal(Caixa, "Calle del Pez", 5, 20229, "Madrid"	, "2342");
		Sucursal Barcelona=new Sucursal(santander, "Calle godella", 5, 56459, "Barcelona","2342");

		Clientes Oscar=new Clientes(Madrid, "OScar", "Teradillo", "X3432223", 324455555);
		Clientes Kevin= new  Clientes(Barcelona, "Kevin Rashid", "Villarroel Mejia", "3422232F", 234242299);
//		Clientes KevinOscar= new  Clientes(Barcelona, "Kevin Rashid" ,"Kevin Rashid", "Villarroel Mejia", "3422232F", 234242299);
		Clientes Ale= new  Clientes(Barcelona, "Alejandro", "Morales", "4999999F", 555522299);
		
		//Cuentas con un solo TITULAR
		CuentasCorrientes kevin=new CuentasCorrientes(Kevin, 30223, Barcelona, "3442");
		CuentasCorrientes ale=new CuentasCorrientes(Ale, 887, Barcelona, "5555");
		
		// Clientes con dos TITULARES
		CuentasCorrientes CuentaKevinALe=new CuentasCorrientes(Ale, Kevin,2322332, Barcelona, "2323");
		
		
		//FUNCIONES ESTATICAS --- NO SON LLAMADAS POR NINGUN OBJETO 
		//		Sucursal.ayadirClientes(Oscar);
		//		Sucursal.ayadirClientes(Kevin);

		Sucursal.listarClientes();
		Banco.listarSucursales();
	}
}
