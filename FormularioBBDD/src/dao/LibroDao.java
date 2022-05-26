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
	private List<Libro> libros;
	private int c = 0;

	public LibroDao(Connection cn) {
		super();
		this.cn = cn;
	}
	
	public List<Libro> getConsulta(String sql) throws SQLException {
		libros = new ArrayList<Libro>();
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String titulo = rs.getString("titulo");
			String autor = rs.getString("autor");
			String editorial = rs.getString("editorial");
			String isbn = rs.getString("isbn");
			boolean prestado = rs.getBoolean("prestado");
			Date fecha = rs.getDate("fecha");
			Libro libro = new Libro(isbn, titulo, autor, editorial, fecha, prestado);
			libros.add(libro);
			c++;
		}
		return libros;
		
	}

	public int getC() {
		return c;
	}
	
}
