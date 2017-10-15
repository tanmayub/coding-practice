/*
Problem-
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation 
sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
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
		
		String beginWord = "hit", endWord = "cog";
		HashSet<String> hs = new HashSet<>(Arrays.asList("hot","dot","lot","dog","log","cog"));
		System.out.println(i.wordLadder(beginWord, endWord, hs));
	}
	
	public int wordLadder(String beginWord, String endWord, HashSet<String> set) {
		if(!set.contains(endWord))
			return 0;
		
		//BFS
		int res = 1;
		Queue<String> q= new LinkedList<>();
		q.offer(beginWord);
		
		while(!q.isEmpty()) {
			int n = q.size();
			for(int l = 0; l < n; l++) {
				String t = q.poll();
				char[] arr = t.toCharArray();
				for(int i = 0; i < arr.length; i++) {
					char ch = arr[i];
					//change char check if in set
					for(char c = 'a'; c <= 'z'; c++) {
						if(arr[i] == c)
							continue;
						
						arr[i] = c;
						String temp = String.valueOf(arr);
						
						if(temp.equals(endWord))
							return res + 1;
						
						if(set.contains(temp)) {
							q.offer(temp);
							set.remove(temp);
						}
					}
					arr[i] = ch;
				}
			}
			res++;
		}
		
		return 0;
	}
}