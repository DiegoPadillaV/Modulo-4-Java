package frases;


/**
 * 
 * @author Deico
 * Frases [option]
 * [option] puede ser "todos", para mostrar todas las frases
 * Si no se entrega el argumento [option], muestra una frase aleatoria
 */

public class Frases {
	
	public static String[] frases = {
			"Nada cambia si nada cambiar",
			"Esta comprobado que el abejorro, aerodinamicamente, no puede volar su peso, tamano y cuerpo, solo que el no lo sabe.",
			"Las personas no son recordadas por el numero de veces que fracasan, sino por el numero de veces que tienen exito."
	};

	public static void main(String[] args) {
		
		if (args.length == 0) {
			mostrarFraseAleatoria();
		} else {
			mostrarTodasLasFrases();
		}
	}
	
	public static void mostrarFraseAleatoria() {
			double numeroAleatorio = Math.random() * frases.length;
			int numeroAleatorioEntero = (int)numeroAleatorio;
			System.out.println(frases[numeroAleatorioEntero]);
		
	}
	
	public static void mostrarTodasLasFrases() {
		for(int i = 0; i < frases.length; i++) {
			System.out.println(frases[i]);
		}
	}

}
