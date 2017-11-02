/*
Problem-
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
The cost of painting each house with a certain color is different. You have to paint all the houses such that no 
two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, 
costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, 
and so on... Find the minimum cost to paint all houses.
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
		
		//bottom up-- compute all the permutations bottom up--
		//eg- for 1st house and color 0, we get cost[1][0] + min of(cost[0][1], cost[0][2])--other two colors
		//we take permutations of color combo like 0 with 1 and 2, 1 with 0 and 2, 2 with 0 and 1 etc.
		for(int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
		}
		
		//result is min of cost[cost.length][0] or cost[cost.length][1] or cost[cost.length][2]
		int n = costs.length - 1;
		
		return Math.min(costs[n][0], Math.min(costs[n][1], costs[n][2]));
	}
}