package VomisTR;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ticket {
	
	private int numeroTicket;
	private LocalDateTime fechaHora;
	private String descripcionProblema;
	private String estado;
	private String solucionProblema;
	private Cliente clientes = new Cliente();
	private Ejecutivo ejecutivo = new Ejecutivo();
	private Ejecutivo ejecutivoDerivado = new Ejecutivo();
	private Producto productos = new Producto();
	
	public final static String ESTADO_ABIERTO = "ABIERTO";
	public final static String ESTADO_CERRADO = "CERRADO";
	public final static String ESTADO_DERIVADO = "DERIVADO";
	
	public Ticket() {
	}

	public Ticket(int numeroTicket, LocalDateTime fechaHora, String descripcionProblema, String estado,
			String solucionProblema, Cliente clientes, Ejecutivo ejecutivo, Ejecutivo ejecutivoDerivado,
			Producto productos) {
		this.numeroTicket = numeroTicket;
		this.fechaHora = fechaHora;
		this.descripcionProblema = descripcionProblema;
		this.estado = estado;
		this.solucionProblema = solucionProblema;
		this.clientes = clientes;
		this.ejecutivo = ejecutivo;
		this.ejecutivoDerivado = ejecutivoDerivado;
		this.productos = productos;
	}

	public int getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getDescripcionProblema() {
		return descripcionProblema;
	}

	public void setDescripcionProblema(String descripcionProblema) {
		this.descripcionProblema = descripcionProblema;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSolucionProblema() {
		return solucionProblema;
	}

	public void setSolucionProblema(String solucionProblema) {
		this.solucionProblema = solucionProblema;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public Ejecutivo getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(Ejecutivo ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public Ejecutivo getEjecutivoDerivado() {
		return ejecutivoDerivado;
	}

	public void setEjecutivoDerivado(Ejecutivo ejecutivoDerivado) {
		this.ejecutivoDerivado = ejecutivoDerivado;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}

	
	

	
}
