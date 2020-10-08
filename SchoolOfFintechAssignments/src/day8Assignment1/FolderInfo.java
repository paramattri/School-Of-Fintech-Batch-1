package day8Assignment1;

import java.io.File;
import java.io.IOException;

public class FolderInfo {
	
	public static void printDirectory(String folderPath) {
		File file = new File(folderPath);
		if(! (file.exists() && file.isDirectory()) ) {
			System.out.println("No Folder exists with the given name");
			System.exit(0);
		}
		
		File[] files = file.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				System.out.println("File: "+f.getName()+"\nAbsolute File Path: "+f.getAbsolutePath()+"\nFolder Path: "+f.getParent());
			}else {
				System.out.println("Directory: "+f.getName()+"\nPath: "+f.getParent());
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		FolderInfo.printDirectory("C:\\Users\\Param\\Desktop\\Major_Project_Final_Docs");

	}

}
