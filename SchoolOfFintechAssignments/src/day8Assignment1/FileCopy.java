package day8Assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("first.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("second.txt");
			String s;
			
			while( (s = br.readLine()) != null ) {
				fw.write(s);
				fw.flush();
			}
			
			br.close();
			fw.close();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
