/*
Problem-
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house 
with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a [n x k] (in paint house 1, it was [n x 3])
cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] 
is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses
*/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Ideone i = new Ideone();
		
		int[][] costs = new int[][] {{7,5,10},{3,6,1},{8,7,4},{6,2,9},{1,4,7},{2,3,6}};
		
		System.out.println(i.paintHouses(costs));
	}
	
	public int paintHouses(int[][] costs) {
		if(costs.length == 0)
			return 0;
		
		int min1 = -1, min2 = -1;
		for(int i = 0; i < costs.length; i++) {
			//prev1 and prev 2 help preventing same color for adj houses--
			//stores min1 and min2 for previous house which is index of lowest cost of color
			int prev1 = min1, prev2 = min2;
			min1 = -1;
			min2 = -1;
			
			//for k colors, find min1 and min2(colors) having lowest costs for ith house
			for(int j = 0; j < costs[i].length; j++) {
				if(j != prev1) //avoids same color for adjacent houses
					costs[i][j] += prev1 < 0 ? 0 : costs[i - 1][prev1];
				else
					costs[i][j] += prev2 < 0 ? 0 : costs[i - 1][prev2];
					
				//find index of 1st and 2nd smallest cost
				//if current cost is lower than cost of min1, update min1 and min2
				if(min1 < 0 || costs[i][j] < costs[i][min1]) {
					min2 = min1;
					min1 = j;
				}
				else if(min2 < 0 || costs[i][j] < costs[i][min2]) //update min2 if current cost is less than cost of min2
					min2 = j;
			}
		}
		
		//return the accumulated cost of house coloring
		return costs[costs.length - 1][min1];
	}
}