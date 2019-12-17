package examenuf1;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		ArrayList<String> students = new ArrayList<String>();
		
		
		ConfigurationForExam cfe;
		//cfe = new ConfigurationForExam("app_Version = ", "language = es", "date = 13/12/2019", "num_of_questions = 3", "students_names = Sergio,Erik,Joan,Adrian,Javi,Marc,Sean,David");
		 
		try {
			File f = new File("examConfig.conf");
			FileInputStream fis = new FileInputStream(f);
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
