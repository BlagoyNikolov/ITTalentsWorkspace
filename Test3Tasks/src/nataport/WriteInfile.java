package nataport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteInfile {
	public static void main(String[] args) {
		// �report-<number of report>-<date>.txt�
		String separator = File.separator;
		LocalDateTime date = LocalDateTime.now();
		Diary d = new Diary(1, 2, "Ship", 2, date);
		LocalDateTime date2 = LocalDateTime.now();
		Diary d2 = new Diary(1, 2, "Ship", 2, date);
		LocalDateTime date3 = LocalDateTime.now();
		Diary d3 = new Diary(1, 2, "Ship", 2, date);
		LocalDateTime date4 = LocalDateTime.now();
		Diary d4 = new Diary(1, 2, "Ship", 2, date);
		String fn = "report-" + d.getDate().toString() + "-1.txt";
		
		File f1 = new File("report-1.txt");
		File f2 = new File("report-2-text.txt");
		File f3 = new File("report-3-text.txt");
		File f4 = new File("report-4-text.txt");
		
		try {
			f1.createNewFile();
			f2.createNewFile();
			f3.createNewFile();
			f4.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (char c : d.toString().toCharArray()) {
			try {
				fos.write(c);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

