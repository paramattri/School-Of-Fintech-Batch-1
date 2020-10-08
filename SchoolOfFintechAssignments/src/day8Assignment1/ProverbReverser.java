package day8Assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class ProverbReverser {
	
	public static StringBuffer reverseWord(String proverb) {
		
		StringBuffer str = new StringBuffer(proverb);
		StringBuffer reverseProverb = str.reverse();
		return reverseProverb;
		
	}

	public static void main(String[] args) {
		
//		/StringBuilder [] proverbs = new StringBuilder[100];
		
		
		try {
			FileReader fr = new FileReader("TopProverbs.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("ReverseProverbs.txt");
			String s;
			StringBuffer reverseProverb;
			
			while((s = br.readLine()) != null) {
				
				reverseProverb = reverseWord(s);
				fw.write(reverseProverb+"\n");
				fw.flush();
			}
			
			br.close();
			fw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader("ReverseProverbs.txt");
			BufferedReader br = new BufferedReader(fr);
			String s;
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			
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
