import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemuneracionesTest {

	@Test
	void testCalculoRemuneracionNoImponible() {
		Colaborador colaborador = new Colaborador();
		colaborador.setSueldoBase(500000);
		colaborador.setMovilizacion(50000);
		colaborador.setColacion(60000);
		LiquidacionSueldo liquidacionSueldo = new LiquidacionSueldo(colaborador);
		int montoNoImponible = liquidacionSueldo.calcularMontoNoImponible();
		assertEquals(montoNoImponible, 110000);
	}
	
	@Test
	void testCalculoRemuneracionNoImponible2() {
		Colaborador colaborador = new Colaborador();
		colaborador.setSueldoBase(500000);
		colaborador.setMovilizacion(0);
		colaborador.setColacion(0);
		LiquidacionSueldo liquidacionSueldo = new LiquidacionSueldo(colaborador);
		int montoNoImponible = liquidacionSueldo.calcularMontoNoImponible();
		assertEquals(montoNoImponible, 0);
	}
	
	@Test
	void testCalculoRemuneracionImponible() {
		Colaborador colaborador = new Colaborador();
		colaborador.setSueldoBase(500000);
		colaborador.setHoraExtras(2);
		LiquidacionSueldo liquidacionSueldo = new LiquidacionSueldo(colaborador);
		int montoImponible = liquidacionSueldo.calcularMontoImponible();
		assertEquals(montoImponible, 514000);
	}
	
}
