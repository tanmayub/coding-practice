/*
Problem-
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
check if these edges form a valid tree.

Analysis-
This problem can be converted to finding a cycle in a graph. It can be solved by using DFS (Recursion) or BFS (Queue)
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
		int n = 5;
		int[][] edges = new int[][] {{0,1},{0,2},{0,3},{1,4}}; //true--valid tree
		//int[][] edges = new int[][] {{0,1},{1,2},{2,3},{1,3},{1,4}}; //false--not a valid tree
		
		System.out.println("DFS : " + i.validTree(n, edges)); //DFS
		System.out.println("BFS : " + i.validTree1(n, edges)); //BFS
		System.out.println("Union-Find : " + i.validTree2(n, edges)); //union-find
	}
	
	public boolean validTree2(int n, int[][] edges) {
		//Union-Find
		//creating n disjoint sets
		int[] nums = new int[n];
		Arrays.fill(nums, -1);
		
		for(int i = 0; i < edges.length; i++) {
			int x = find(nums, edges[i][0]);
			int y = find(nums, edges[i][1]);
			
			//if both vertices are in same group--there is cycle
			if(x == y)
				return false;
			
			//stores link from u to v
			nums[x] = y;
		}
		
		return edges.length == n - 1;
	}
	
	public int find(int[] nums, int e) {
		//recursively tries to find connection of e, if e == -1, it is the parent of tree
		if(nums[e] == -1)
			return e;
		
		return find(nums, nums[e]);
	}
	
	public boolean validTree1(int n, int[][] edges) {
		//BFS
		//convert problem to finding cycles in a graph problem
		HashMap<Integer, ArrayList<Integer>> graph = createGraph(n, edges);
		
		boolean[] visited = new boolean[n];
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		//add each element to queue and mark it visited-- if we pop something from the queue which is visited--return false
		//if not visited, mark it and go into its adjacency list-- if nodes are not visited add to queue
		while(!q.isEmpty()) {
			int v = q.poll();
			if(visited[v])
				return false;
			
			visited[v] = true;
			for(int i : graph.get(v)) {
				if(!visited[i])
					q.offer(i);
			}
		}
		
		//check all vertices visited
		for(boolean v : visited) {
			if(!v)
				return false;
		}
		
		return true;
	}
	
	public boolean validTree(int n, int[][] edges) {
		//DFS
		//convert problem to finding cycles in a graph problem
		HashMap<Integer, ArrayList<Integer>> graph = createGraph(n, edges);
		
		boolean[] visited = new boolean[n];
		if(!dfs(0, -1, graph, visited))
			return false;
		else {//check all vertices visited
			for(boolean v : visited) {
				if(!v)
					return false;
			}
		}
		
		return true;
	}
	
	//creates graph
	public HashMap<Integer, ArrayList<Integer>> createGraph(int n, int[][] edges) {
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		for(int i = 0; i < n; i++)
			graph.put(i, new ArrayList<Integer>());
			
		for(int[] i : edges) {
			graph.get(i[0]).add(i[1]);
			graph.get(i[1]).add(i[0]);
		}
		
		return graph;
	}
	
	public boolean dfs(int cur, int parent, HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited) {
		//if node visited--cycle, return false
		if(visited[cur])
			return false;
		
		visited[cur] = true;
		
		//recur to all adj vertices of cur
		for(int i : graph.get(cur)) {
			//check if parent is not in adj list and recurring to i returns false-- if both are true return false
			//not a valid tree
			if(i != parent && !dfs(i, cur, graph, visited))
				return false;
		}
		
		return true;
	}
}