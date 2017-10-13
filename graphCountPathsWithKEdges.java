/*
Problem-
Given a directed graph and two vertices ‘u’ and ‘v’ in it, count all possible walks from ‘u’ to ‘v’ with exactly k 
edges on the walk.

The graph is given as adjacency matrix representation where value of graph[i][j] as 1 indicates that there is an edge 
from vertex i to vertex j and a value 0 indicates no edge from i to j.

For example consider the following graph. Let source ‘u’ be vertex 0, destination ‘v’ be 3 and k be 2. 
The output should be 2 as there are two walk from 0 to 3 with exactly 2 edges. The walks are {0, 2, 3} and {0, 1, 3}

0,1,1,1
0,0,0,1
0,0,0,1
0,0,0,0
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
		int[][] graph = new int[][] {{0,1,1,1}, {0,0,0,1}, {0,0,0,1}, {0,0,0,0}};
		int u = 0, v = 3, k = 2, vertices = 4;
		System.out.println(i.countwalks(graph, u, v, k, vertices));
	}
	
	//dp solution we build 3d array with source dest and k as 3 dimensions. Run time- O(k.V^3)
	public int countwalks(int[][] graph, int u, int v, int k, int n) {
		//a 3d table with 1st d as source, 2nd as dest and 3rd as # of edges
		int[][][] dp = new int[n][n][k + 1];
		
		//loop for number of edges
		for(int e = 0; e <= k; e++) {
			//for source
			for(int i = 0; i < n; i++) {
				//for dest
				for(int j = 0; j < n; j++) {
					//init
					dp[i][j][e] = 0;
					
					//base case when e = 0, each vertex will have an edge to itself
					if(e == 0 && i == j)
						dp[i][j][e] = 1;
					//when edge = 1 and there is edge between i and j 
					if(e == 1 && graph[i][j] == 1)
						dp[i][j][e] = 1;
						
					//explore adjacent edges
					if(e > 1) {
						for(int l = 0; l < n; l++) {
							if(graph[i][l] == 1)
								dp[i][j][e] += dp[l][j][e - 1];
						}
					}
				}
			}
		}
		return dp[u][v][k];
	}
}