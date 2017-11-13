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
		int[][] arr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		Ideone i = new Ideone();
		int[] res = i.traverseMatrix(arr);
		System.out.println("Paths: " + res[0] + ": MaxSumPath: " + res[1]);
	}
	
	// 1.given a m*n matrix with weight w[i][j], a robot can only go right or down. 
	//Find the total number of paths and also find the path that maximize the sum of weights. 

	/*[[1,2,3],[4,5,6],[7,8,9]] 3*3 matrix
	
	1(0,0) 2 3
	4 5 6
	7 8 9(2,2)
	
	1+2+3+6+9*/

	public int[] traverseMatrix(int[][] arr) {
	    int[] res = new int[2];
	    if(arr.length <= 0)
	        return res;
	    
	    int m = arr.length, n = arr[0].length;
	    
	    //number of paths
	    int[][] dp = new int[m][n];
		dp[0][0] = 1;
	    
	    for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++) {
				if(i == 0 && j > 0) {//1st col
					arr[i][j] = arr[i][j] + arr[i][j - 1]; //coming from left
					dp[i][j] = 1;
				}
				else if(j == 0 && i > 0) {//1st row
					arr[i][j] = arr[i][j] + arr[i - 1][j]; //coming from above
					dp[i][j] = 1;
				}
				else if(i > 0 && j > 0) {
					arr[i][j] = arr[i][j] + Math.max(arr[i - 1][j], arr[i][j - 1]); //max from above or from left
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
	    }
	    res[0] = dp[m - 1][n - 1];
		res[1] = arr[m - 1][n - 1]; //final output in bottom right corner for max weight
	    
	    return res;
	}
}