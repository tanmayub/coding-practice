/*
Problem-
Given two strings A and B, determine if they are both one edit distance apart.

1 char modified or 1 char present in A but not in B or vice-versa

eg
abc = abcd -- true
adcd = abdd -- false
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
		String a = "geekes", b = "geek";
		System.out.println(i.checkOneEditDist(a, b));
	}
	
	//more modular answer-- almost the same as the one below
	/*public boolean checkOneEditDist(String a, String b) {
		if(Math.abs(a.length() - b.length()) > 1)
			return false;
			
		if(a.length() == b.length())
			return checkOneMod(a, b);
		if(a.length() > b.length())
			return checkOneDel(a, b);
			
		return checkOneDel(b, a);
	}
	
	public boolean checkOneMod(String a, String b) {
		int ct = 0;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i))
				ct++;
			
			if(ct > 1)
				return false;
		}
		
		return true;
	}
	
	public boolean checkOneDel(String a, String b) {
		for(int i = 0; i < a.length() && i < b.length(); i++) {
			if(a.charAt(i) != b.charAt(i))
				return a.substring(i + 1).equals(b.substring(i));
		}
		
		return true;
	}*/
	
	public boolean checkOneEditDist(String a, String b) {
		int m = a.length(), n = b.length();
		if(Math.abs(m - n) > 1)
			return false;
		for(int i = 0; i < Math.min(m, n); i++) {
			if(a.charAt(i) == b.charAt(i))
				continue;
			if(m == n) //one modified char
				return a.substring(i + 1).equals(b.substring(i + 1));
			if(m > n) //extra deleted char in a ie not in b
				return a.substring(i + 1).equals(b.substring(i));
			else //deleted char in b
				return a.substring(i).equals(b.substring(i + 1));
		}
		
		//just last char different-- case abcd, abc
		return m != n;
	}
}