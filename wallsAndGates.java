/*
Problem-
You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume 
that the distance to a gate is less than 2147483647.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, 
it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
  
Output-
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
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
		int[][] arr = new int[][] {{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE}, 
				   {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
				   {Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
				   {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
		arr = i.wallsAndGates(arr);
		
		for(int[] k : arr) {
			for(int j : k)
				System.out.print(j + " ");
			System.out.println("");
		}
	}
	
	public int[][] wallsAndGates(int[][] arr) {
		int m = arr.length, n = arr[0].length;
		boolean[][] visited = new boolean[m][n];
		
		//usual backtracking-- find 0(gate) and for each element not -1 surrounding the current, find and update distance
		//if current dist in the cell is greter than dist
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
			    if(arr[i][j] == 0) //backtrack from each gate--calc dist to each non gate element
				backtrack(i, j, m, n, arr, 0, visited);
			}
		}
		
		return arr;
	}

	public void backtrack(int i, int j, int m, int n, int[][] arr, int dist, boolean[][] visited) {
		//if i or j are not valid or arr[i][j] is a wall(-1) or dist is gretaer than already updated dist at arr[i][j]
		//return
		if(i < 0 || j < 0 || i >= m || j >= n || arr[i][j] == -1 || visited[i][j] || dist > arr[i][j])
			return;
			
		//mark visited true-- update dist and recur in 4 directions--after coming out of recursion
		//mark not visited-- classic backtrack
		visited[i][j] = true;
		arr[i][j] = dist;
		
		backtrack(i + 1, j, m, n, arr, dist + 1, visited);
		backtrack(i - 1, j, m, n, arr, dist + 1, visited);
		backtrack(i, j + 1, m, n, arr, dist + 1, visited);
		backtrack(i, j - 1, m, n, arr, dist + 1, visited);
		
		visited[i][j] = false;
	}
}
