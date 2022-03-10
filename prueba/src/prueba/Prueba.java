package prueba;

public class Prueba {
	
	public static void main(String[] args) {
		
		String ingredientePrincipal = args[0];
		
		switch(ingredientePrincipal) {
			case "tomate":
				System.out.println("Picar tomate, sal y aceite.");
				break;
			case "huevo":
				System.out.println("En un sarten poner un huevo a freir.");
				break;
			default:
				System.out.println("Abrir lata atun, picar cebolla y limon.");
		}
	}

}
