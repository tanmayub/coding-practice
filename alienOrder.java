/*
Problem-
Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.

eg- 
words[] = {"baa", "abcd", "abca", "cab", "cad"}
in this dictionary d comes before a, b comes before d and c comes after a
edges added are
b-a, d-a, a-c, b-d
output- b d a c
*/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	class Graph {
		List[] arr;
		
		Graph(int n) {
			arr = new List[n];
			for(char i = 0; i < n; i++)
				arr[i] = new ArrayList<Integer>();
		}
		
		public void addEdge(int u, int v) {
			arr[u].add(v);
		}
		
		public String topoSort(int[] visited) {
			Stack<Character> st = new Stack<>();
			
			//traverse each vertex, if visited == 0-- not visited
			//						   visited == 1-- visited
			//						   visited == -1-- not in the graph
			for(int i = 0; i < 26; i++) {
				if(visited[i] == 0)
					topoSortUtil(i, visited, st);
			}
			
			StringBuilder res = new StringBuilder();
			while(!st.isEmpty())
				res.append(st.pop() + " ");
				
			return res.toString();
		}
		
		public void topoSortUtil(int v, int[] visited, Stack<Character> st) {
			visited[v] = 1;
			
			//traverse adj list of vertex v
			for(Object i : arr[v]) {
				if(visited[(int)i] == 0)
					topoSortUtil((int)i, visited, st);
			}
			
			//add vertex v to stack
			st.push((char)(v + 'a'));
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Ideone i = new Ideone();
		String[] words = new String[] {"baa","abcd","abca","cab","cad"};
		
		/*char[] res = i.alienOrder(words);
		
		for(char c : res)
			System.out.print(c + " ");*/
		
		System.out.println(i.alienOrder(words));
	}
	
	public /*char[]*/ String alienOrder(String[] words) {
		Graph g = new Graph(26);
		int[] visited = new int[26];
		//-1 for char not exists
		Arrays.fill(visited, -1);
		
		//build graph
		for(int i = 0; i < words.length - 1; i++) {
			for(int c : words[i].toCharArray())//char exists but not visited
				visited[c - 'a'] = 0;
				
			String w1 = words[i], w2 = words[i + 1];
			for(int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
				if(w1.charAt(j) != w2.charAt(j)) {//add edge between 2 chars
					//the char that differs and comes earlier in the list comes earlier in the final order
					g.addEdge(w1.charAt(j) - 'a', w2.charAt(j) - 'a');
					break;
				}
			}
		}
		
		//topo sort
		return g.topoSort(visited);
		
		/*String s = g.topoSort(visited);
		
		char[] res = new char[s.split(" ").length()];
		int i = 0;
		for(char c : s.split(" "))
			res[i++] = c;
		
		return res;*/
	}
}