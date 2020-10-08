package day8Assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DocumentFormatter {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Filename: ");
		String fileName = sc.nextLine();
		fileName = fileName.concat(".txt");
		
		try {
			FileReader fr = new FileReader("formatFile.txt");
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(fileName);
			String s;
			
			
			while((s = br.readLine()) != null) {
				s = s.replaceAll("\\s", "");
				pw.write(s+"\n");
				pw.flush();
			}
			
			br.close();
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
