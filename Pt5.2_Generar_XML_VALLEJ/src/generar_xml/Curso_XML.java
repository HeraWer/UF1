package generar_xml;

import java.io.File;
import java.util.ArrayList;
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
import org.w3c.dom.Text;

public class Curso_XML {

	static Scanner lector = new Scanner(System.in);
	static Curso c = new Curso();
	static Modulo m = new Modulo();

	public static void main(String[] args) {

		boolean comprobacionC = true;

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			System.out.println("Vamos a introducir los datos de un curso.\n" + "- Nombre de curso\n" + "- Tutor\n"
					+ "- Alumnos\n" + "- Modulos\n" + "- Unidades formatias");

			// ELEMENTO RAIZ DE TODO EL XML.
			Element eRaiz = doc.createElement("IES_Esteve_Terrades");
			doc.appendChild(eRaiz);

			while (comprobacionC) { // WHILE PARA INGRESAR UN NUEVO CURSO
				// ELEMENTO CICLOS DONDE ENGLORABARA LOS DISTINTOS CICLOS.
				Element tCiclos = doc.createElement("Ciclos");
				eRaiz.appendChild(tCiclos);

				// ELEMENTO CICLO DONDE PONDREMOS TODA LA INFORMACION REFERENTE AL CICLO.
				Element tCiclo = doc.createElement("Ciclo");
				tCiclos.appendChild(tCiclo);

				// EL ATRIBUTO DEL CICLO.
				Attr attrC = doc.createAttribute("Nombre");
				attrC.setValue(introducirNombreCiclo());
				tCiclo.setAttributeNode(attrC);

				// ETIQUETA PERSONAS.
				Element personas = doc.createElement("Personas");
				tCiclo.appendChild(personas);

				// ETIQUETA TUTOR QUE ESTA DENTRO DE PERSONAS.
				Element tutor = doc.createElement("Tutor");
				Text nombreTutor = doc.createTextNode(introducirNombreTutor());
				tutor.appendChild(nombreTutor);
				personas.appendChild(tutor);

				// ETIQUETA ALUMNOS DENTRO DE ALUMNO.
				Element alumnos = doc.createElement("Alumnos");
				personas.appendChild(alumnos);

				// CREO EL METODO PARA INTRODUCIR ALUMNOS DONDE LE PIDO TODOS LOS ALUMNOS Y LOS
				// ALMACENO EN UN ARRAYLIST.
				introducirNombreAlumno();

				// HAGO UN FOR QUE RECORRA EL ARRAYLIST DONDE HE GUARDADO LOS ALUMNOS Y LOS VAYA
				// PONIENDO EN LA ETIQUETA ALUMNO.
				for (int i = 0; i < c.listAlumnos.size(); i++) {
					Element alumno = doc.createElement("Alumno");
					Text nombreAlumno = doc.createTextNode(c.listAlumnos.get(i));
					alumno.appendChild(nombreAlumno);
					alumnos.appendChild(alumno);
				}

				boolean comprobarM = true; // BOOLEANO PARA SALIR DEL WHILE DE CREAR MODULOS.
				// WHILE PARA PODER CREAR MODULOS DIFERENTES CON SUS PROFESORES Y UFS.
				while (comprobarM) {
					// CREO LA ETIQUETA MODULO DENTRO DE CICLO.
					Element modulo = doc.createElement("Modulo");
					tCiclo.appendChild(modulo);

					// CREO EL ATRIBUTO PARA MODULO DONDE PONDRE LA ID DEL MODULO.
					Attr attrM = doc.createAttribute("Mod");
					attrM.setNodeValue(introducirIdModulo());
					modulo.setAttributeNode(attrM);

					// CREO EL ELEMENTO TITULO DENTRO DE MODULO DONDE PONDRE EL TITULO COMPLETO.
					Element tituloM = doc.createElement("Titulo");
					Text nombreModulo = doc.createTextNode(introducirTituloModulo());
					tituloM.appendChild(nombreModulo);
					modulo.appendChild(tituloM);

					// CREO LA ETIQUETA PROFESORES DONDE ENGLOBARA A TODOS LOS PROFESORES DEL
					// MODULO.
					Element profeM = doc.createElement("Profesores");
					modulo.appendChild(profeM);

					// HAGO UN METODO COMO EN ALUMNOS DONDE INTRODUCIREMOS LOS PROFESORES DE LOS
					// MODULOS EN EL CASO QUE HAYA MAS DE UNO.
					introducirNombreProfesor();

					// HAGO UN FOR PARA RECORRER EL ARRAYLIST DONDE ESTARAN LOS PROFESORES
					// ALMACENADOS DEL MODULO.
					for (int i = 0; i < m.listProfesoresM.size(); i++) {
						Element profesM = doc.createElement("Profesor");
						Text nombreProfesor = doc.createTextNode(m.listProfesoresM.get(i));
						profesM.appendChild(nombreProfesor);
						profeM.appendChild(profesM);
					}

					// HAGO UNA ETIQUETA UFS DENTRO DE MODULO.
					Element ufs = doc.createElement("UFs");
					modulo.appendChild(ufs);

					// HAGO UN METODO PARA INTRODUCIR LAS UFs DE LOS MODULOS.
					introducirUFs();

					// HAGO UN FOR PARA RECORRER EL ARRAY DE UF
					for (int i = 0; i < m.listUFs.size(); i++) {
						Element uf = doc.createElement("UF");
						Text nombreUF = doc.createTextNode(m.listUFs.get(i));
						uf.appendChild(nombreUF);
						ufs.appendChild(uf);
					}

					// AQUI PREGUNTO SI QUIERE CREAR OTRO MODULO A SI QUE HAGO UN WHILE DONDE REPITO
					// TODO LO DE MODULOS CON PROFESORES Y UFS
					System.out.println("Quieres crear otro modulo? Si - No");
					String okeyM = lector.nextLine();
					if (okeyM.equalsIgnoreCase("Si")) {
						m.listProfesoresM.clear();
						m.listUFs.clear();
					} else {
						System.out.println("Ciclo creado...");
						comprobarM = false;
					}
				}

				TransformerFactory tFactory = TransformerFactory.newInstance();
				Transformer transformer = tFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult sResult = new StreamResult(new File("cursos.xml"));

				// COMPRUEBO SI QUIERE HACER OTRO CICLO
				System.out.println("Quieres introducir otro ciclo? Si - No");
				String okey = lector.nextLine();
				if (okey.equalsIgnoreCase("si")) {
					System.out.println("Nuevo curso..." + "- Nombre de curso\n" + "- Tutor\n" + "- Alumnos\n"
							+ "- Modulos\n" + "- Unidades formatias");
					c.listAlumnos.clear();
					m.listProfesoresM.clear();
					m.listUFs.clear();
					comprobacionC = true;
				} else {
					comprobacionC = false;
				}

				transformer.transform(source, sResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// METODO PARA INTRODUCIR EL NOMBRE DEL CICLO.
	public static String introducirNombreCiclo() {
		System.out.println("Introduce el nombre del ciclo");
		c.setCodigoC(lector.nextLine());
		return c.getCodigoC();
	}

	// METODO PARA INTRODUCIR EL NOMBRE DEL TUTOR.
	public static String introducirNombreTutor() {
		System.out.println("Introduce el nombre del tutor del ciclo");
		String nombreTutor = lector.nextLine();
		return nombreTutor;
	}

	// METODO PARA INTRODUCIR ALUMNOS.
	public static void introducirNombreAlumno() {
		System.out.println("Introduce nombre de alumnos del curso, cuando termines escribe un -1");
		String nAlumno = "boleano";
		do {
			nAlumno = lector.nextLine();
			if (nAlumno.equalsIgnoreCase("-1")) {
				System.out.println("Alumnos introducidos con exito.");
			} else {
				c.listAlumnos.add(nAlumno);
			}
		} while (!nAlumno.equalsIgnoreCase("-1"));
	}

	// METODO PARA INTRODUCIR LA ID DE LOS MODULOS EJEMPLO "M06".
	public static String introducirIdModulo() {
		System.out.println("Introduce el id del modulo");
		m.setCodigoM(lector.nextLine());
		return m.getCodigoM();
	}

	// METODO PARA INTRODUCIR TITULO DEL MODULO EJEMPLO "ACCESO A DATOS".
	public static String introducirTituloModulo() {
		System.out.println("Introduce el nombre del modulo");
		m.setTituloM(lector.nextLine());
		return m.getTituloM();
	}

	// METODO PARA INTRODUCIR EL NOMBRE DEL PROFESOR DE LOS MODULOS SE 1 O MAS.
	public static void introducirNombreProfesor() {
		System.out.println("Introduce el nombre de profesores del modulo, cuando termines escribe un -1");
		String nProfesor = "boleano";
		do {
			nProfesor = lector.nextLine();
			if (nProfesor.equalsIgnoreCase("-1")) {
				System.out.println("Profesores introducidos con exito");
			} else {
				m.listProfesoresM.add(nProfesor);
			}
		} while (!nProfesor.equalsIgnoreCase("-1"));
	}

	// METODO PARA INTRODUCIR UFS DE LOS MODULOS SEA 1 O MAS.
	public static void introducirUFs() {
		System.out.println("Introduce el nombre de UFs del modulo, cuando termines escribe un -1");
		String nUF = "boleano";
		do {
			nUF = lector.nextLine();
			if (nUF.equalsIgnoreCase("-1")) {
				System.out.println("UFs introducidos con exito");
			} else {
				m.listUFs.add(nUF);
			}
		} while (!nUF.equalsIgnoreCase("-1"));
	}

}
