package VomisTR;

public class Ejecutivo {
	
	private int idEjecutivo;
	private String rutEjecutivo;
	private String nombreEjecutivo;
	private String tipoEjecutivo;
	private String password;
	
	public Ejecutivo() {
	}

	public Ejecutivo(int idEjecutivo, String rutEjecutivo, String nombreEjecutivo, String tipoEjecutivo,
			String password) {
		super();
		this.idEjecutivo = idEjecutivo;
		this.rutEjecutivo = rutEjecutivo;
		this.nombreEjecutivo = nombreEjecutivo;
		this.tipoEjecutivo = tipoEjecutivo;
		this.password = password;
	}

	public int getIdEjecutivo() {
		return idEjecutivo;
	}

	public void setIdEjecutivo(int idEjecutivo) {
		this.idEjecutivo = idEjecutivo;
	}

	public String getRutEjecutivo() {
		return rutEjecutivo;
	}

	public void setRutEjecutivo(String rutEjecutivo) {
		this.rutEjecutivo = rutEjecutivo;
	}

	public String getNombreEjecutivo() {
		return nombreEjecutivo;
	}

	public void setNombreEjecutivo(String nombreEjecutivo) {
		this.nombreEjecutivo = nombreEjecutivo;
	}

	public String getTipoEjecutivo() {
		return tipoEjecutivo;
	}

	public void setTipoEjecutivo(String tipoEjecutivo) {
		this.tipoEjecutivo = tipoEjecutivo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


	
}
