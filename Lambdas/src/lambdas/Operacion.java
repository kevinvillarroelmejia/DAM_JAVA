package lambdas;

//decorador interfaz para crear funciones lamdas
@FunctionalInterface
public interface Operacion {
	
	//esto va ser el medio para crear la funcion lamda
	//definiendo como va ser la funcion lamda
	int ejecutar(int a ,int b);
	
	//si hago dos metodos da error
	//String saludar(String uno,String dos);
	
	
	
	

}
