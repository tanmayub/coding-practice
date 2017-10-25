/*
Problem-
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 
3 characters left in the file. By using the read4 API, implement the function int read(char *buf, int n) 
that reads n characters from the file.

if n is greater than file length, the code should return actual bytes read
if n is less than file length, it should reaturn length of file read
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
		char[] buf = new char[] {'h','e','l','l','o',' ', 'w','o','r','l','d'};
		int n = 15;
		
		Ideone i = new Ideone();
		System.out.println(i.read(buf, n));
	}
	
	public int read(char[] buf, int n) {
		boolean eof = false;
		int r = 0;
		//where bytes get read and store after read4 returns
		//temp is not used in this code but it will be used in acutal one
		char[] temp = new char[4];
		//this will not be used in actual code
		char[] copyBuf = new char[n];
		while(!eof && r < n) {
			//get ct of chars read
			int ct = read4(buf, r);
			//find out if end of file
			eof = ct < 4;
			//actual count of chars read
			ct = Math.min(ct, n - r);
			
			//copy buf
			for(int i = 0; i < ct; i++) //in actual code below line would be buf[r++] = temp[i];
				copyBuf[r] = buf[r++];
		}
		return r;
	}
	
	public int read4(char[] buf, int index) {
		//it should read file and return at most 4 chars or less(EOF) from the file
		//for demo purpose, I have taken index i
		return Math.min(index + 4, buf.length - index);
	}
}