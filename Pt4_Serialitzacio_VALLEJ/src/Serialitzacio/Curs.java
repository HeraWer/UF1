package Serialitzacio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Curs implements Serializable{

	private String tutor;
	private ArrayList alumnes;
	private HashMap moduls;
	
	
/*	public Modul getModul(String s) {
		return ;
		
	}*/
	
	public void printCurs() {
		
	}
	
	public void setCurs(String id) {
		
	}
	
	public String getTutor() {
		return tutor;
	}


	public void setTutor(String tutor) {
		this.tutor = tutor;
	}


	public ArrayList getAlumnes() {
		return alumnes;
	}


	public void setAlumnes(ArrayList alumnes) {
		this.alumnes = alumnes;
	}

	public HashMap getModuls() {
		return moduls;
	}

	public void setModuls(HashMap moduls) {
		this.moduls = moduls;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
