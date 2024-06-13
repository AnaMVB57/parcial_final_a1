package ventas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ventas.model.Cliente;
import ventas.utils.Conexion;

public class ClienteDAO {

	private Cliente cliente;

	private List<Cliente> clientes;

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rset;

	public List<Cliente> obtenerTodos() {
		try {
			conn = Conexion.getConexion();
			String sql = "select * from clientes";
			stmt = conn.prepareStatement(sql);
			rset = stmt.executeQuery();

			clientes = new ArrayList<>();

			while (rset.next()) {
				cliente = new Cliente();

				cliente.setId(rset.getInt("id"));
				cliente.setNombreCompleto(rset.getString("nombreCompleto"));
				cliente.setCapacidadCredito(rset.getDouble("capacidadCredito"));

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error SQL - obtenerTodos()!");
		}
		return clientes;
	}

	public Cliente obtenerPorId(int id) {
		try {
			conn = Conexion.getConexion();
			String sql = "select * from clientes where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			if (rset.next()) {
				cliente = new Cliente();

				cliente.setId(rset.getInt("id"));
				cliente.setNombreCompleto(rset.getString("nombreCompleto"));
				cliente.setCapacidadCredito(rset.getDouble("capacidadCredito"));
			}
		} catch (SQLException | RuntimeException e) {

		}

		return cliente;
	}
}
