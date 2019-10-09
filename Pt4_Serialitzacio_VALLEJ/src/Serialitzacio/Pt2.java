package Serialitzacio;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pt2 extends Curs {

	private HashMap cursos;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pt2 main = new Pt2();
		String id = "";
		Modul m = new Modul();
		String ruta = "Pt2.dat";
		File f = new File(ruta);
		Scanner lectorU = new Scanner(System.in);
		boolean comprobar = true;
		int opcio = 0;
		
		while (comprobar) {
			System.out.println("Escull una opcio de les seguents indicant el seu numero.");
			System.out.println("1. Afegir un nou curs");
			System.out.println("2. Modificar un curs");
			System.out.println("3. Mostrar dades curs");
			System.out.println("4. Eliminar curs");
			System.out.println("5. Sortir");

			if (lectorU.hasNextInt()) {
				opcio = lectorU.nextInt();
				if (opcio > 0 && opcio < 6) {
					comprobar = false;
				} else {
					System.out.println("Aquesta opcio no existeix");
				}
			} else {
				System.out.println("No has escrito un numero entero");
				lectorU.next();
			}
			
			switch (opcio) {
			case 1:
				Curs c = new Curs();
				
				

				break;
			case 2:
				System.out.println("Introdueix el nom del curs que vols modificar");
				String cursId = lectorU.nextLine();
				main.setCurs(cursId);
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				System.out.println("Has sortit correctament.");
				break;
			}
		}

	}

	public void dadesIn(File f) {

	}

	public void dadesOut(File f) {

	}

	public HashMap<String, Curs> getCursos() {
		return cursos;
	}

}
