package Pt2_lectura_y_escritura;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ex3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("myFiles\\ficheroRenombrado.txt"); // CREO UN FILE PARA PODER SELECCIONAR CON EL BOOLEAN PARA
																// PODER HACER EL BOOLEAN Y EL RENAMETO
		boolean directorio = new File("myFiles").mkdir(); // AQUI CREO EL DIRECTORIO myFiles

		boolean fichero1 = new File("myFiles\\fichero1.txt").createNewFile(); // AQUI CREO EL FICHERO1 DENTRO DE myFiles
		
		if (!f.exists()) { // ARREGLADO AHORA SI EXISTE NO LO CREA PORQUE SABEMOS QUE EL FICHERO2 ES AHORA EL ficheroRENOMBRADO
			boolean fichero2 = new File("myFiles\\fichero2.txt").createNewFile(); // AQUI CCREO EL FICHERO2 DENTRO DE
																					// myFiles
		}

		boolean renombrar = new File("myFiles\\fichero2.txt").renameTo(f); // RENOMBRO EL FICHERO DE LA RUTA
		// DATO IMPORTANTE EL BOOLEAN YA DETECTA SI EXISTE O NO EL FICHERO AL
		
		
		// MODIFICARLO VUELVE A CREAR EL FICHERO2 PORQUE YA NO EXISTE
		File fDirectory = new File("myFiles"); // CREO EL FILE PARA EL DIRECTORIO myList PARA PODER LISTAR SU CONTENIDO
		System.out.println(Arrays.toString(fDirectory.list())); // LISTO SU CONTENIDO

		File f1 = new File("myFiles\\fichero1.txt"); // CREO UN FILE DEL FICHERO PARA PODER BORRAR
		f1.delete(); // BORRO EL FICHERO

		System.out.println(Arrays.toString(fDirectory.list())); // LISTO SU CONTENIDO
	}

}
