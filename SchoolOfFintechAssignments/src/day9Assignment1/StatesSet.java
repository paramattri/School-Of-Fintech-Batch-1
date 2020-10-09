package day9Assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class StatesSet {

	public static void main(String[] args) {
		
		LinkedHashSet<String> states = new LinkedHashSet<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("states.txt"));
			String s;
			while((s = br.readLine()) != null) {
				states.add(s);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(states.size());
		states.remove("Delhi");
		for(String state : states) {
			if(state.startsWith("K")) {
				System.out.println(state);
			}
				
		}
		
		TreeSet<String> sortedStates = new TreeSet<String>();
		for(String state : states) {
			sortedStates.add(state);
		}
		
		for(String state : sortedStates) {
			System.out.println(state);
		}
 
	}

}
