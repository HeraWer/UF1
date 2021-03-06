package botiga;

import java.util.Scanner;
import java.util.TreeMap;

public class Botiga {

	private TreeMap<String, Float> juegos = new TreeMap<String, Float>(String.CASE_INSENSITIVE_ORDER);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Botiga b = new Botiga();
		b.menu(b);

	}

	public void menu(Botiga b) { // ESTE ES EL MENU BOTIGA DONDE EL DEPENDIENTE PODRA INTRODUCIR UN JUEGO,
									// MODIFICARLO, ETC

		System.out.println();
		System.out.println("Elige una opci�n");
		System.out.println("1- Introduce un juego");
		System.out.println("2- Modifica el precio");
		System.out.println("3- Elimnar producto");
		System.out.println("4- Mostrar todos los juegos alfabeticamente");
		System.out.println("5- Salir");
		b.opcion(b);

	}

	public void opcion(Botiga b) {
		Scanner lector = new Scanner(System.in);
		// AQUI COMPRUEBO QUE EL USUARIO ESCRIBA UNA OPCION CORRECTA
		int opcion = 0;
		boolean correcto = true;
		while (correcto) {
			opcion = lector.nextInt();
			if (opcion > 0 && opcion < 6) {
				correcto = false;
			} else {
				System.out.println("La opcion selecciona no esta en ninguna de las opciones");
			}
		}

		// UNA VEZ TENEMOS DICHA OPCION LA ENVIO AL METODO ADECUADO PARA TRATARLA
		if (opcion == 1) {
			b.introducir(b, juegos);
		} else if (opcion == 2) {
			b.modificar(b, juegos);
		} else if (opcion == 3) {
			b.eliminar(b, juegos);
		} else if (opcion == 4) {
			b.mostrar(b, juegos);
		} else if (opcion == 5) {
			System.out.println("Hasta pronto");
		}
	}

	public void introducir(Botiga b, TreeMap juegos) { // METODO PARA INTRODUCIR JUEGO
		Scanner lector = new Scanner(System.in);
		System.out.println("Dime el nombre del juego");
		String n = lector.nextLine();
		if (n.equals("")) { // CON ESTE IF MIRO SI HAS INTRODUCIDO ALGO, SI ES EN BLANCO NO TE DEJA CONTINUAR
			System.out.println("No has introducido ningun juego");
			b.menu(b);
		} else {
			if (!existe(n, juegos)) { // COMPRUEBO SI EXISTE O NO EL JUEGO INTRODUCIDO
				System.out.println("Introduce el precio");
				float price = lector.nextFloat();
				b.juegos.put(n, price);
				b.menu(b);
			} else {
				System.out.println("Este juego ya existe, volviendo al menu...");
				b.menu(b);
			}
		}
	}

	public void modificar(Botiga b, TreeMap j) { // METODO PARA PODER MODIFICAR EL PRECIO
		Scanner lector = new Scanner(System.in);
		System.out.println("Dime el nombre del juego a modificar el precio");
		String n = lector.nextLine();
		if (!existe(n, juegos)) {
			System.out.println("Este juego no existe, volviendo a menu...");
		} else {
			System.out.println("Introduce el precio nuevo");
			float f = lector.nextFloat();
			b.juegos.put(n, f);
			b.menu(b);
		}
	}

	public void eliminar(Botiga b, TreeMap juegos) { // METODO PARA PODER ELIMINAR EL METODO
		Scanner lector = new Scanner(System.in);
		System.out.println("Introduce el juego que quieres eliminar");
		String n = lector.nextLine();
		if (!existe(n, juegos)) {
			System.out.println("No podemos eliminar un juego que no existe, volviendo a menu...");
		} else {
			System.out.println("Estas seguro que quieres elimnar el juego " + n + " Si o No");
			String opcion = lector.nextLine();
			if (opcion.equalsIgnoreCase("Si")) {
				b.juegos.remove(n);
				System.out.println("Juego borrado, volviendo a menu...");
				b.menu(b);
			} else if (opcion.equalsIgnoreCase("No")) {
				System.out.println("Juego no borrado, volviendo a menu...");
				b.menu(b);
			}
		}
	}

	public void mostrar(Botiga b, TreeMap juegos) { // METODO PARA MOSTRAR LA LISTA DE JUEGOS
		if (b.juegos.isEmpty()) {
			System.out.println("No existe ningun juego");
		} else {
			juegos.forEach((k, v) -> System.out.println("Juego: " + k + " Precio: " + v));
		}
		System.out.println("Volviendo al menu...");
		b.menu(b);
	}

	public boolean existe(String nom, TreeMap juegos) { // METODO PARA SABER SI EXISTE O NO EL JUEGO SOLICITADO
		if (juegos.containsKey(nom)) {
			return true;
		} else {
			return false;
		}
	}

}
