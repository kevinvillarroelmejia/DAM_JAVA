package solucionExamen;

abstract class Empleado {
    protected String codigo;
    protected String nombre;
    protected double salarioBase;
    
    protected static int contadorEmpleados = 0;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        contadorEmpleados++;
        this.codigo = obtenerCodigo();
        System.out.printf("%s. Código %s. ", this.nombre, this.codigo);        	
    }

    public String getNombre() {
    	return this.nombre;
    }
    
    public String getCodigo() {
    	return this.codigo;
    }

    public static String obtenerCodigo() {
    	String codigo = String.valueOf(contadorEmpleados);
        for(int i=codigo.length(); i<3; i++)
        	codigo = "0" + codigo;
        codigo = "EMP-" + codigo;
        return codigo;
    }
    
    public abstract void calcularSueldo();

}
