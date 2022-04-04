package PuntoVenta;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class Venta {
	
	private LocalDateTime fecha = LocalDateTime.now();
	private ArrayList<LineaDetalle> lineasDetalle = new ArrayList<>();
	
	public Venta() {
	}
	
	public void agregarLineaDetalle(LineaDetalle lineaDetalle) {
		this.lineasDetalle.add(lineaDetalle);
	}

	public Venta(LocalDateTime fecha, ArrayList<LineaDetalle> lineasDetalle) {
		this.fecha = fecha;
		this.lineasDetalle = lineasDetalle;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public ArrayList<LineaDetalle> getLineasDetalle() {
		return lineasDetalle;
	}

	public void setLineasDetalle(ArrayList<LineaDetalle> lineasDetalle) {
		this.lineasDetalle = lineasDetalle;
	}
	
	/*
	 * public LocalDateTime fechaformateada(LocalDateTime fecha) { DateTimeFormatter
	 * fechaFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	 * LocalDateTime nuevaFecha = fechaFormateada.format(fecha); return
	 * fechaFormateada; }
	 */
	
	// Calculos
	
	public int calcularTotal() {
		int total = 0;
		for(LineaDetalle lineaDetalle : lineasDetalle) {
			total = total + lineaDetalle.calcularSubTotal();
		}
		return total;
	}
	
}
