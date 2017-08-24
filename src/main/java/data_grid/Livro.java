package data_grid;

import java.io.Serializable;

//Serialization is the conversion of an object to a series of bytes

public class Livro implements Serializable {
	
	/** The serialization runtime associates with each serializable class 
	 * a version number, called a serialVersionUID which is used to verify that 
	 * the sender and receiver of a serialized object have loaded classes for 
	 * that object that are compatible with respect to serialization
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private Integer isbn;
	private String autor;
	
	public Livro () {
		
	}
	
	public Livro(String titulo, Integer isbn, String autor) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [titulo = " + titulo + ", isbn=" + isbn + ", autor=" + autor + "]";
	}
	
	

}
