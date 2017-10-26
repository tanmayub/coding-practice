/*
Problem-
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note--
find is a global element for which I'm trying to find successor and predecessor
*/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int v) {
			val = v;
		}
	}
	
	static TreeNode find = null;
	
	public TreeNode createTree() {
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(12);
		find = root.left;
		root.right = new TreeNode(17);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(14);
		root.right.right = new TreeNode(20);
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(10);
		root.left.right.left = new TreeNode(13);
		
		return root;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Ideone i = new Ideone();
		//inorder successor/predecessor
		System.out.println("Successor: " + i.inorderSuccessor(i.createTree()).val);
		System.out.println("Predecessor: " + i.inorderPredecessor(i.createTree()).val);
	}
	
	//O(log n) and O(1) space
	public TreeNode inorderSuccessor(TreeNode root) {
		TreeNode suc = null;
		
		//go right when root val is less than or equal to find value
		//we enter right subtree of find, we go as left as possible 
		//while saving successor as current root
		while(root != null) {
			if(find.val < root.val) {
				suc = root;
				root = root.left;
			}
			else
				root = root.right;
		}
		
		return suc;
	}
	
	//O(log n) space and time
	//go left till root value is less than or equal to find value--
	//if value root value is greater than find
	//we're entering right subtree of find and we want to go as left as we possibly 
	//can to get answer. if there is no left child, we return root
	/*public TreeNode inorderSuccessor(TreeNode root) {
		if(root == null)
			return null;
		if(root.val <= find.val)
			return inorderSuccessor(root.right);
		else {
			TreeNode left = inorderSuccessor(root.left);
			return (left != null) ? left : root;
		}
	}*/
	
	//O(log n) and O(1) time
	//same concept as successor
	public TreeNode inorderPredecessor(TreeNode root) {
		TreeNode pre = null;
		while(root != null) {
			if(find.val > root.val) {
				pre = root;
				root = root.right;
			}
			else
				root = root.left;
		}
		
		return pre;
	}
}