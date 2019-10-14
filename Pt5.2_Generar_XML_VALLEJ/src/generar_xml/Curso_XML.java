package generar_xml;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Curso_XML {
	
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		
			
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			Element eRaiz = doc.createElement("IESEsteveTerrades");
			doc.appendChild(eRaiz);

			Element tCiclo = doc.createElement("Ciclo");
			eRaiz.appendChild(tCiclo);
			
			Attr attr = doc.createAttribute("Nombre");
			attr.setValue("DAM");
			tCiclo.setAttributeNode(attr);
			
			Element modulo = doc.createElement("Modulo");
			tCiclo.appendChild(modulo);
			
			Element personas = doc.createElement("Personas");
			modulo.appendChild(personas);
			
			Element tutor = doc.createElement("Tutor");
			personas.appendChild(tutor);
			
			Element alumnos = doc.createElement("Alumnos");
			personas.appendChild(alumnos);
			
			Element alumno = doc.createElement("Alumno");
			alumnos.appendChild(alumno);
			
			
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult sResult = new StreamResult(new File("cursos.xml"));
			
			transformer.transform(source, sResult);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
