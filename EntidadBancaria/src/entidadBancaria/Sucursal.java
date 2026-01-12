package entidadBancaria;

public class Sucursal {
	private Banco banco;
	private String calle;
	private int numero;
	private int codigoPostal;
	private String Ciudad;
	private String codigoSucursal;
	
	//lista de cuentas 
	
	//lista de clientes
	
	public Sucursal(Banco banco,String calle,int numero ,int codigoPostal,String Ciudad,String codigoSucursal) {
		this.banco=banco;
		this.calle=calle;
		this.numero=numero;
		this.codigoPostal=codigoPostal;
		this.Ciudad=Ciudad;
		this.codigoSucursal=codigoSucursal;
	}
	
	
}
