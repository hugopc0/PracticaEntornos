package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Libro;

public class LibroDao {
	
	private Connection cn;

	public LibroDao(Connection cn) {
		super();
		this.cn = cn;
	}

	public List<Libro> getConsulta(String sql) throws SQLException {
		List<Libro> libros = new ArrayList<Libro>();
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("idLibros");
			String titulo = rs.getString("titulo");
			String autor = rs.getString("autor");
			String editorial = rs.getString("editorial");
			String isbn = rs.getString("isbn");
			boolean prestado = rs.getBoolean("prestado");
			Date fechaPrestamo = rs.getDate("fechaPrestamo");
			Date fechaDevolucion = rs.getDate("fechaDevolucion");
			java.sql.Timestamp fechaAlta = rs.getTimestamp("fechaAlta");
			Libro libro = new Libro(id, isbn, titulo, autor, editorial, prestado, fechaPrestamo, fechaDevolucion, fechaAlta);
			libros.add(libro);
		}
		return libros;
	}
	
}
