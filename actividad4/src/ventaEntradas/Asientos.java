package ventaEntradas;

public class Asientos {
	
	private int asiento;
	private boolean estado;
	private String tipo;
	
	public Asientos() {
	}

	public Asientos(int asiento, boolean estado, String tipo) {
		this.asiento = asiento;
		this.estado = estado;
		this.tipo = tipo;
	}

	public int getAsiento() {
		return asiento;
	}

	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int definicionTipoAsiento() {
		if(this.tipo == "Palco") {
			return 80000;
		} else if(this.tipo == "Platea") {
			return 40000;
		} else {
			return 20000;
		}
		
	}
	
}
