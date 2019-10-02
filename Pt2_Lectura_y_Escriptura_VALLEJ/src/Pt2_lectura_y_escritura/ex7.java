package Pt2_lectura_y_escritura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.omg.CORBA.portable.OutputStream;

public class ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File origen = new File("origen.txt"); // CREO DOS FILE QUE REPRESENTA EL FICHERO DE ORIGEN
		File destino = new File("destino.txt"); // FICHERO AL QUE LE COPIO LO DEL ORIGEN
		try {
			if(origen.exists()) {
		InputStream in = new FileInputStream(origen); //ABRO UN INPUTSTREAM PARA PODER REALIZAR LA LECTURA
		FileOutputStream out = new FileOutputStream(destino); //ABRO UN OUTPUTSTREAM PARA PODER HACER LA ESCRITURA LEIDA EN EL INPUTSTREAM
		
			// REALIZO LA LECTURA Y ESCRITURA MIENTRAS EXISTAN DATOS EN EL STREAM
			byte[] buf = new byte[1024]; 
			int len;
			
			while((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			// CIERRO LOS STREAM
			in.close();
			out.close();
			}else {
				System.out.println("El archivo no se encuentra en la ruta señalizada");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
