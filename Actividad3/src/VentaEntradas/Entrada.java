package VentaEntradas;

import java.util.Scanner;

public class Entrada {
	private int asientosLibres = 30;
	private int totalRecaudado = 0;
	
	public Entrada() {
		
	}

	public Entrada(int asientosLibres, int totalRecaudado) {
		this.asientosLibres = asientosLibres;
		this.totalRecaudado = totalRecaudado;
	}

	public int getAsientosLibres() {
		return asientosLibres;
	}

	public void setAsientosLibres(int asientosLibres) {
		this.asientosLibres = asientosLibres;
	}

	public int getTotalRecaudado() {
		return totalRecaudado;
	}

	public void setTotalRecaudado(int totalRecaudado) {
		this.totalRecaudado = totalRecaudado;
	}
	
	
}
