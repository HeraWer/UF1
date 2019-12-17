package examenuf1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner lector = new Scanner(System.in);
		System.out.println("Dime el nombre del archivo a modificar");
		String fichero = lector.nextLine();
		File f = new File(fichero);
		System.out.println("Dime el parametro que quieres eliminar");
		String parametro = lector.nextLine();
		System.out.println(f.getAbsolutePath());
		eliminarCaracterFichero(f, parametro);
		
	}
	
	public static void eliminarCaracterFichero(File f, String parametro) {
		
		

		
		Scanner lector = null;
		try {
			
			lector = new Scanner(f);
			while(lector.hasNextLine()) {
				FileWriter fw = new FileWriter(f);
				fw.write(lector.nextLine().replaceAll(parametro, ""));
				fw.close();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
	} finally {
        if (lector != null) {
            lector.close();
        }
    }
		
		
	}

}
