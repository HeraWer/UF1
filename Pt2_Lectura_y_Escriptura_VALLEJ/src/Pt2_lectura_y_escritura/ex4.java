package Pt2_lectura_y_escritura;

import java.io.File;
import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner(System.in); // CREO UN SCANNER PARA LEER LA RUTA
		String ruta = lector.nextLine(); // LE PIDO LA RUTA AL USUARIO
		File f = new File(ruta); // CREO UN FICHERO CON LA RUTA DEL USUARIO
		Scanner leer = null; // CREO UN SCANNER PARA LEER EL FICHERO SI LO ES
		
		try {
			if(f.exists()) { // COMPRUEBO SI LA RUTA ESTA BIEN
				if(f.isFile()) { // COMPRUEBO SI ES UN FICHERO
					leer = new Scanner(f); // LLAMO AL SCANNER PARA LEER EL FICHERO
					while(leer.hasNext()) { // LEO HASTA QUE NO HAYA NADA MAS QUE LEER
						String linea = leer.nextLine(); // ALMACENO EN UN STRING CADA LINIA QUE LEO
						System.out.println(linea); // LA MUESTRO
					}
				}else { // SI NO ES UN FICHERO, ES QUE ES UN DIRECTORIO
					System.out.println("No es un fichero, es un directorio");
				}
			}else { // SI ESTA MAL LA RUTA TAMBIEN ESPECIFICO QUE NO EXISTE
				System.out.println("La ruta no existe");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
