package Pt2_lectura_y_escritura;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ex6 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in); // SCANNER DE ENTRADA DE TEXTO
		PrintWriter f = null; // CREAMOS UN PRINTWRITER PORQUE DEJA HACER LOS SALTOS DE LINEA
		
		try {
			System.out.println("Escribe unas 10 lineas y tendran un salto de linea cada una al darle enter");
			f = new PrintWriter("saltoLinea.txt"); // LE DIGO EL FICHERO DONDE TIENE QUE ESCRIBIR
			for(int i = 0; i < 10; i++) { // FOR PARA LAS 10 LINEAS
				f.println(lector.nextLine()); // ESCRIBO EN EL FICHERO 
			}
			f.close(); // CIERRO FICHERO
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

// APUNTES PROPIOS PARA QUE EL USUARIO NO ENTRE ESPACIOS EN BLANCO

/* String frase = lector.nextLine();
	while(frase.equals(""){
		syso("Cadena no validad");
		frase = lector.nextLine();
	}
	
	f.println(lector.nextLine());
	*/
