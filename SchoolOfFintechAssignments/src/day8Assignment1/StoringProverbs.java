package day8Assignment1;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

class ProverbCollection{
	//static int l = 0;
	public static void storeProverb(String proverb) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("TopProverbs.txt",true);
		BufferedOutputStream bos = new BufferedOutputStream(fos); 
		
		byte[] array = proverb.getBytes();
		//l += array.length;
		bos.write(array);
		bos.write("\n".getBytes());
		bos.flush();
		bos.close();
		
		
	}
}

public class StoringProverbs {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the proverb: ");
		
		while(true) {
			String proverb = sc.nextLine();
			if(proverb.equals("STOP"))
				break;
			else {
				try {
					ProverbCollection.storeProverb(proverb);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
