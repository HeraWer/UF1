package examenuf1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("videojuegos.xml");
		añadirContenido(f);
		
	}
	
	public static void añadirContenido(File fXml) {



			String nombre = "The last of us 2";

			try {

				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = factory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXml);

				NodeList raiz = doc.getElementsByTagName("PlayStation4");
				
				Element nJuegos = doc.createElement("Juegos");
				Element nJuego = doc.createElement("Juego");
				Text juego = doc.createTextNode("The last of us 2");
				
				nJuego.appendChild(juego);
				nJuegos.appendChild(nJuego);
				raiz.item(0).appendChild(nJuegos);

				doc.normalizeDocument();

				Source source = new DOMSource(doc);
				Result result = new StreamResult(new java.io.File("videojuegos.xml"));
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(source, result);
				System.out.println("Fichero XML creado correctamente");

			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	

}
