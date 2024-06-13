package ventas.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	  private static Connection cnx = null;

	  public static Connection getConexion() {
	    try {
	      if (cnx == null) {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        cnx = DriverManager.getConnection("jdbc:mysql://localhost/ventas_a1?serverTimezone=America/Bogota", "root", "");
	      }

	      return cnx;
	    } catch (ClassNotFoundException | SQLException ex) {
	      throw new RuntimeException("Error al crear la conexion!", ex);
	    }
	  }
	}
