package generar_xml;

import java.util.ArrayList;

public class Modulo {

	private String codigoM;
	private String tituloM;
	ArrayList<String> listProfesoresM = new ArrayList<String>();
	ArrayList<String> listUFs = new ArrayList<String>();

	public String getCodigoM() {
		return codigoM;
	}

	public void setCodigoM(String codigoM) {
		this.codigoM = codigoM;
	}

	public String getTituloM() {
		return tituloM;
	}

	public void setTituloM(String tituloM) {
		this.tituloM = tituloM;
	}

}
