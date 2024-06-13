package ventas.model;

public class Cliente {

	private int id;
	private String nombreCompleto;
	private double capacidadCredito;

	public Cliente() {
		super();
	}

	public Cliente(int id, String nombreCompleto, double capacidadCredito) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.capacidadCredito = capacidadCredito;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public double getCapacidadCredito() {
		return capacidadCredito;
	}

	public void setCapacidadCredito(double capacidadCredito) {
		this.capacidadCredito = capacidadCredito;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombreCompleto=" + nombreCompleto + ", capacidadCredito=" + capacidadCredito
				+ "]";
	}

	

}
