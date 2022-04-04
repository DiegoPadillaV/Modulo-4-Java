package VomisTR;

public class Cliente {
	
	private int idCliente;
	private String rutCliente;
	private String nombre;
	private String telefono;
	private String correoElectronico;
	
	public Cliente() {
	}

	public Cliente(int idCliente, String rutCliente, String nombre, String telefono, String correoElectronico) {
		this.idCliente = idCliente;
		this.rutCliente = rutCliente;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}

	public int getId() {
		return idCliente;
	}

	public void setId(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	
	
	
}
