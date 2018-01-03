/*
Problem-
Given an array and a number k, find the number of contiguous sub arrays which have k odd numbers
eg
input: arr = 2,5,6,9 k = 2
output: 2
[2,5,6,9] and [5,6,9] 
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
		int[] arr = new int[] {2,5,6,9};
		int k = 2;
		
		//save all odd numbers as 1 and even as 0
		//create prefix sum array for even odd numbers seen so far(will add 1 or 0 each time)
		//2 pointer to count contiguous subarrays
		int sum = 0, ct = 0;
		int[] save = new int[1000010];
		save[0]++;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i]%2 == 0 ? 0 : 1;
			if(sum >= k)
				ct += save[sum - k];
			save[sum]++;
		}
		
		System.out.println(ct);
	}
}