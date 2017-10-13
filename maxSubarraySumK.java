//Max size subarray sum = k
/*
Problem--
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
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
		int[] arr = new int[] {1,-1,5,-2,3};
		int k = 3;//ans = 4
		System.out.println(maxSubArrayLen(arr, k));
	}
	
	public static int maxSubArrayLen(int[] nums, int k) {
		int sum = 0, res = 0;
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		//sum is a continuous sum-- when sum == k, we have i + 1 numbers contributing to sum == k
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
			if(sum == k)
				res = i + 1;
			//if sum - k exists in the map-- sum(0,i) - sum(0,j) == k so sum(i,j) must be equal to k so update res to max of (i-j) or res
			else if(hm.containsKey(sum - k))
				res = Math.max(res, hm.get(i - hm.get(sum - k)));
			if(!hm.containsKey(sum - k))
				hm.put(sum, i);
		}
		
		return res;
	}
}