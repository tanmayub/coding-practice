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
		//wiggle sort leetcode
		//A[0] <= A[1] >= A[2] <= A[3] >= A[4] <= A[5]...
		int[] arr = new int[] {3,5,2,1,6,4};
		//if index is odd and previous even indexed number is greater-- swap
		//else if index is even and prev(odd index number) is smaller-- swap
		for(int i = 1; i < arr.length; i++) {
			if(i%2 == 1) {
				if(arr[i - 1] > arr[i])
					swap(arr, i);
			}
			else if(i != 0 && arr[i - 1] < arr[i])
				swap(arr, i);
		}
 
		//print wiggle sorted array
		for(int a : arr)
			System.out.println(a);
	}
 
	public static void swap(int[] arr, int in) {
		int t = arr[in];
		arr[in] = arr[in - 1];
		arr[in - 1] = t;
	}
}