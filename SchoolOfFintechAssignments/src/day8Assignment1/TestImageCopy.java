package day8Assignment1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

class CopyImage{
	public static boolean copyImage(File file) {
		
		int width = 963;
		int height = 640;
		BufferedImage image = null;
		try {
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(file);
			
			int index = file.getName().lastIndexOf('.');
			File output_file = new File(file.getParentFile()+"/"+file.getName().substring(0, index)+"_copy.jpeg");
			ImageIO.write(image, "jpg", output_file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
}

public class TestImageCopy {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Image Path: ");
		String path = sc.nextLine();
		File file = new File(path);
		if(! file.exists()) {
			System.out.println("File Not Found!!");
			System.exit(0);
		}
		int index = path.lastIndexOf('.');
		String extension = path.substring(index + 1);
		if(! extension.equals("jpg")) {
			System.out.println("File Format Not Supported.");
			System.exit(0);
		}
		
		boolean copied = CopyImage.copyImage(file);
		if(copied)
			System.out.println("Image Copied Successfully");
		else
			System.out.println("Image Copy Unsuccessful");
	}

}
