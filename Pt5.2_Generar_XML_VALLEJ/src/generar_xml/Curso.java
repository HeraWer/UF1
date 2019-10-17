package generar_xml;

import java.util.ArrayList;

public class Curso {

	private String codigoC;
	private String tutor;
	ArrayList<String> listAlumnos = new ArrayList<String>();

	public String getCodigoC() {
		return codigoC;
	}

	public void setCodigoC(String codigoC) {
		this.codigoC = codigoC;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

}
