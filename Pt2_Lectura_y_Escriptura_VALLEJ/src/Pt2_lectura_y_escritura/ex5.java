package Pt2_lectura_y_escritura;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		 FileWriter f = null; // CON EL FILEWRITER PUEDO ESCRIBIR EN FICHEROS
		 String frase = "Yo sólo puedo mostrarte la puerta, tú eres quien la tiene que atravesar."; // ALMACENO LA FRASE PARA ESCRIBIR EN EL FICHERO EN UN STRING
		 
		 try { // CREO UN TRY CATCH PARA POSIBLES ERRORES
			f = new FileWriter("frasesMatrix.txt"); // CREO UN FILEWRITER CON EL FICHERO, A SI CUANDO ESCRIBA SI NO EXISTE LO CREARA
			f.write(frase); // ESCRIBO LA FRASE EN EL FICHERO
			f.close(); // CIERRO EL FICHERO
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
