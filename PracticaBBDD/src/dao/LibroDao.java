package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exception.isbnException;
import modelo.Libro;

public class LibroDao {

	private Connection conn;

	public LibroDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public List<Libro> leer(String sql) throws SQLException, isbnException {
		List<Libro> libros = new ArrayList<Libro>();
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			int idLibros = rs.getInt("idlibros");
			String titulo = rs.getString("titulo");
			String autor = rs.getString("autor");
			String editorial = rs.getString("editorial");
			boolean prestado = rs.getBoolean("prestado");
			LocalDate fechaPrestamo;
			LocalDate fechaDevolucion;
			LocalDateTime fechaAlta;
			if (rs.getDate("fechaPrestamo") == null) {
				fechaPrestamo = null;
				fechaDevolucion = null;
				fechaAlta = null;
			} else {
				fechaPrestamo = rs.getDate("fechaPrestamo").toLocalDate();
				fechaDevolucion = rs.getDate("fechaDevolucion").toLocalDate();
				fechaAlta = rs.getTimestamp("fechaAlta").toLocalDateTime();
			}
			String isbn = rs.getString("isbn");
			Libro libro = new Libro(idLibros, titulo, autor, editorial, prestado, fechaPrestamo, fechaDevolucion, isbn, fechaAlta);
			libros.add(libro);
		}
		return libros;
	}
	
	public void editar(Libro libro, String sql) throws SQLException {
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, libro.getTitulo());
		pst.setString(2, libro.getAutor());
		pst.setString(3, libro.getEditorial());
		pst.setBoolean(4, libro.isPrestado());
		pst.setString(5, libro.getIsbn());
		pst.executeUpdate();
	}
	
	public void agregar(Libro libro, String sql) throws SQLException {
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, libro.getIdLibro());
		pst.setString(2, libro.getTitulo());
		pst.setString(3, libro.getAutor());
		pst.setString(4, libro.getEditorial());
		pst.setBoolean(5, libro.isPrestado());
		if (libro.getFechaPrestamo() == null) {
			pst.setDate(6, null);
			pst.setDate(7, null);
			pst.setDate(9, null);
		} else {
			pst.setDate(6, Date.valueOf(libro.getFechaPrestamo()));
			pst.setDate(7, Date.valueOf(libro.getFechaDevolucion()));
			pst.setTimestamp(9, Timestamp.valueOf(libro.getFechaAlta()));
		}
		pst.setString(8, libro.getIsbn());
		pst.executeUpdate();
	}
	
	public void borrar(String isbn, String sql) throws SQLException {
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, isbn);
		pst.executeUpdate();
	}
	
}
