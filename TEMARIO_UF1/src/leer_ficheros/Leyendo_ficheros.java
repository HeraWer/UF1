package leer_ficheros;

import java.io.File;
import java.util.Scanner;

public class Leyendo_ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// FIHEROS DEL QUE QUEREMOS LEER
		File fichero = new File("prueba.txt");
		Scanner s = null;
		
		try {
			// LEEMOS EL CONTENIDO DEL FICHERO
			System.out.println("...Leemos el contenido del fichero...");
			s = new Scanner(fichero);
			
			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); // GUARDAMOS LA LINEA EN UN STRING
				System.out.println(linea); // IMPRIMIMOS LA LINEA
			}
		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// CERRAMOS EL FICHERTO TANTO SI LA LECTURA HA SIDO CORRECTA O NO
			try {
				if ( s != null) {
					s.close();
				}
				}catch (Exception ex2) {
					System.out.println("Mensaje 2: " + ex2.getLocalizedMessage());
			}
		}
	}

}
