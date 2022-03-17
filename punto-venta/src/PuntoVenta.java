import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PuntoVenta {
	
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	private static ArrayList<Venta> ventas = new ArrayList<Venta>(); 
	
	public final static int OPCION_MENU_SALIR = 7;
	public final static int OPCION_MENU_CARGA_PRODUCTOS = 6; // Constante
	public final static int OPCION_MENU_PAGAR = 5;
	public final static int OPCION_MENU_AGREGAR_PRODUCTO_AL_CARRO = 4;
	public final static int OPCION_MENU_ELIMINAR = 3;
	public final static int OPCION_MENU_VER = 2;
	public final static int OPCION_MENU_CREAR = 1;
	
	public static void main(String[] args) {
		
		int opcionSeleccionada;
		
		do {
			opcionSeleccionada = menu();
			switch(opcionSeleccionada) {
				case OPCION_MENU_CREAR:
					crearProducto();
					break;
				case OPCION_MENU_VER:
					verProductos();
					break;
				case OPCION_MENU_ELIMINAR:
					eliminarProducto();
					break;
				case OPCION_MENU_AGREGAR_PRODUCTO_AL_CARRO:
					agregarProductosAlCarro();
					break;
				case OPCION_MENU_PAGAR:
					pagarProducto();
					break;
				case OPCION_MENU_CARGA_PRODUCTOS:
					cargarProductosIniciales();
					break;
			}
		} while(opcionSeleccionada != OPCION_MENU_SALIR); // Mientras la opcion NO sea SALIR
		
		System.out.printf("Selecciono la opcion %d", opcionSeleccionada);

	}
	
	private static void crearProducto() {
		
		Scanner leerProducto = new Scanner(System.in);
		
		System.out.println("Ingresar codigo del producto:");
		
		String codigoProducto =  leerProducto.nextLine();
		
		System.out.println("Ingresar nombre del producto:");
		
		String nombreProducto =  leerProducto.nextLine();
		
		System.out.println("Ingresar precio del producto:");
		
		int precioProducto =  leerProducto.nextInt();
		
		Producto productoNuevo = new Producto(codigoProducto, nombreProducto, precioProducto);
		productos.add(productoNuevo);

	}

	private static void verProductos() {
		
		System.out.println("\nPRODUCTOS\n====================\n");
		
		for(Producto producto : productos) {
			System.out.printf("Codigo: %s Producto: %s Precio: %d %n"
					, producto.getCodigo()
					, producto.getNombre()
					, producto.getPrecio()
			);
		}
		
	}

	private static void cargarProductosIniciales() {
		productos.add(new Producto("1","collar", 300));
		productos.add(new Producto("2","anillo", 100));
		productos.add(new Producto("3","pendientes", 200));
	}
	
	private static void eliminarProducto() {
		
		System.out.println("Escriba el codigo del producto a eliminar");
		
		Scanner leerCodigo = new Scanner(System.in);
		
		String codigo = leerCodigo.nextLine();
		
		Producto producto = buscarProducto(codigo);
		if (producto != null) {
				productos.remove(producto);
				System.out.printf("Se ha eliminado correctamente producto: %s %n%n", producto.getNombre());
			} else {
				System.out.printf("No se encontro ningun producto con el codigo %s %n%n", codigo);
		}
		
	}
	
	private static Producto buscarProducto(String codigo) {
		
		for (Producto p : productos) {
			if(p.getCodigo().equalsIgnoreCase(codigo)) {
				return p;
			}
		}
		return null;
	}

	private static void agregarProductosAlCarro() {
		
		Venta venta = new Venta();
		boolean seguirAgregandoProductos = true;
		
		do {
			// 1. Muestro todos los productos
			verProductos();
			// 2. Pregunto al usuario el codigo del producto que quiere comprar
			System.out.println("Escriba el codigo del producto que desea comprar:");
			Scanner leer = new Scanner(System.in);
			String codigo = leer.next();
			Producto producto = buscarProducto(codigo);
			
			// para buscar el producto segun el codigo
			// 3. Pregunto al usuario la cantidad que quiere comprar
			System.out.println("Escriba la cantidad que desea comprar:");
			int cantidad = leer.nextInt();
			
			// 4. Crear linea de detalle 
			LineaDetalle lineaDetalle = new LineaDetalle(cantidad, producto);
			venta.agregarLineaDetalle(lineaDetalle);
			
			// 4. Pregunto al usuario si quiere agregar mas productos
			System.out.println("Desea agregarr mas productos al carro: [si/no]");
			String seguirAgregandoProductosStr = leer.next();
			seguirAgregandoProductos = seguirAgregandoProductosStr.equalsIgnoreCase("SI") ? true : false;
		} while(seguirAgregandoProductos);
		
		Scanner leer = new Scanner(System.in);
		System.out.println("La venta fue pagada? [si/no]");
		boolean ventaPagada = leer.nextLine().equalsIgnoreCase("SI") ? true : false;
		
		if(ventaPagada) {
			ventas.add(venta);
		}
	}

	private static void pagarProducto() {
		
		
	}

	private static int menu() {
		
		
		System.out.println("MENU PUNTO DE VENTA\n===================\n");
		System.out.println("1. Crear Producto");
		System.out.println("2. Ver Productos");
		System.out.println("3. Eliminar Producto");
		System.out.println("4. Agregar Producto al Carro");
		System.out.println("5. Pagar");
		System.out.println("6. Cargar productos iniciales");
		System.out.println("7. SALIR");
		
		System.out.println("\nPor favor digite la opcion deseada:");
		
		Scanner leer = new Scanner(System.in);
		
		int opcionSeleccionada = leer.nextInt();
		
		return opcionSeleccionada;
	}
	
	
	

}
