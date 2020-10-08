package day8Assignment1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ProverbReader {

	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream(new File("TopProverbs.txt"));
			//BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			//int i;
			//while(bis.available() > 0) {
				//System.out.println((char)bis.read());
			//}
			//while((temp = dis.readLine() != null)) {
				//System.out.println(temp);
			//}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
