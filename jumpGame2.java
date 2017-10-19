/*
Problem-
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps. Print numbers at index i where you'll hop.

For example:
Given array A = [1,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
output- 1 3
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
		int[] arr = new int[] {1,3,1,1,4};
		for(int in : arr)
			System.out.print(in + " ");
		
		System.out.println();
		System.out.println(i.jumpGame3(arr));
	}
	
	public String jumpGame3(int[] nums) {
		int en = 0, far = 0;
		StringBuilder res = new StringBuilder();
        for(int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if(i == en) {
                res.append(nums[i] + " ");
                en = far;
            }
        }
        return res.toString();
	}
}