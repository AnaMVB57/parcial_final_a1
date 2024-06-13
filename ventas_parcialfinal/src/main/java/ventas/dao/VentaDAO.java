package ventas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ventas.model.Venta;
import ventas.utils.Conexion;

public class VentaDAO {

	private Venta venta;

	private List<Venta> ventas;

	private ClienteDAO clienteDAO = new ClienteDAO();

	private ProductoDAO productoDAO = new ProductoDAO();

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rset;

	public VentaDAO() {
	}

	public List<Venta> obtenerTodos() {
		try {
			conn = Conexion.getConexion();
			String sql = "select * from ventas";
			stmt = conn.prepareStatement(sql);
			rset = stmt.executeQuery();

			ventas = new ArrayList<>();

			while (rset.next()) {
				venta = new Venta();

				venta.setId(rset.getInt("id"));
				venta.setIdCliente(rset.getInt("id_cliente"));
				venta.setIdProducto(rset.getInt("id_producto"));
				venta.setPrecio(rset.getDouble("precio"));
				venta.setCantidad(rset.getInt("cantidad"));
				venta.setFormaPago(rset.getString("forma_pago"));
				venta.setFecha(rset.getDate("fecha"));
				venta.setAprobada(rset.getBoolean("aprobada"));
				venta.setCliente(clienteDAO.obtenerPorId(venta.getIdCliente()));
				venta.setProducto(productoDAO.obtenerPorId(venta.getIdProducto()));

				ventas.add(venta);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error SQL - obtenerTodos()!");
		}
		return ventas;

	}

	public int agregar(Venta venta) {
		try {
			// Obtiene la conexión del Singleton
			conn = Conexion.getConexion();

			// Guardamos la sentencia SQL que vamos a usar
			String sql = "insert into ventas(id_cliente, id_producto, precio, cantidad, forma_pago, fecha, aprobada) values(?, ?, ?, ?, ?, ?, ?)";

			// Compilamos la consulta
			stmt = conn.prepareStatement(sql);

			// Llenamos cada uno de los parámetros de la consulta SQL
			stmt.setInt(1, venta.getIdCliente());
			stmt.setInt(2, venta.getIdProducto());

			// Instanciamos un objeto del paquete java.sql.Date y utilizamos los getters de
			// fecha
			// getTime() convierte la fecha a milisegundos para que pueda ser guardada por
			// la BD
			stmt.setDouble(3, venta.getPrecio());
			stmt.setInt(4, venta.getCantidad());
			stmt.setString(5, venta.getFormaPago());
			stmt.setDate(6, new java.sql.Date(venta.getFecha().getTime()));
			stmt.setBoolean(7, venta.isAprobada());

			// Ejecutamos la instrucción
			return stmt.executeUpdate(); // Si todo sale bien, retorna un 1. Por eso el método retorna un entero

			// Si hay algún error, muestra la excepción
		} catch (SQLException | RuntimeException e) {
			System.out.println(e.toString());
			return 0;
		}

	}

	public void modificar(Venta venta) {
		try {
			conn = Conexion.getConexion();
			String sql = "update ventas set id_cliente=?, id_producto=?, precio=?, cantidad=?, forma_pago=?, fecha=?, aprobada=? where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, venta.getIdCliente());
			stmt.setInt(2, venta.getIdProducto());
			stmt.setDouble(3, venta.getPrecio());
			stmt.setInt(4, venta.getCantidad());
			stmt.setString(5, venta.getFormaPago());
			stmt.setDate(6, new java.sql.Date(venta.getFecha().getTime()));
			stmt.setBoolean(7, venta.isAprobada());
			stmt.setInt(8, venta.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			//
			e.printStackTrace();
		}
	}

	public void eliminar(int id) {
		try {
			conn = Conexion.getConexion();
			String sql = "delete from ventas where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException | RuntimeException e) {
			//
		}
	}

	public Venta obtenerPorId(int id) {
		try {
			conn = Conexion.getConexion();
			String sql = "select * from ventas where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			if (rset.next()) {
				venta = new Venta();

				venta.setId(rset.getInt("id"));
				venta.setIdCliente(rset.getInt("id_cliente"));
				venta.setIdProducto(rset.getInt("id_producto"));
				venta.setPrecio(rset.getDouble("precio"));
				venta.setCantidad(rset.getInt("cantidad"));
				venta.setFormaPago(rset.getString("forma_pago"));
				venta.setFecha(rset.getDate("fecha"));
				venta.setAprobada(rset.getBoolean("aprobada"));
				venta.setCliente(clienteDAO.obtenerPorId(venta.getIdCliente()));
				venta.setProducto(productoDAO.obtenerPorId(venta.getIdProducto()));
			}
		} catch (SQLException | RuntimeException e) {

		}
		return venta;
	}

}
