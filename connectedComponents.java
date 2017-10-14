/*
Problem-
Given an undirected graph, print all connected components line by line. For example consider the following graph
ex-
0--1  2
	  |
	  3--4

	This has 2 connected components--
	0 1
	2 3 4
*/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	List[] arr;

	Ideone(int vertices) {
		arr = new List[vertices];
		for(int i = 0; i < vertices; i++)
			arr[i] = new ArrayList<Integer>();
	}
	
	void addEdge(int v, int e) {
		arr[v].add(e);
		//undirected
		arr[e].add(v);
	}
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int n = 5;
		Ideone g = new Ideone(n);
		
		g.addEdge(1, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		
		g.component(n);
	}
	
	public void component(int v) {
		boolean[] visited = new boolean[v];
		int ct = 0;
		//run a dfs to count number of connected components
		//visited marks each vertex traversed as visited
		for(int i = 0; i < v; i++) {
			if(!visited[i]) {
				dfs(i, visited);
				
				System.out.println("");
				ct++;
			}
		}
		System.out.println("components: " + ct);
	}
	
	public void dfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		//traverse and go to all adjacent nodes of v
		for(Object i : arr[v]) {
			if(!visited[(int)i])
				dfs((int)i, visited);
		}
	}
}