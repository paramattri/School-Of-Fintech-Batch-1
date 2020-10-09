package day9Assignment1;

import java.util.Map.Entry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreCard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<String, Integer> runs = new TreeMap<String, Integer>();
		System.out.println("Enter Runs Scored: ");
		String input = sc.nextLine();
		String[] runSplit = input.split(" ");
		String runScored[];
		for(String scores : runSplit) {
			runScored = scores.split("-");
			runs.put(runScored[0], Integer.parseInt(runScored[1]));
		}
		
		
		//for(int i = 0; i < run.length; i = i + 2) {
			//runs.put(run[i], Integer.parseInt(run[i + 2]));
		//}
		
		System.out.println("Players who batted: ");
		for(Entry<String, Integer> entry : runs.entrySet()) {
			System.out.println(entry.getKey());
		}
		
		System.out.println("Scores by Players: ");
		for(Entry<String, Integer> entry : runs.entrySet()) {
			System.out.println(entry.getValue());
		}
		
		int sum = 0;
		for(Entry<String, Integer> entry : runs.entrySet()) {
			sum += entry.getValue();
		}
		
		System.out.println("Total Score: "+sum);
	
		int arr[] = new int[runs.size()];
		int c = 0;
		for(Entry<String, Integer> entry : runs.entrySet()) {
			arr[c] = entry.getValue();
			c++;
		}
		
		Arrays.sort(arr);
		int highestScore = arr[arr.length - 1];
		String highestScoreName = null;
		for(Entry<String, Integer> entry : runs.entrySet()) {
			if(entry.getValue() == highestScore) {
				highestScoreName = entry.getKey();
			}
		}
		System.out.println("Name of Highest Scorer: "+highestScoreName);
		System.out.println("Runs Scored by Dhoni: "+runs.get("Dhoni"));

	}

}
