package Boletin12_NotasTareas;

public class NotaNormal extends Nota {
//	private ArrayList<NotaNormal> listaNotas=new ArrayList<NotaNormal>();

	public NotaNormal(String titulo, String descripcion, String color) {
		super(titulo, descripcion, color);
//		listaNotas.add(this);
	}

	@Override
	void crearNota(String titulo, String descripcion, String color) {
		NotaNormal notaNormal = new NotaNormal(titulo, descripcion, color);
	}

	public void eliminarNota() {
		listaNotas.remove(this);
	}

	@Override
	public void listaNota() {
		System.out.println(this);
	}

}
