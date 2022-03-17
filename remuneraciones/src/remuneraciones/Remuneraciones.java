package remuneraciones;

public class Remuneraciones {

	public static void main(String[] args) {

		if(args.length < 6) {
			// Si se ejecuta el programa sin argumentos
			mostrarAyuda();
		} else {

			calcularRemuneraciones(args);
		}
	}

	private static void mostrarAyuda() {
		System.out.println("Remuneraciones [sueldo-base][colacion][movilizacion][afp][salud][tipo-contrato]");
		System.out.println("Ejemplo: Remuneraciones 800000 100000 50000 habitat fonasa pi");
	}

	private static void calcularRemuneraciones(String[] args) {
		// Todas las conversiones de tipos de datos

		int sueldoBase = Integer.parseInt(args[0]);
		int colacion = Integer.parseInt(args[1]);
		int movilizacion = Integer.parseInt(args[2]);
		String afp = args[3];
		String salud = args[4];
		char tipoContrato = args[5].charAt(0);

		int montoImponible = calcularMontoImponible(sueldoBase);
		int montoNoImponible = calcularMontoNoImponible(colacion, movilizacion);
		int montoAFP = calcularMontoAfp(montoImponible, afp);
		int montoSalud = calcularMontoSalud(montoImponible, salud);
		int montoAFC = calcularAFC(montoImponible, tipoContrato);

		System.out.printf("Monto imponible: $%d\n", montoImponible);
		System.out.printf("Monto no imponible: $%d\n", montoNoImponible);
		System.out.printf("AFP: %s\n", afp);
		System.out.printf("Monto AFP: $%d\n", montoAFP);
		System.out.printf("Monto Salud: $%d\n", montoSalud);
		System.out.printf("Monto AFC: $%d\n", montoAFC);


	}

	private static int calcularMontoImponible(int sueldoBase) {
		return sueldoBase;
	}

	private static int calcularMontoNoImponible(int colacion, int movilizacion) {
		return colacion + movilizacion;
	}

	private static int calcularMontoAfp(int montoImponible, String afp) {
		switch (afp) {
		case "capital": {
			return (int) (montoImponible * 0.1144);
		}
		case "cuprum": {
			return (int) (montoImponible * 0.1144);
		}
		case "habitat": {
			return (int) (montoImponible * 0.1127);
		}
		case "planvital": {
			return (int) (montoImponible * 0.1116);
		}
		case "provida": {
			return (int) (montoImponible * 0.1145);
		}
		case "modelo": {
			return (int) (montoImponible * 0.1058);
		}
		case "uno": {
			return (int) (montoImponible * 0.1069);
		}

		}
		return 0;
	}

	private static int calcularMontoSalud(int montoImponible, String salud) {

		float UF = 31539.20f;

		switch (salud) {
		case "fonasa": {
			return (int) (montoImponible * 0.07);
		}
		case "isapre": {
			return (int) (UF * 2.7);
		}
		}
		return 0;
	}

	private static int calcularAFC(int montoImponible, char tipoContrato) {

		switch (tipoContrato) {
		case 'i': {
			return (int) (montoImponible * 0.03);
		}
		case 'f': {
			return (int) (montoImponible * 0.03);
		}
		case 'c': {
			return (int) (montoImponible * 0.03);
		}
		}
		return 0;
	}



}
