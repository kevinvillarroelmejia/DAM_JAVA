package anime_mangas;

public class manga {

	private String autor;
	private String titulo;//JAPONES OBLIGATORIO ESPAÑOL
	private String genero;
	private int ultNumeroColeccion;
	
//	private manga[] estanteria=new manga[3];//PARA GUARDAR LOS LIBROS

	public String getAutor() {
		return autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {//para ser editado para el Español
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public int getUltNumeroColeccion() {
		return ultNumeroColeccion;
	}
	public void setUltNumeroColeccion(int ultNumeroColeccion) {
		this.ultNumeroColeccion = ultNumeroColeccion;
	}
	
	//CONSTRUCTOR
	public manga(String aut,String title,String gene,int ultPublicado) {
		this.autor=aut;
		this.titulo=title;
		this.genero=gene;
		this.ultNumeroColeccion=ultPublicado;
	}
	
}
