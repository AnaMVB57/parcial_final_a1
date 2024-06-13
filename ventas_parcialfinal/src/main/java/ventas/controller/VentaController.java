package ventas.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ventas.dao.ClienteDAO;
import ventas.dao.ProductoDAO;
import ventas.dao.VentaDAO;
import ventas.model.Cliente;
import ventas.model.Producto;
import ventas.model.Venta;

@WebServlet("/ventas")
public class VentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VentaDAO ventaDAO = new VentaDAO();
	private ClienteDAO clienteDAO = new ClienteDAO();
	private ProductoDAO productoDAO = new ProductoDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		// Traemos el valor del parámetro accion del archivo index
		String accion = request.getParameter("accion");

		// Verificamos la acción elegida y procedemos según el caso

		if (accion.equalsIgnoreCase("listar")) {

			// Obtenemos el listado de amigos para mostrarlos
			List<Venta> ventas = ventaDAO.obtenerTodos();

			// Declaramos el atributo de la solicitud
			request.setAttribute("ventas", ventas);

			// Despachamos la información al jsp para que la muestre
			request.getRequestDispatcher("ventas/listar_ventas.jsp").forward(request, response);

		} else if (accion.equalsIgnoreCase("agregar")) {

			// Añadimos las listas de objetos para construir el formulario de venta
			List<Producto> productos = productoDAO.obtenerTodos();
			List<Cliente> clientes = clienteDAO.obtenerTodos();

//			int productoId = Integer.parseInt(request.getParameter("producto"));
//			Producto prodElegido = productoDAO.obtenerPorId(productoId);

//			String productoIdStr = request.getParameter("producto");
//			double precio = 0;
//			Producto prodElegido = null;
//
//			if (productoIdStr != null && !productoIdStr.isEmpty()) {
//				try {
//					int productoId = Integer.parseInt(productoIdStr);
//					prodElegido = productoDAO.obtenerPorId(productoId);
//					if (prodElegido != null) {
//						precio = prodElegido.getPrecio();
//					}
//				} catch (NumberFormatException e) {
//					e.printStackTrace();
//				}
//			}

			request.setAttribute("productos", productos);
//			request.setAttribute("precio", precio);
//			request.setAttribute("prodElegido", prodElegido);
			request.setAttribute("clientes", clientes);
			request.getRequestDispatcher("ventas/agregar_venta.jsp").forward(request, response);

		} else if (accion.equalsIgnoreCase("consultar")) {

			// Tomamos el id de la venta para mostrarla detalladamente
			int id = Integer.parseInt(request.getParameter("id"));
			Venta venta = ventaDAO.obtenerPorId(id);
			request.setAttribute("venta", venta);
			request.getRequestDispatcher("ventas/consultar_venta.jsp").forward(request, response);

		} else if (accion.equalsIgnoreCase("eliminar")) {

			int id = Integer.parseInt(request.getParameter("id"));
			ventaDAO.eliminar(id);
			response.sendRedirect("ventas?accion=listar");

		} else if (accion.equalsIgnoreCase("modificar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Venta venta = ventaDAO.obtenerPorId(id);
			List<Producto> productos = productoDAO.obtenerTodos();
			List<Cliente> clientes = clienteDAO.obtenerTodos();
			request.setAttribute("venta", venta);
			request.setAttribute("productos", productos);
			request.setAttribute("clientes", clientes);
			request.getRequestDispatcher("ventas/modificar_venta.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		int id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
		int clienteId = Integer.parseInt(request.getParameter("cliente"));
		int productoId = Integer.parseInt(request.getParameter("producto"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String formaPago = request.getParameter("formaPago");
		String strFecha = request.getParameter("fecha");
		Date fecha = null;
		try {
			if (strFecha != null && !strFecha.isEmpty()) {
				fecha = sdf.parse(strFecha);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		boolean aprobada = request.getParameter("aprobada") == null ? false : true;
//		int ciudadId = Integer.parseInt(request.getParameter("ciudadId"));

		Venta venta = new Venta(id, clienteId, productoId, precio, cantidad, formaPago, fecha, aprobada);

		if (id == 0) {
			ventaDAO.agregar(venta);
		} else {
			ventaDAO.modificar(venta);
		}
		response.sendRedirect("ventas?accion=listar");

	}

}
