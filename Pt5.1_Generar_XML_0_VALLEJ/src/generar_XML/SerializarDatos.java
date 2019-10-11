package generar_XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class SerializarDatos {

	public static void main(String[] args) {

		FileOutputStream fos = null;
		ObjectOutputStream salida = null;
		Persona p;

		try {
			// CREAMOS EL FICHERO
			fos = new FileOutputStream("myPeople.dat");
			salida = new ObjectOutputStream(fos);

			// CREAMOS EL PRIMER OBJETO PERSONA
			p = new Persona("Maria", "Lopez", 36);
			// ESCRIBIMOS EL OBJETO EN EL FICHERO
			salida.writeObject(p);
			// CREAMOS EL PRIMER OBJETO PERSONA
			p = new Persona("Gustavo", "Gomez", 1);
			// ESCRIBIMOS EL OBJETO EN EL FICHERO
			salida.writeObject(p);
			// CREAMOS EL PRIMER OBJETO PERSONA
			p = new Persona("Irene", "Salas", 36);
			// ESCRIBIMOS EL OBJETO EN EL FICHERO
			salida.writeObject(p);
			// CREAMOS EL PRIMER OBJETO PERSONA
			p = new Persona("Roberto", "Mogarde", 63);
			// ESCRIBIMOS EL OBJETO EN EL FICHERO
			salida.writeObject(p);
			// CREAMOS EL PRIMER OBJETO PERSONA
			p = new Persona("Graciela", "Iglesias", 60);
			// ESCRIBIMOS EL OBJETO EN EL FICHERO
			salida.writeObject(p);
			crearXML();

			File f = new File("myPeople.xml"); // HACEMOS REFERENCIA AL FICHERO XML CON EL FILE

			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(f);

				NodeList nList = doc.getElementsByTagName("Persona");
				System.out.println("Numero de personas: " + nList.getLength());

				for (int temp = 0; temp < nList.getLength(); temp++) { // HAGO UN FOR PARA RECORRER EL ARCHIVO XML CON LA LONGITUD DE LA ETIQUETA PERSONA
					Node nNode = nList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;

						System.out.println("\nPersona: ");
						System.out
								.println("Nombre: " + eElement.getElementsByTagName("Nombre").item(0).getTextContent());
						System.out.println(
								"Apellido: " + eElement.getElementsByTagName("Apellido").item(0).getTextContent());
						System.out.println("Edad: " + eElement.getElementsByTagName("Edad").item(0).getTextContent());
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.out.println("1" + e.getMessage());
		} catch (IOException e) {
			System.out.println("2" + e.getMessage());
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (salida != null) {
					salida.close();
				}
			} catch (IOException e) {
				System.out.println("3" + e.getMessage());
			}
		}
	}

	public static void crearXML() {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();

			Document ficheroXML = implementation.createDocument(null, "Personas", null); // EL ELEMENTO RAIZ DEL
																							// DOCUMENTO ES Persona
			ficheroXML.setXmlVersion("1.0");

			Element raiz = ficheroXML.getDocumentElement();

			try {

				File fichero = new File("myPeople.dat");
				FileInputStream sacarFichero = new FileInputStream(fichero);
				ObjectInputStream leer = new ObjectInputStream(sacarFichero);

				Persona p;

				// POR CADA VUELTA EN EL BUCLE LEO UNA PERSONA Y GENERO SU CORRESPONDIENTE XML
				while ((p = (Persona) leer.readObject()) != null) {
					Element persona = ficheroXML.createElement("Persona"); // CREO UNA ETIQUETA PERSONA PARA CADA UNA DE
																			// LAS PERSONAS

					Element nombrePersona = ficheroXML.createElement("Nombre"); // CREO UNA ETIQUETA NOMBRE PARA CADA
																				// NOMBRE DE LA PERSONA
					Text textoNombrePersona = ficheroXML.createTextNode(p.getNombre()); // GENERO EL TEXTO DE LA
																						// ETIQUETA NOMBRE LEYENDO EL
																						// NOMBRE DEL FICHERO
					nombrePersona.appendChild(textoNombrePersona); // INSERTO EL TEXTO EN LA ETIQUETA nombrePersona
					persona.appendChild(nombrePersona); // INSERTO LA ETIQUETA nombrePersona EN LA ETIQUETA Persona

					Element apellidoPersona = ficheroXML.createElement("Apellido"); // CREO NA ETIQUETA APELLIDO PARA
																					// CADA APELLIDO DE LA PERSONA
					Text textoApellidoPersona = ficheroXML.createTextNode(p.getApellido()); // GENERO EL TEXTO DE LA
																							// ETIQUETA APELLIDO LEYENDO
																							// EL APELLIDO DEL FICHERO
					apellidoPersona.appendChild(textoApellidoPersona); // INSERTO EL TEXTO EN LA ETIQUETA
																		// apellidoPersona
					persona.appendChild(apellidoPersona); // INSERTO LA ETIQUETA apellidoPersona EN LA ETIQUETA Persona

					Element edadPersona = ficheroXML.createElement("Edad"); // CREO UNA ETIQUETA EDAD PARA CADA EDAD DE
																			// LA PERSONA
					Text textoEdadPersona = ficheroXML.createTextNode(Integer.toString(p.getEdad())); // GENERO EL TEXTO
																										// DE LA
																										// ETIQUETA EDAD
																										// LEYENDO LA
																										// EDAD DEL
																										// FICHERO
					edadPersona.appendChild(textoEdadPersona); // INSERTO EL TEXTO EN LA ETIQUETA edadPersona
					persona.appendChild(edadPersona); // INSERTO LA ETIQUETA edadPersona en la etiqueta Persona

					raiz.appendChild(persona);
				}

			} catch (Exception e) {
				ficheroXML.normalizeDocument(); // Esto no se si deberia generar la estructura de arbol

				Source source = new DOMSource(ficheroXML);
				Result result = new StreamResult(new java.io.File("myPeople.xml"));
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(source, result);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
