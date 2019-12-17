package repaso_examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Main {

	private static ArrayList<Persona> pList = new ArrayList<Persona>();

	public static void main(String[] args) {

		File fDat = new File("FichPersona.dat");
		File fXml = new File("FichPersona.xml");

		generarPersonas();
		crearFicheroDat(fDat);
		generarXmlAPartirDeUnDat(fDat);
		// añadirElementoXml(fXml);
		// modificarPersonaExistente(fXml);
		// eliminarPersonaFicheroExistente(fXml);
		eliminarElementoMetodoXhon(fXml);

	}

	public static void generarPersonas() {

		// START
		// Creo objectos persona los introduzco en un arraylist para poder introducirlos
		// en un archivo.dat
		Persona p;

		p = new Persona("Jonatan", 26);
		pList.add(p);
		p = new Persona("Sergio", 30);
		pList.add(p);
		p = new Persona("Paco", 21);
		pList.add(p);

		// END

	}

	// Metodo para crear un archivo.dat
	public static void crearFicheroDat(File f) {

		try {
			if (!f.exists()) {
				System.out.println("Creando Fichero.dat");
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream ots = new ObjectOutputStream(fos);

				for (Persona persona : pList) {
					ots.writeObject(persona);
				}
				ots.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void generarXmlAPartirDeUnDat(File f) {

		File fXml = new File("FichPersona.xml");
		if (!fXml.exists()) {
			try {

				// PARA CREAR EL DOCUMENTO XL
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				DOMImplementation implementation = builder.getDOMImplementation();

				Document ficheroXML = implementation.createDocument(null, "Personas", null); // Asignar el elemento raiz

				ficheroXML.setXmlVersion("1.0");

				Element raiz = ficheroXML.getDocumentElement(); // Creamos el elemento raiz

				try {

					// START
					// Para leer
					FileInputStream fis = new FileInputStream(f);
					ObjectInputStream ois = new ObjectInputStream(fis);

					Persona p;

					while ((p = (Persona) ois.readObject()) != null) {
						// END

						Element persona = ficheroXML.createElement("Persona"); // Creamos la etiqueta Persona

						Element nombrePersona = ficheroXML.createElement("Nombre"); // Creamos la etiqueta Nombre
						Text nombrePersonaText = ficheroXML.createTextNode(p.getNombre()); // Creamos el contenido del
																							// texto nombrePersona

						nombrePersona.appendChild(nombrePersonaText); // Metemos contenido a la etiqueta nombrePersona
						persona.appendChild(nombrePersona); // Metemos la etiqueta a Persona

						Element edad = ficheroXML.createElement("Edad"); // Creamos la etiqueta Edad
						Text edadText = ficheroXML.createTextNode(String.valueOf(p.getEdad())); // Creamos el contenido
																								// de la etiqueta Edad

						edad.appendChild(edadText); // Metemos contenido a la etiqueta edad
						persona.appendChild(edad); // Metemos la etiqueta a Persona

						raiz.appendChild(persona); // Añadimos todo el contenido de Persona a Personas
					}

				} catch (Exception e) {

					ficheroXML.normalizeDocument();

					Source source = new DOMSource(ficheroXML);
					Result result = new StreamResult(new java.io.File("FichPersona.xml"));
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					transformer.transform(source, result);
					System.out.println("Fichero XML creado correctamente");

				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void añadirElementoXml(File fXml) {

		Scanner lector = new Scanner(System.in);

		System.out.println("Dime nombre");
		String nombre = lector.nextLine();
		System.out.println("Dime edad");
		int edad = lector.nextInt();

		Persona p = new Persona(nombre, edad);

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXml);

			NodeList raiz = doc.getElementsByTagName("Personas");
			Element persona = doc.createElement("Persona");

			Element nombrePersona = doc.createElement("Nombre"); // Creamos la etiqueta Nombre
			Text nombrePersonaText = doc.createTextNode(p.getNombre()); // Creamos el contenido del
																		// texto nombrePersona

			nombrePersona.appendChild(nombrePersonaText); // Metemos contenido a la etiqueta nombrePersona
			persona.appendChild(nombrePersona); // Metemos la etiqueta a Persona

			Element edadPersona = doc.createElement("Edad"); // Creamos la etiqueta Edad
			Text edadText = doc.createTextNode(String.valueOf(p.getEdad())); // Creamos el contenido
																				// de la etiqueta Edad

			edadPersona.appendChild(edadText); // Metemos contenido a la etiqueta edad
			persona.appendChild(edadPersona); // Metemos la etiqueta a Persona

			raiz.item(0).appendChild(persona); // Añadimos todo el contenido de Persona a Personas

			doc.normalizeDocument();

			Source source = new DOMSource(doc);
			Result result = new StreamResult(new java.io.File("FichPersona.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			System.out.println("Fichero XML creado correctamente");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void modificarPersonaExistente(File fXml) {

		Scanner lector = new Scanner(System.in);

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document docA = dBuilder.parse(fXml);

			// Pedimos los datos del curso donde quiere eliminar el alumno y el nombre del
			// alumno
			System.out.println("Dime el nombre de la persona a modificar");
			String oldNombre = lector.nextLine();
			System.out.println("Dime el nombre nuevo");
			String newNombre = lector.nextLine();

			// Hacemos una lista de las etiquetas Ciclo
			NodeList nodoNombre = docA.getElementsByTagName("Nombre");

			// Hacemos un for para que almacene todos los ciclos que encuentre
			for (int i = 0; i < nodoNombre.getLength(); i++) {

				if (nodoNombre.item(i).getTextContent().equals(oldNombre)) {
					nodoNombre.item(i).setTextContent(newNombre);
				}

			}

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(docA);
			StreamResult sResult = new StreamResult(fXml);
			transformer.transform(source, sResult);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void eliminarPersonaFicheroExistente(File fXml) {

		Scanner lector = new Scanner(System.in);

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document docA = dBuilder.parse(fXml);

			// Pedimos los datos para buscar el curso y el alumno que se quiere eliminar
			System.out.println("Dime el nombre de la persona a eliminar");
			String nNombre = lector.nextLine();

			// Creo dos nodos para buscar el ciclo y el alumno que quiero eliminar
			NodeList nodoPersona = docA.getElementsByTagName("Persona");

			// Hago un for para buscar el ciclo
			for (int i = 0; i < nodoPersona.getLength(); i++) {
				if (nodoPersona.item(i).getFirstChild().getTextContent().equals(nNombre)) {
					nodoPersona.item(i).getParentNode().removeChild(nodoPersona.item(i));
					break;
				}
			}

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(docA);
			StreamResult sResult = new StreamResult(fXml);

			transformer.transform(source, sResult);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void eliminarElementoMetodoXhon(File fXml) {
		
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Escribe el nombre de la persona a eliminar");
		String vNombre = lector.nextLine();
		
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(fXml);
			
			NodeList nodoPersona = doc.getElementsByTagName("Persona");
			for (int i = 0; i < nodoPersona.getLength(); i++) {
				Element elementoPersona = (Element) nodoPersona.item(i);
				if(elementoPersona.getFirstChild().getTextContent().equals(vNombre)) {
					elementoPersona.getParentNode().removeChild(elementoPersona);
					break;
				}
			}
			
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult sResult = new StreamResult(fXml);

			transformer.transform(source, sResult);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
}
