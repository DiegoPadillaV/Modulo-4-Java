
public class LiquidacionSueldo {
	
	private Colaborador colaborador;
	
	public LiquidacionSueldo(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	public int calcularMontoNoImponible() {
		return colaborador.getColacion() + colaborador.getMovilizacion();
	}
	
	public int calcularMontoImponible() {
		int montoHorasExtras = colaborador.getHoraExtras() * 7000; 
		return colaborador.getSueldoBase() + montoHorasExtras;
	}
}
