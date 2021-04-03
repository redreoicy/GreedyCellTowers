package greedycelltowers;
import java.util.*;

public class GreedyCellTowers {
	static LinkedList<Integer> towerLocations = new LinkedList<>();
	static int[] houseLocations;

	public static void main(String[] args) {
		Random rng = new Random(13377734); //set seed for repeatability
		houseLocations = new int[10000000];
		for(int i = 0; i < 10000000;i++) {
			houseLocations[i] = rng.nextInt(40000000);
		}
		int newLineCounter = 0;
		Arrays.sort(houseLocations);
		bruteSolution();
		greedySolution();
		System.out.println("Every 10000th tower is at: ");
		for(int x : towerLocations) {
			if(newLineCounter++ == 10000) {
				newLineCounter = 0;
				System.out.print(x + " ");
			}
		}
		

	}

	static public int bruteSolution() {
		towerLocations.clear();
		int lastHouse = houseLocations[houseLocations.length - 1];
		for(int i = 9; i<lastHouse; i+=18) {
			towerLocations.add(i);
		}
		//System.out.println("There are towers at ");
		//for(int x : towerLocations) {
		//	System.out.print(x + " ");
		//}
		System.out.println("There are " + towerLocations.size() + " total towers using a basic solution.");
		return towerLocations.size();
	}
	
	static public int greedySolution() {
		towerLocations.clear();
		int currentTower = -1000;
		for(int i = 0; i<houseLocations.length; i++) {
			if(houseLocations[i] - 9 > currentTower) {
				towerLocations.add(houseLocations[i]+9);
				currentTower = houseLocations[i]+9;
			}
		}
		System.out.println("There are " + towerLocations.size() + " total towers using a greedy algorithm.");
		return towerLocations.size();
	}
	
}
