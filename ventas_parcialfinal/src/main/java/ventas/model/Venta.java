package ventas.model;

import java.util.Date;

public class Venta {

	private int id;
	private int idCliente;
	private int idProducto;
	private double precio;
	private int cantidad;
	private String formaPago;
	private Date fecha;
	private boolean aprobada;
	private Cliente cliente;
	private Producto producto;
	
	public Venta() {
		super();
	}

	public Venta(int id, int idCliente, int idProducto, double precio, int cantidad, String formaPago, Date fecha,
			boolean aprobada) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.formaPago = formaPago;
		this.fecha = fecha;
		this.aprobada = aprobada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isAprobada() {
		return aprobada;
	}

	public void setAprobada(boolean aprobada) {
		this.aprobada = aprobada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", idCliente=" + idCliente + ", idProducto=" + idProducto + ", precio=" + precio
				+ ", cantidad=" + cantidad + ", formaPago=" + formaPago + ", fecha=" + fecha + ", aprobada=" + aprobada
				+ "]";
	}
	
	
	
	
}
