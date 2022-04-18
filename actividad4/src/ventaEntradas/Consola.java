package ventaEntradas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Consola {

	static Scanner leer = new Scanner(System.in);

	private static ArrayList<Ventas> ventas = new ArrayList<Ventas>();
	private static ArrayList<Asientos> asientos = new ArrayList<Asientos>();

	public final static int OPCION_MENU_COMPRAR_ENTRADAS = 1;
	public final static int OPCION_MENU_ENTRADAS_DISPONIBLES = 2;
	public final static int OPCION_MENU_ENTRADAS_VENDIDAS = 3;
	public final static int OPCION_MENU_VENTA_RECAUDADA = 4;
	public final static int OPCION_MENU_SALIR = 0;

	public static void main(String[] args) {

		inicializar();
		menu();
	}

	private static void menu() {

		int opcion;

		do {
			opcion = opcionMenu();
			System.out.printf("Ha seleccionado la opcion %d \n \n", opcion);
			switch (opcion) {
			case OPCION_MENU_COMPRAR_ENTRADAS:
				comprarEntrada();
				break;
			case OPCION_MENU_ENTRADAS_DISPONIBLES:
				entradasDisponibles();
				break;
			case OPCION_MENU_ENTRADAS_VENDIDAS:
				entradasVendidas();
				break;	
			case OPCION_MENU_VENTA_RECAUDADA:
				verVentaRecaudada();
				break;
			case OPCION_MENU_SALIR:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion escogida no valida. Vuelva a intentarlo");
				break;
			}
		} while (opcion != OPCION_MENU_SALIR);

	}

	private static void inicializar() {

		for (int i = 1; i <= 30; i++) {
			Asientos asiento = new Asientos(i, true, "Palco");
			asientos.add(asiento);
		}

		for (int i = 31; i <= 60; i++) {
			Asientos asiento = new Asientos(i, true, "Platea");
			asientos.add(asiento);
		}

		for (int i = 61; i <= 100; i++) {
			Asientos asiento = new Asientos(i, true, "Galeria");
			asientos.add(asiento);
		}

	}

	public static void verVentaRecaudada() {
		int valorTotal = 0;

		for (Ventas venta : ventas) {
			valorTotal += venta.getEntrada().getValor();
		}
		System.out.println("Recaudaciones: " + valorTotal);
	}

	public static void entradasVendidas() {
		System.out.println(
				"Nombre Evento | Valor Entrada | Fecha del evento | Nombre del Cliente | Numero de Asiento | Tipo de Asiento");
		System.out
				.println("-----------------------------------------------------------------------------------------\n");

		for (Ventas listaVenta : ventas) {

			System.out.print(listaVenta.getEntrada().getNomEvento() + "      |");
			System.out.print("   " + listaVenta.getEntrada().getValor() + "       |");
			System.out.print("   " + listaVenta.getEntrada().getFechaEvento() + "      |");
			System.out.print(
					"   " + listaVenta.getCliente().getNombre() + " " + listaVenta.getCliente().getApellido() + "    |");
			System.out.print("   " + listaVenta.getEntrada().getAsiento().getAsiento() + "         |");
			System.out.print("       " + listaVenta.getEntrada().getAsiento().getTipo() + "          |\n");
		}
	}

	public static void entradasDisponibles() {
		int entradasDisponiblesPalco = 30;
		int entradasDisponiblesPlatea = 30;
		int entradasDisponiblesGaleria = 40;

		for (Asientos asiento : asientos) {
			if (asiento.isEstado() == false) {
				if (asiento.getTipo() == "Palco") {
					entradasDisponiblesPalco--;
				} else if (asiento.getTipo() == "Platea") {
					entradasDisponiblesPlatea--;
				} else {
					entradasDisponiblesGaleria--;
				}
			}
		}
		System.out.println("Entradas disponibles 'Palco': " + entradasDisponiblesPalco);
		System.out.println("Entradas disponibles 'Platea': " + entradasDisponiblesPlatea);
		System.out.println("Entradas disponibles 'Galeria': " + entradasDisponiblesGaleria);
	}

	public static void comprarEntrada() {	
		leer.nextLine();
		System.out.println("Ingrese nombre del cliente");
		String nombreCliente = leer.nextLine();
		
		System.out.println("Ingrese apellido del cliente");
		String apellidoCliente = leer.nextLine();
		
		System.out.println("Ingrese RUT del cliente");
		String rutCliente = leer.nextLine();

		System.out.println("Ingrese tipo de asiento preferido");
		System.out.println("1. Palco - $80.000");
		System.out.println("2. Platea - $40.000");
		System.out.println("3. Galeria - $20.000");
		int preferenciaAsiento = leer.nextInt();
		String tipoAsiento = "";

		switch(preferenciaAsiento) {
			case 1:
				tipoAsiento = "Palco";
				break;
			case 2:
				tipoAsiento = "Platea";
				break;
			case 3:
				tipoAsiento = "Galeria";
				break;
		}
				
				Clientes cliente = new Clientes(rutCliente,nombreCliente,apellidoCliente);
				
				LocalDate fecha = LocalDate.now();

				final String NOMBRE_EVENTO = "Pelicula";
				
				final LocalDate fechaEvento = LocalDate.of(2022, 5, 1);
				boolean estadoEntrada = false;
				
				for (Asientos asiento : asientos) {
					if(asiento.getTipo() == tipoAsiento) {
			
						int valor = asiento.definicionTipoAsiento();
						
						if (asiento.isEstado() == true) {
							asiento.setEstado(false);
							Entradas entrada = new Entradas(valor,estadoEntrada,fechaEvento,NOMBRE_EVENTO,asiento);
							Ventas venta = new Ventas(fecha,entrada,cliente);
							ventas.add(venta);
							
							break;	
						}
					}
				}
		
		}

	private static int opcionMenu() {
		System.out.println("SISTEMA ENTRADAS:\n");
		System.out.println("1. COMPRAR ENTRADAS");
		System.out.println("2. ENTRADAS DISPONIBLES");
		System.out.println("3. VER ENTRADAS VENDIDAS");
		System.out.println("4. VER RECAUDACIONES");
		System.out.println("0. Salir \n");

		System.out.println("Seleccione una opcion del 1 al 4. Seleccione 0 para salir.");

		int opcionSeleccionada = leer.nextInt();
		return opcionSeleccionada;
	}
	
}
