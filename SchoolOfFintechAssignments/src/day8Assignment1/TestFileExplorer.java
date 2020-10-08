package day8Assignment1;

import java.io.File;
import java.util.Scanner;

class FileExplorer{
	
	public void listAll(String path) {
		
		File file = new File(path);
		if(! (file.exists() && file.isDirectory()) ) {
			System.out.println("No Folder exists with the given name");
			System.exit(0);
		}
		
		File files[] = file.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				System.out.println("File: "+f.getName());
			}else {
				System.out.println("Sub Folder: "+f.getName());
				listAll(f.getAbsolutePath());
			}
		}
		
	}
}

public class TestFileExplorer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path: ");
		String path = sc.nextLine();
		
		FileExplorer fe = new FileExplorer();
		fe.listAll(path);

	}

}
