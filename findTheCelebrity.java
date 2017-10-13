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
		int n = 4;
		System.out.println(i.findCelebrity(n));
	}
	
	public boolean knows(int x, int y) {
		int[][] arr = new int[][] {{1,1,1,1},{0,1,0,0},{1,1,1,0},{0,1,0,1}};
		return arr[x][y] == 1;
	}
	
	public int findCelebrity(int n) {
		//first loop decides the celebrity--if celeb knows any i then current cleb must not be a 
		//celeb, i could be a celeb, change celeb to i- at the end of this loop we decide a celeb
		int celeb = 0;
		for(int i = 0; i < n; i++) {
			if(knows(celeb, i))
				celeb = i;
		}

		//cross checking if celeb does not know anyone and everyone knows celeb
		for(int i = 0; i < celeb; i++) {
			if(knows(celeb, i))
				return -1;
		}
		for(int i = 0; i < n; i++) {
			if(!knows(i, celeb))
				return -1;
		}
		return celeb;
	}
}