package Pt2_lectura_y_escritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ex8 {

	private TreeMap<String, Float> juegos = new TreeMap<String, Float>(String.CASE_INSENSITIVE_ORDER);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ex8 b = new ex8();
		b.menu(b);

	}

	public void menu(ex8 b) { // ESTE ES EL MENU BOTIGA DONDE EL DEPENDIENTE PODRA INTRODUCIR UN JUEGO,
								// MODIFICARLO, ETC

		System.out.println();
		System.out.println("Elige una opción");
		System.out.println("1- Introduce un juego");
		System.out.println("2- Modifica el precio");
		System.out.println("3- Elimnar producto");
		System.out.println("4- Mostrar todos los juegos alfabeticamente");
		System.out.println("5- Guardar y Salir");
		System.out.println("6- Mostrar contenido fichero");
		b.opcion(b, juegos);

	}

	public void opcion(ex8 b, TreeMap tm) {
		Scanner lector = new Scanner(System.in);
		// AQUI COMPRUEBO QUE EL USUARIO ESCRIBA UNA OPCION CORRECTA
		int opcion = 0;
		boolean correcto = true;
		while (correcto) {
			opcion = lector.nextInt();
			if (opcion > 0 && opcion < 7) {
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
			b.fichero();
			System.out.println("Se a almacenado todo correctamente en el fichero, hasta pronto");
		}else if (opcion == 6) {
			b.mostrarFichero();
		}
	}

	public void introducir(ex8 b, TreeMap juegos) { // METODO PARA INTRODUCIR JUEGO
		Scanner lector = new Scanner(System.in);
		System.out.println("Dime el nombre del juego");
		String n = lector.nextLine();
		if (n.equals("")) { // CON ESTE IF MIRO SI HAS INTRODUCIDO ALGO, SI ES EN BLANCO NO TE DEJA
							// CONTINUAR
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

	public void modificar(ex8 b, TreeMap j) { // METODO PARA PODER MODIFICAR EL PRECIO
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

	public void eliminar(ex8 b, TreeMap juegos) { // METODO PARA PODER ELIMINAR EL METODO
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

	public void mostrar(ex8 b, TreeMap juegos) { // METODO PARA MOSTRAR LA LISTA DE JUEGOS
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

	public void fichero() {
		File ficheroBotiga = new File("ficheroBotiga.txt");
		PrintWriter pw = null;
		String lista;
		try {
			pw = new PrintWriter(ficheroBotiga);
			for(Map.Entry<String, Float> joc : juegos.entrySet()) {
				lista = joc.getKey() + "\t" + joc.getValue();
				pw.println(lista);
				pw.flush();
			}
				
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void mostrarFichero() {
		File ficheroBotiga = new File("ficheroBotiga.txt");
		TreeMap<String, Float> mostrar = new TreeMap<String, Float>(String.CASE_INSENSITIVE_ORDER);
		try {
			Scanner lector = new Scanner(ficheroBotiga);
			int contador = 1;
			String palabra = "";
			String precio = "";
			Float precio2 = 0f;
			while(lector.hasNext()) {
				if(contador == 1) {
				palabra = lector.next();
				contador++;
				}else {
					precio = lector.next();
					contador--;
				}
				if(palabra != "" && precio != "") {
					mostrar.put(palabra, Float.parseFloat(precio));
					palabra = "";
					precio = "";
				}
			}
			System.out.println("Mostrando el TreeMap con informacion del fichero");
			mostrar.forEach((k, v) -> System.out.println("Juego: " + k + " Precio: " + v));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
