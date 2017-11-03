/*
Problem-
Product of an array except self

input - [1,2,3,4]
output - [24,12,8,6]
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
		int[] arr = new int[] {1,2,3,4};
		Ideone i = new Ideone();
		arr = i.productExceptSelf(arr);
		
		for(int k : arr)
			System.out.print(k + " ");
	}
	
	public int[] productExceptSelf(int[] arr) {
		int[] res = new int[arr.length];
		res[0] = 1;
		//start products for i places by multiplying i - 1 numbers
		for(int i = 1; i < arr.length; i++)
			res[i] = res[i - 1] * arr[i - 1];
		
		int pr = 1;
		//complete products by multiplying with increasing factor pr and current number at ith index
		for(int i = arr.length - 1; i >= 0; i--) {
			res[i] = res[i] * pr;
			//pr will hold multiplication from n to i + 1 numbers--res[i] will have 0 to i - 1, 
			//multiplying both will give us desired result for res[i] = [0 to i - 1] * [n to i + 1]
			pr = pr * arr[i];
		}
		
		return res;
	}
}