/*
Problem-
String compression--

input- aaabbcd
output- a3b2c1d1
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
		String s = "aaaabbbbbbbbbbnnnfjlll";
		Ideone i = new Ideone();
		System.out.println(s);
		System.out.println(i.compressString(s));
	}
	
	public String compressString(String s) {
		if(s.length() < 1)
			return s;
			
		int ct = 1;
		StringBuilder res = new StringBuilder();
		//runs for n times, for last char we append i - 1st char and its count
		for(int i = 1; i <= s.length(); i++) {
			if(i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
				res.append(s.charAt(i - 1) + String.valueOf(ct));
				ct = 1;
			}
			else
				ct++;
		}
		
		return res.toString();
	}
}