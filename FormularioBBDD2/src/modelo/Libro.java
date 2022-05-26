package modelo;

import java.time.LocalDate;

import exception.isbnException;

public class Libro {

	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private LocalDate fecha;
	private boolean prestado;
	
	public Libro(String isbn, String titulo, String autor, String editorial, LocalDate fecha, boolean prestado) throws isbnException {
		super();
		setIsbn(isbn);
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.fecha = fecha;
		this.prestado = prestado;
	}

	public Libro(String isbn, String titulo, String autor, String editorial, String fecha, boolean prestado) throws isbnException {
		super();
		setIsbn(isbn);
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		setFecha(fecha);
		this.prestado = prestado;
	}



	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws isbnException {
		compruebaIsbn(isbn);
		this.isbn = isbn;
	}

	private void compruebaIsbn(String isbn) throws isbnException {
		isbn = isbn.replace("-", "");
		if (isbn.length() == 13) {
			String numeros = isbn.substring(0, 12);
			String numero = Character.toString(isbn.charAt(12));
			int suma = 0;
			int n = 0;
			try {
				n = Integer.parseInt(numero);
				for (int x = 0; x < numeros.length(); x++) {
					if ((x+1) % 2 == 0) {
						int num = Integer.parseInt(Character.toString(numeros.charAt(x)));
						num*=3;
						suma+=num;
					} else {
						int num = Integer.parseInt(Character.toString(numeros.charAt(x)));
						suma+=num;
					}
				}
			} catch (NumberFormatException e) {
				throw new isbnException();
			}
			int may = suma;
			while (may % 10 != 0) {
				may++;
			}
			if (may - suma != n) {
				throw new isbnException();
			}
		} else {
			throw new isbnException();
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = LocalDate.parse(fecha);
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	@Override
	public String toString() {
		return isbn + "," + titulo + "," + autor + "," + editorial
				+ "," + fecha + "," + prestado;
	}
	
}
