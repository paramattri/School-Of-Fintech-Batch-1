package day8Assignment1;

import java.io.File;
import java.io.IOException;

public class TestFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("D:\\Badminton");
		file.mkdir();
		
		File file1 = new File(file,"singles.txt");
		file1.createNewFile();
		
		File file2 = new File(file,"dubbles.txt");
		file2.createNewFile();
		
		File file3 = new File(file,"Courts");
		file3.mkdir();
	
		File file4 = new File(file3,"smash.dat");
		file4.createNewFile();
		
		File file5 = new File(file,"doubles.txt");
		file2.renameTo(file5);
		
		file1.delete();

	}

}
