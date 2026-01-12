package entidadBancaria;

public class CuentasCorrientes {
	
	private Clientes clientes;
	private float saldo;
	private Sucursal sucursal;
	private String codigo;
	
	//UN TITULAR
	public CuentasCorrientes(Clientes clientes,float saldo,Sucursal sucursal,String codigo) {
		this.clientes=clientes;
		this.saldo=saldo;
		this.sucursal=sucursal;
		this.codigo=codigo;
	}
	//DOS TITULARES
	public CuentasCorrientes(Clientes clientes1,Clientes clientes2,float saldo,Sucursal sucursal,String codigo) {
		this.clientes=clientes1;
		this.clientes=clientes2;
		this.saldo=saldo;
		this.sucursal=sucursal;
		this.codigo=codigo;
	}

}
