package greedycelltowers;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class GreedyCellTowersTesting {

	@Test
	void test1() {
		int[] hL = {3, 5, 8, 10, 14, 19, 21, 25, 29, 31, 37, 39, 44, 55, 59, 63, 66, 69, 75, 80};
		GreedyCellTowers.houseLocations = hL;
		int bruteTotalTowers = GreedyCellTowers.bruteSolution();
		int greedyTotalTowers = GreedyCellTowers.greedySolution();
		assertTrue(greedyTotalTowers<=bruteTotalTowers);
	}
	
	@Test
	void test2() {
		int[] hL = new int[1000000]; //keeping the same density of an average of 1 house for every 4 miles from test case 1, but with 1000000 houses and 4000000 miles
		Random rng = new Random(729); //set seed for repeatability
		for(int i = 0; i < 1000000;i++) {
			hL[i] = rng.nextInt(4000000);
		}
		Arrays.sort(hL);
		GreedyCellTowers.houseLocations = hL;
		int bruteTotalTowers = GreedyCellTowers.bruteSolution();
		int greedyTotalTowers = GreedyCellTowers.greedySolution();
		assertTrue(greedyTotalTowers<bruteTotalTowers);
		
	}
	

}
