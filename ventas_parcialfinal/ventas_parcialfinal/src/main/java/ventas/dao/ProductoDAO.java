package ventas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ventas.model.Producto;
import ventas.utils.Conexion;

public class ProductoDAO {

	private Producto producto;

	private List<Producto> productos;

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rset;

	public ProductoDAO() {
	}

	public List<Producto> obtenerTodos() {
		try {
			conn = Conexion.getConexion();
			String sql = "select * from productos";
			stmt = conn.prepareStatement(sql);
			rset = stmt.executeQuery();

			productos = new ArrayList<>();

			while (rset.next()) {
				producto = new Producto();

				producto.setId(rset.getInt("id"));
				producto.setDescripcion(rset.getString("descripcion"));
				producto.setPrecio(rset.getDouble("precio"));

				productos.add(producto);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error SQL - obtenerTodos()!");
		}
		return productos;
	}

	public Producto obtenerPorId(int id) {
		try {
			conn = Conexion.getConexion();
			String sql = "select * from productos where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			if (rset.next()) {
				producto = new Producto();
				
				producto.setId(rset.getInt("id"));
				producto.setDescripcion(rset.getString("descripcion"));
				producto.setPrecio(rset.getDouble("precio"));
				
			}
		} catch (SQLException | RuntimeException e) {
			// nada
		}
		return producto;
	}
	
}
