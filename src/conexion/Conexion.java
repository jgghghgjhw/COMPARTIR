package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	Connection cx=null;

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost/puntodeventa", "root", "");
			System.out.println("CONEXION EXITOSA");
		} catch (SQLException e) {
			System.out.println("ALGO SALIO MAL");
			e.printStackTrace();
		}
		return cx;
	}

	public static void main(String[] cecyto) {
		Conexion de = new Conexion();
		de.conectar();
	}
}
