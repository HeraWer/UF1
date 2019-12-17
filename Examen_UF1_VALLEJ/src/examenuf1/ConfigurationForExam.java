package examenuf1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ConfigurationForExam implements Serializable {

	private String app_Version;
	private String language;
	private Date date;
	private int num_of_questions;
	private String students_names;

	public String getApp_Version() {
		return app_Version;
	}

	public void setApp_Version(String app_Version) {
		this.app_Version = app_Version;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNum_of_questions() {
		return num_of_questions;
	}

	public void setNum_of_questions(int num_of_questions) {
		this.num_of_questions = num_of_questions;
	}

	public String getStudents_names() {
		return students_names;
	}

	public void setStudents_names(String students_names) {
		this.students_names = students_names;
	}

}
