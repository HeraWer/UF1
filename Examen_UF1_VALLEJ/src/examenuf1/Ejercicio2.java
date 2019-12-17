package examenuf1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
	Scanner lector = new Scanner(System.in);
	System.out.println("Dime el nombre que le quieres poner al fichero");
	String nFichero = lector.nextLine();
		File f = new File(nFichero);
	System.out.println("Dime el contenido que quieres introducir al fichero");
	String fContenido = lector.nextLine();
	creaFicheroConContenido(f, fContenido);
			 
			 

	}
	
	public static void creaFicheroConContenido(File f, String contenido) {
		
		FileWriter fw;
		try { 
			fw = new FileWriter(f); // El file writer ya detecta si existe el fichero y si existe te lo sobreescribe.
			fw.write(contenido); 
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
