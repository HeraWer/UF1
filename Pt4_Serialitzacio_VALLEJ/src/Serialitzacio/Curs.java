package Serialitzacio;

import java.util.ArrayList;
import java.util.HashMap;

public class Curs {

	private String tutor;
	private ArrayList<Object> alumnes;
	private HashMap<Integer, String> moduls;
	
	
	public String getTutor() {
		return tutor;
	}


	public void setTutor(String tutor) {
		this.tutor = tutor;
	}


	public ArrayList<Object> getAlumnes() {
		return alumnes;
	}


	public void setAlumnes(ArrayList<Object> alumnes) {
		this.alumnes = alumnes;
	}


	public HashMap<Integer, String> getModuls() {
		return moduls;
	}


	public void setModuls(HashMap<Integer, String> moduls) {
		this.moduls = moduls;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
