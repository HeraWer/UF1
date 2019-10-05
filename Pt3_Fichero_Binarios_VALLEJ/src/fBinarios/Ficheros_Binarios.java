package fBinarios;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ficheros_Binarios {

	static ArrayList<Becario> lBecario = new ArrayList<Becario>();
	static boolean comprobar = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner(System.in);
		Becario b = new Becario();

		System.out.println("Introduceme los siguientes datos.");
		System.out.println("Nombre i apellidos");

		b.setNombre(lector.nextLine());

		System.out.println("Introduce tu sexo, H / M");
		String auxS = null;
		while (comprobar) {
			auxS = lector.next();
			if (auxS.equalsIgnoreCase("H") || auxS.equalsIgnoreCase("M")) {
				comprobar = false;
			} else {
				System.out.println("No has introducido H - Hombre o M - Mujer");
			}

		}
		b.setSexo(auxS.toUpperCase());

		System.out.println("Introduce tu edad");
		comprobar = true;
		int auxE = 0;

		while (comprobar) {
			if (lector.hasNextInt()) {
				auxE = lector.nextInt();
				if (auxE >= 20 && auxE <= 60) {
					comprobar = false;
				} else {
					System.out.println("El rango de edad es entre 20 y 60 ( Incluidos )");
				}
			} else {
				System.out.println("No has escrito un numero entero");
				lector.next();
			}
		}
		b.setEdad(auxE);

		System.out.println("Introduce numero de suspensos del curso anterior. 0 / 4");
		comprobar = true;
		int auxSus = 0;

		while (comprobar) {
			if (lector.hasNextInt()) {
				auxSus = lector.nextInt();
				if (auxSus >= 0 && auxSus <= 4) {
					comprobar = false;
				} else {
					System.out.println(
							"Recuerdas que tus suspensos no pueden ser negativo y no puedes tener mas de 4 suspensos");
				}
			} else {
				System.out.println("No has escrito un numero entero");
				lector.next();
			}
		}
		b.setSuspensos(auxSus);

		System.out.println("Introduce si resides en una residencia familiar.");
		comprobar = true;
		String auxRF = null;

		while (comprobar) {
			auxRF = lector.next();
			if (auxRF.equalsIgnoreCase("SI") || auxRF.equalsIgnoreCase("NO")) {
				comprobar = false;
			} else {
				System.out.println("No has introducido - Si - o - No -");
			}

		}
		b.setrFamiliar(auxRF.toUpperCase());

		System.out.println("Introduce los ingresos anuales de la familia");
		comprobar = true;
		float auxIF = 0f;

		while (comprobar) {
			if (lector.hasNextFloat()) {
				auxIF = lector.nextFloat();
				comprobar = false;
			} else {
				System.out.println("No has escrito un numero");
				lector.next();
			}
		}
		b.setIngresos(auxIF);

		// COMPROBANDO QUE TODO SE GUARDABA BIEN

		/*
		 * System.out.println(b.getNombre()); System.out.println(b.getSexo());
		 * System.out.println(b.getEdad()); System.out.println(b.getSuspensos());
		 * System.out.println(b.getrFamiliar()); System.out.println(b.getIngresos());
		 */
		
		// AÑADO LA TODOS LOS ATRIBUTOS RECOGIDOS A LA LISTA
		lBecario.add(b);

		// COMPRUEBO QUE TODOS LOS DATOS SE HAN INTRODUCIDO A LA LISTA
		/* System.out.println(lBecario.toString()); */
		
		// PASO LOS DATOS DE LA LISTA A UN FICHERO BINARIO.
		try {
			FileOutputStream f = new FileOutputStream("becadades.dat");
			ObjectOutputStream dOuSt = new ObjectOutputStream(f);
			
			dOuSt.writeObject(lBecario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		backupFile("becadades.dat");
	}
	
	public static void backupFile(String origenFile) {
		File origen = new File(origenFile);
		File destino = new File("becadadesBK.dat");
		
		if(origen.exists()) {
			try {
				InputStream in = new FileInputStream(origen);
				OutputStream out = new FileOutputStream(destino);
				byte[] buf = new byte[1024];
				int len;
				while((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("El archivo no existe en la ruta especificada");
		}
	}

}
