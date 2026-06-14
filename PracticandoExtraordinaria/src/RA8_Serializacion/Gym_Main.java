package RA8_Serializacion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class Gym_Main {

	public static void main(String[] args) {

		String rutaClientesGYM="clientes_gym.csv";
		String rutaClientes="clientes.dat";
		escribirClientes(rutaClientesGYM,rutaClientes);
		clientesPremiunElite(rutaClientes);
		clientesVencePronto(rutaClientes);
		cambiarSuscripcion(rutaClientes, "PedroSanchez");
		
	}
	public static void escribirClientes(String ficheroLectura,String ficheroEscritura) {
		Cliente cliente = null;
		ArrayList<Cliente> listaClientes=new ArrayList<Cliente>();
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ficheroLectura));
			String linea;
			String[] listaCliente=new String[3];
			while ((linea = lector.readLine()) != null) {
				listaCliente=linea.split(";");
				cliente=new Cliente(listaCliente[0],listaCliente[1],Integer.parseInt(listaCliente[2]));
				listaClientes.add(cliente);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		
		//GUARDANDO LISTA
		try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(ficheroEscritura))) {
			binario.writeObject(listaClientes);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	//======== COMO HE GUARDADO UNA LISTA RECUPERO UNA LISTA
	public static void clientesPremiunElite(String ficheroBinario) {
		ArrayList<Cliente> lista = null;
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(ficheroBinario))) {
			lista = (ArrayList<Cliente>) binario.readObject();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Cliente premium o elite");
		for(Cliente cliente:lista) {
			if(cliente.getSuscripcion().equalsIgnoreCase("premium")||cliente.getSuscripcion().equalsIgnoreCase("elite")) {
				System.out.println(cliente);
			}
		}
	}

	public static void clientesVencePronto(String ficheroBinario) {
		ArrayList<Cliente> lista = null;
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(ficheroBinario))) {
			lista = (ArrayList<Cliente>) binario.readObject();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Clientes con poco contrato");
		for(Cliente cliente:lista) {
			if(cliente.getMesesRestanteContrato()<=2) {
				System.out.println(cliente);
			}
		}
	}
	
	public static void cambiarSuscripcion(String ficheroBinario,String nombreCliente) {
		ArrayList<Cliente> lista = null;
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(ficheroBinario))) {
			lista = (ArrayList<Cliente>) binario.readObject();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Cambiar suscripcion cliente");
		for(Cliente cliente:lista) {
			if(cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
				cliente.setSuscripcion("elite");
				System.out.println("Suscripcion cambiada: ");
				System.out.println(cliente);
			}
		}
		//GUARDANDO LISTA
		try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(ficheroBinario))) {
			binario.writeObject(lista);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	
	
	

}
