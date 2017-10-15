/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Ideone id = new Ideone();
		
		int[] arr = new int[] {1,0,4,0,9,2,0,12,0,2,55};
		arr = id.moveZeros(arr);
		
		for(int i : arr)
			System.out.print(i + " ");
	}
	
	public int[] moveZeros(int[] arr) {
		int in = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				int t = arr[in];
				arr[in++] = arr[i];
				arr[i] = t;
			}
		}
		return arr;
	}
}