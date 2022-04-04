package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PuntoVenta.LineaDetalle;
import PuntoVenta.Producto;
import PuntoVenta.Venta;

class VentaTest {

	@Test
	void test() {
		
		Producto p1 = new Producto("aaa", "AAA", 100);
		Producto p2 = new Producto("bbb", "BBB", 200);

		
		LineaDetalle ld1 = new LineaDetalle(1, p1);
		LineaDetalle ld2 = new LineaDetalle(2, p2);
		
		Venta venta = new Venta();
		venta.agregarLineaDetalle(ld1);
		venta.agregarLineaDetalle(ld2);
		
		assertEquals(500, venta.calcularTotal());
		
		// ------------------------------------------
		
		LineaDetalle ld3 = new LineaDetalle(10, p1);
		LineaDetalle ld4 = new LineaDetalle(3, p2);
		
		Venta venta2 = new Venta();
		venta2.agregarLineaDetalle(ld3);
		venta2.agregarLineaDetalle(ld4);
		
		assertEquals(1600, venta2.calcularTotal());
		
	}

}
