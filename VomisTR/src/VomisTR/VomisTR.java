package VomisTR;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class VomisTR {

	private static ArrayList<Cliente> clientes = new ArrayList<>();
	private static ArrayList<Ejecutivo> ejecutivos = new ArrayList<>();
	private static ArrayList<Producto> productos = new ArrayList<>();
	private static ArrayList<Ticket> ticket = new ArrayList<>();

	private static Ejecutivo ejecutivoConectado;

	static Scanner leer = new Scanner(System.in);
	
	private static int opcionSeleccionada;
	private final static short OPCION_MENU_CREAR_TICKET = 1;
	private final static short OPCION_MENU_VER_TICKET = 2;
	private final static short OPCION_MENU_SALIR = 3;

	public static void main(String[] args) {

		init(); // Carga de datos simulada para la ejecucion de la aplicacion

		if (autenticar()) {
			do {
				mostrarMenu();
			} while (opcionSeleccionada != OPCION_MENU_SALIR);
		} else {
			System.out.println("Usuario y/o contrasena incorrectos. Cerrando la aplicacion.");
			System.exit(0);
		}



	}

	private static boolean autenticar() {

		System.out.println("Por favor ingresar su rut:");

		String usuario = leer.next();

		System.out.println("Por favor ingresar su password:");

		String password = leer.next();

		// Recorro los ejecutivos en BD hasta encontrar el que tenga usuario y contrasena iguales
		// a las ingresadas a traves de la consola, sino cierre la aplicacion

		for(Ejecutivo ejecutivo : ejecutivos ) {
			// Recorro cada ejecutivo en el array
			if(ejecutivo.getRutEjecutivo().equalsIgnoreCase(usuario) 
					&& ejecutivo.getPassword().equals(password)) {
				// Hasta encontrar uno que tenga el mismo RUT y password ingresados por consola
				// Si lo encuentro, guardo como atributo el ejecutivo conectado para  uso posterior
				ejecutivoConectado = ejecutivo;
				System.out.println("Hola " + ejecutivoConectado.getNombreEjecutivo());
				return true; // Me salgo del loop
			}
		}

		// Si cuando termina el loop for, NO se encuentra ningun ejecutivo la aplicacion terminara
		return false;
	}

	private static void init() {
		// BD de clientes

		clientes.add(new Cliente(1, "1-9", "Diego Padilla", "985942571", "dpadilla@gmail.com"));
		clientes.add(new Cliente(2, "2-0", "Daniel Padilla", "985942323", "daniP@gmail.com"));

		// BD de ejecutivos

		ejecutivos.add(new Ejecutivo(1, "1-8", "Juan Perez", "Atencion", "1234"));
		ejecutivos.add(new Ejecutivo(2, "2-8", "Andrea Miranda", "Soporte", "4321"));

		// BD de productos

		productos.add(new Producto("F300", "Fibra 300"));
		productos.add(new Producto("F600", "Fibra 600"));
		productos.add(new Producto("F900", "Fibra 900"));
		productos.add(new Producto("M100", "Movil 100"));
		productos.add(new Producto("M200", "Movil 200"));
		productos.add(new Producto("M300", "Movil 300"));


	}

	private static void crearTicket() {

		// Verificar si es cliente de la empresa
		// 1. Preguntar RUT al cliente
		
		// 2. Preguntar cual es el servicio que presenta problemas
		
		// 3. Preguntar cual es el problema
		
		// 4. Preguntar al ejecutivo si pudo solucionarlo
		
		// 4.1 Si pudo solucionarlo escribir la solucion y Cerrar el caso
		
		// 4.2 Si no pudo solucionar el caso, derivar a un ejecutivo de soporte
		
		// 
		


	}

	private static void verTicket() {

		System.out.println("\nTicket\n====================\n");

		for(Ticket ticket : ticket) {
			System.out.print("Numero Ticket: " + ticket.getNumeroTicket() + "\nFecha: " + ticket.getFechaHora() +  "\nDescripcion: " + ticket.getDescripcionProblema()
			+ "\nEstado: " + ticket.getEstado() +  "\nSolucion: " + ticket.getSolucionProblema() + "\n");
		}


	}

	private static void mostrarMenu() {
		System.out.println("MENU ATENCION AL CLIENTE\n===================\n");
		System.out.println("1. Crear Ticket");
		System.out.println("2. Ver Ticket");
		System.out.println("3. Salir");

		System.out.println("\nPor favor digite la opcion deseada:");

		int opcionSeleccionada = leer.nextInt();

		switch(opcionSeleccionada) { 
			case OPCION_MENU_CREAR_TICKET: 
				crearTicket(); 
				break; 
			case OPCION_MENU_VER_TICKET:
				verTicket(); 
				break; 
		} 


	}

}
