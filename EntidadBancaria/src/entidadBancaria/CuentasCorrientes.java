package entidadBancaria;

public class CuentasCorrientes {
	
	private Clientes cliente;
	private Clientes cliente2=null;//TODO NULL POR QUE NO ES OPCIONAL
	private float saldo;
	private Sucursal sucursal;
	private String codigo;
	
	// UN TITULAR
	public CuentasCorrientes(Clientes clientes,float saldo,Sucursal sucursal,String codigo) {
		this.cliente=clientes;
		this.saldo=saldo;
		this.sucursal=sucursal;
		this.codigo=codigo;
		
		
		clientes.anydeCuenta(this);
		sucursal.ayadirCuenta(this);
	}
	
	//TODO DOS TITULARES
	public CuentasCorrientes(Clientes clientes1,Clientes clientes2,float saldo,Sucursal sucursal,String codigo) {
		this.cliente=clientes1;
		this.cliente2=clientes2;
		this.saldo=saldo;
		this.sucursal=sucursal;
		this.codigo=codigo;
		
		clientes1.anydeCuenta(this);
		clientes2.anydeCuenta(this);
		sucursal.ayadirCuenta(this);
	}
	
	//TODO CONTATENANDO LOS CODIGOS PARA HACER EL IBAN
	public String getIBAN() {
		return sucursal.getCodigoCompleto()+" "+this.codigo;
	}
	
	//TODO DEVOLVIENDO EL SALDO
	public double getSaldo() {		
		return this.saldo;
	}
	public void verCuenta() {
		System.out.println(this.getIBAN()+" - "+this.getSaldo()+"€");
	}

}
