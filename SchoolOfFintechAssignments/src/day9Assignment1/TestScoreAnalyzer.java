package day9Assignment1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class ScoreAnalyzer{
	private LinkedList<Integer> runsData;
	public ScoreAnalyzer() {
		this.runsData = new LinkedList<Integer>();
	}
	
	public LinkedList<Integer> getRunsData() {
		return runsData;
	}

	public void addRunsToList(int run) {
		runsData.add(run);
	}
	
	public float runRate() {
		int sum = 0;
		for(int i = 0;i < runsData.size(); i++) {
			sum += runsData.get(i);
		}
		float rRate =  (float)sum / 50;
		return rRate;
	}
	
	public int lowestRunsScored() {
		LinkedList<Integer> sortedRunsData = runsData;
		Collections.sort(sortedRunsData);
		return sortedRunsData.get(0);
	}
	
	public void displayRuns() {
		for(int run : runsData) {
			System.out.print(run+" ");
		}
		System.out.println();
	}
}

public class TestScoreAnalyzer {

	public static void main(String[] args) {
		
		ScoreAnalyzer sa = new ScoreAnalyzer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Runs: ");
		String input = sc.nextLine(); 
		String[] runs = input.split(" ");
		for(int i = 0; i < runs.length; i++) {
			sa.addRunsToList(Integer.parseInt(runs[i]));
		}
		sa.displayRuns();
		System.out.println("Run Rate: "+sa.runRate());
		System.out.println("Lowest Runs: "+sa.lowestRunsScored());
		System.out.println("Count of players who batted: "+sa.getRunsData().size());
	}

}
