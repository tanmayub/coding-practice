/*
Problem-
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
For example:
Given a binary tree {1,2,3,4,5}
		 1
		/\
	   2  3
	  /\
	 4  5
	 
		||
		||
	   \||/
		\/
	
		 4
		/\
	   5  2
		 /\
		3  1
*/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	 //Definition for a binary tree node.
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Ideone i = new Ideone();
		TreeNode root = i.buildTree();
		
		root = i.upsideDown(root);
		
		i.preorder(root);
	}
	
	public TreeNode buildTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		return root;
	}
	
	public TreeNode upsideDown(TreeNode root) {
		if(root == null)
			return null;
		
		return upsideDownHelper(root, null);
	}
	
	//if root is null--return parent-- create temp node while recurring to left most child
	//the first returned node down the recursion tree is the new root--
	//if parent is not null make current root left = parent.right(sibling) and make parent as root.right
	public TreeNode upsideDownHelper(TreeNode root, TreeNode parent) {
		if(root == null)
			return parent;
		
		TreeNode temp = upsideDownHelper(root.left, root);
		root.left = parent == null ? null : parent.right;
		root.right = parent;
		
		return temp;
	}
	
	//display tree
	public void preorder(TreeNode root) {
		if(root == null)
			return;
			
		System.out.print(root.val + " ");
		preorder(root.left);
		preorder(root.right);
	}
}