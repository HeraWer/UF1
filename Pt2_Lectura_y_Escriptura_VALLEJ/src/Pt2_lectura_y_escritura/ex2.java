package Pt2_lectura_y_escritura;

import java.io.File;
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TAMBIEN FUNCIONA CON LA RUTA ABSOLUTA
		// C:\\Users\\vcjon\\Desktop\\AMS2\\M6_Acceso_a_datos\\UF1\\Pt2_Lectura_y_Escriptura_VALLEJ\\
		File fichero = new File("src\\Pt2_lectura_y_escritura\\ReadFileJava.java");
		Scanner s = null;

		try {
			System.out.println("...Leemos nuestra clase java...");
			s = new Scanner(fichero);

			// LEEMOS CADA LINEA DEL FICHERO
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				System.out.println(linea);
			}

		} catch (Exception e) {
			System.out.println("Mensaje: " + e.getMessage());
		} finally {
			try {
				s.close();
			} catch (Exception e2) {
				System.out.println("Mensaje 2: " + e2.getMessage());
			}
		}
	}
}
