package CompareTo_SaldoBanco;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		CuentasClientes cliente1=new CuentasClientes("Kevin", 100);
		CuentasClientes cliente2=new CuentasClientes("Mario", 300);
		CuentasClientes cliente3=new CuentasClientes("Sergio", 50);
		CuentasClientes cliente4=new CuentasClientes("Ale", 301);
		
		
		ArrayList<CuentasClientes> listaCuentas=new ArrayList<CuentasClientes>(java.util.List.of(cliente1,cliente2,cliente3,cliente4));
		Collections.sort(listaCuentas);
		for(CuentasClientes c:listaCuentas) {
			System.out.println(c);
		}

	}

}