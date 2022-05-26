package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.LibroDao;
import exception.isbnException;
import modelo.Libro;

public class LibroController {

	Connection cn;
	List<Libro> libros;

	public LibroController(Connection cn) {
		this.cn = cn;
	}
	
	public List<Libro> leerDatos() throws SQLException, isbnException {
		LibroDao libroDao = new LibroDao(cn);
		return libroDao.getConsulta("select * from libros;");
	}
	
	public boolean insertarDatos(Libro libro) throws SQLException {
		LibroDao libroDao = new LibroDao(cn);
		libroDao.insertar(libro, "insert into libros values(?, ?, ?, ?, ?, ?)");
		return true;
	}
	
	public void borrarDatos(Libro libro) throws SQLException {
		LibroDao libroDao = new LibroDao(cn);
		libroDao.borrar(libro, "delete from libros where isbn = ?");
	}
	
}
