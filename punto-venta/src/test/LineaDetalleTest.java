package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import PuntoVenta.LineaDetalle;
import PuntoVenta.Producto;

class LineaDetalleTest {

	@Test
	void test() {
		Producto p1 = new Producto();
		p1.setPrecio(100);
		
		Producto p2 = new Producto();
		p2.setPrecio(500);
		
		LineaDetalle ld = new LineaDetalle();
		ld.setCantidad(2);
		ld.setProducto(p1);
		
		assertEquals(200, ld.calcularSubTotal());
		
		LineaDetalle ld2 = new LineaDetalle();
		ld2.setCantidad(2);
		ld2.setProducto(p2);
		
		assertEquals(1000, ld2.calcularSubTotal());
	}

}
