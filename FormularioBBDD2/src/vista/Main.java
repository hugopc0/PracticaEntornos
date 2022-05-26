package vista;

import java.sql.Connection;
import java.sql.SQLException;

import controlador.LibroController;
import dao.DbConnection;
import exception.isbnException;
import modelo.Libro;

public class Main {

	public static void main(String[] args) {
		/*try {
			Libro libro = new Libro("978-84-663-2914-9", "El Capitan Alatriste", "Arturo Perez Reverte", "Alfaguara", "2022-03-16", true);
		} catch (isbnException e) {
			System.out.println(e.getMessage());
		}*/
		/*DbConnection dbConnection = new DbConnection();
		Connection conn = dbConnection.getConn();
		LibroController libroController = new LibroController(conn);
		try {
			for (Libro libro : libroController.leerDatos()) {
				System.out.println(libro);
			}
		} catch (SQLException | isbnException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		dbConnection.disconnect();*/
		frmPlantilla frmPlantilla = new frmPlantilla();
	}

}
